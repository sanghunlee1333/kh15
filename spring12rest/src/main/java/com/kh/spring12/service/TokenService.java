package com.kh.spring12.service;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.spring12.configuration.TokenProperties;
import com.kh.spring12.dto.AccountDto;
import com.kh.spring12.vo.ClaimVO;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TokenService {

	@Autowired
	private TokenProperties tokenProperties;
	
	public String generateAccessToken(AccountDto accountDto) {
		//시간계산
		Calendar c = Calendar.getInstance();
		Date now = c.getTime(); //현재시각
		c.add(Calendar.MINUTE, tokenProperties.getExpireMinutes());
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
}
