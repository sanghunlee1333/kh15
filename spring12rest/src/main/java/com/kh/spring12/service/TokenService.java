package com.kh.spring12.service;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.spring12.configuration.TokenProperties;
import com.kh.spring12.dao.AccountTokenDao;
import com.kh.spring12.dto.AccountDto;
import com.kh.spring12.dto.AccountTokenDto;
import com.kh.spring12.error.TargetNotFoundException;
import com.kh.spring12.vo.ClaimVO;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TokenService {

	@Autowired
	private TokenProperties tokenProperties;
	
	@Autowired
	private AccountTokenDao accountTokenDao;
	
	public String generateAccessToken(AccountDto accountDto) {
		//시간계산
		Calendar c = Calendar.getInstance();
		Date now = c.getTime(); //현재시각
		c.add(Calendar.MINUTE, tokenProperties.getAccessLimit());
		Date limit = c.getTime(); //만료시각
		
		//토큰생성
		return Jwts.builder()
				.signWith(tokenProperties.getKey())
				.expiration(limit)
				.issuer(tokenProperties.getIssuer())
				.issuedAt(now)
				.claim("userId", accountDto.getAccountId())
				.claim("userLevel", accountDto.getAccountLevel())
			.compact();
	}

	public String generateRefreshToken(AccountDto accountDto) {
		//시간계산
		Calendar c = Calendar.getInstance();
		Date now = c.getTime(); //현재시각
		c.add(Calendar.MINUTE, tokenProperties.getRefreshLimit()); //2주
		Date limit = c.getTime(); //만료시각
		
		//토큰생성
		String tokenValue = Jwts.builder()
				.signWith(tokenProperties.getKey())
				.expiration(limit)
				.issuer(tokenProperties.getIssuer())
				.issuedAt(now)
				.claim("userId", accountDto.getAccountId())
				.claim("userLevel", accountDto.getAccountLevel())
			.compact();
		
		//토큰에 들어갈 정보들을 DB에 저장하는 코드
		AccountTokenDto accountTokenDto = accountTokenDao.insert(
				AccountTokenDto.builder()
					.accountTokenTarget(accountDto.getAccountId()) //발행한 대상
					.accountTokenValue(tokenValue) //발행한 토큰
				.build()
		);
		
		//토큰반환
		return tokenValue;
	}
	
	public ClaimVO parse(String token) {
		Claims claims = (Claims) Jwts.parser()
									.verifyWith(tokenProperties.getKey())
									.requireIssuer(tokenProperties.getIssuer())
								.build()
									.parse(token)
									.getPayload();
		
		return ClaimVO.builder()
							.userId((String)claims.get("userId")) //다운캐스팅
							.userLevel((String)claims.get("userLevel")) //다운캐스팅
						.build();
	}

	public ClaimVO parseBearerToken(String bearerToken) {
		//토큰 형태 검사
		if(bearerToken == null)
			throw new TargetNotFoundException("토큰 없음");
		if(bearerToken.startsWith("Bearer ") == false) {
			throw new TargetNotFoundException("토큰 오류");
		}
		
		String token = bearerToken.substring(7);
		return parse(token);
	}

	//Bearer 토큰의 유효성 검사 (유효하면 발급내역을 삭제)
	public boolean checkBearerToken(ClaimVO claimVO, String bearerToken) {
		String token = bearerToken.substring(7);
		AccountTokenDto accountTokenDto = 
				accountTokenDao.findByTargetAndToken(
					AccountTokenDto.builder()
						.accountTokenTarget(claimVO.getUserId()) //아이디와
						.accountTokenValue(token) //토큰으로
					.build()
				); //찾으세요
		if(accountTokenDto != null) { //인증 성공(로그인 갱신 성공)이라면
			accountTokenDao.delete(accountTokenDto); //내역 삭제
			return true; 
		}
		return false;
	}

	public String generateAccessToken(ClaimVO claimVO) {
		return generateAccessToken(AccountDto.builder()
					.accountId(claimVO.getUserId())
					.accountLevel(claimVO.getUserLevel())
				.build());
	}
	
	public String generateRefreshToken(ClaimVO claimVO) {
		return generateRefreshToken(AccountDto.builder()
					.accountId(claimVO.getUserId())
					.accountLevel(claimVO.getUserLevel())
				.build());
	}
	
	public long getRemainTime(String bearerToken) {
		//Bearer 접두사 제거
		String token = bearerToken.substring(7);
		
		//토큰 해석
		Claims claims = (Claims) Jwts.parser()
				.verifyWith(tokenProperties.getKey())
				.requireIssuer(tokenProperties.getIssuer())
			.build()
				.parse(token)
				.getPayload();
		
		//남은 시간 구하기
		Date expire = claims.getExpiration(); //만료시간
		Date now = new Date(); //현재시각
		
		return expire.getTime() - now.getTime(); //만료시간 - 현재시각
	}
	
}
