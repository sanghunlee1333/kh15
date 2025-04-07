package com.kh.spring12.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import com.kh.spring12.configuration.TokenProperties;
import com.kh.spring12.service.TokenService;
import com.kh.spring12.vo.ClaimVO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

//access-token의 유효 시간을 검사하여 소멸이 임박한 경우 연장해주는 역할
//- access-token은 변조가 불가능
//- 신규발급을 해야함
//- 어느 페이지로 요청을 보내는지 알 수 없으므로 헤더를 이용
//- FE에서 갱신할 수 있도록 추가 코드 작성이 필요
@Slf4j
@Service
public class TokenRenewalInterceptor implements HandlerInterceptor {
	
	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private TokenProperties tokenProperties;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		try {
			//[1] OPTIONS 요청은 통과시킨다
			if(request.getMethod().equalsIgnoreCase("options")) {
				return true;
			}
	
			//[2] AccessToken이 없으면 통과 (Authorization 헤더 조회)
			String accessToken = request.getHeader("Authorization");
			if(accessToken == null) return true; //없으면 통과
			
			//[3] 토큰 해석 (남은 시간 구하기)
			long ms = tokenService.getRemainTime(accessToken);
			if(ms >= tokenProperties.getRenewalLimit() * 60L * 1000L) return true;
			
			//[4] 재발행 후 응답정보에 추가
			ClaimVO claimVO = tokenService.parseBearerToken(accessToken);
			
			//헤더에 이름을 추가하는 규칙은 없지만 Authorization 등은 사용 금지
			//과거에는 x- 접두사를 붙여서 dataset처럼 표현했었음
			//의미가 명확하면 된다!
			//커스텀 헤더는 보안 정책에 의해서 차단되므로 반드시 노출 설정이 필요
			response.setHeader("Access-Control-Expose-Headers", "Access-Token");
			response.setHeader("Access-Token", tokenService.generateAccessToken(claimVO)); //"이름", "값"
			
			return true; //무조건 통과
		}
		catch(Exception e) {
			return true;
		}
	}

}
