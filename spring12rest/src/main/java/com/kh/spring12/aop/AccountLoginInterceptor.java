package com.kh.spring12.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import com.kh.spring12.service.TokenService;
import com.kh.spring12.vo.ClaimVO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

//로그인 여부를 판정하여 통과시키는 인터셉터 구현
@Slf4j
@Service
public class AccountLoginInterceptor implements HandlerInterceptor {

	@Autowired
	private TokenService tokenService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		//이 인터셉터는 기존처럼 HttpSession을 조회하지 않는다
		//대신, HttpHeader에서 Authorization 항목을 조회한다
		
		//[1] OPTIONS 요청은 통과시킨다
		//- OPTIONS 요청은 통신이 가능한지 확인하기 위한 선발대 형식의 요청
		//- CORS 상황이거나, 일반적인 요청(GET/HEAD/POST)이 아니면 발생
		if(request.getMethod().equalsIgnoreCase("options")) {
			return true;
		}
		
		//[2] Authorization 헤더 검사
		//- 이 항목이 반드시 존재해야 하며 시작 글자는 Bearer 여야 함
		//- Bearer 뒤에 있는 값만 필요
		try {//Plan A : 로그인 상태라고 가정
			String authorization = request.getHeader("Authorization");
			if(authorization == null) throw new Exception("헤더 없음");
			if(authorization.startsWith("Bearer") == false) throw new Exception("Bearer 토큰이 아님");
			
			String token = authorization.substring("Bearer ".length()); 
			//String token = authorization.substring(7); //위와 동일
			ClaimVO claimVO = tokenService.parse(token);
			log.debug("로그인 상태 = {}", claimVO);
			return true; //통과
		}
		catch (Exception e) {//Plan B : 로그인 상태가 아님
			log.debug("로그인 상태가 아닙니다");
			response.sendError(401); //미인증 //403은 로그인했는데 못들어가는 것
			return false; //차단
		}
	}
	
}
