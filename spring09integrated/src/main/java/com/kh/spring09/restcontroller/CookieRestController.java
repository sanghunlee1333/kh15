package com.kh.spring09.restcontroller;

import java.time.Duration;
import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

//@CrossOrigin
@RestController
@RequestMapping("/rest/cookie")
public class CookieRestController {

	@GetMapping("/ad")
	public void ad(HttpServletResponse response) {
		//오늘 자정까지 남은시간을 초로 구해서 adblock이라는 이름의 쿠키 생성
		LocalDateTime current = LocalDateTime.now();
		LocalDateTime limit = current.plusDays(1L).withHour(0).withMinute(0).withSecond(0); //자정(다음날 0시 0분 0초)
		Duration duration = Duration.between(current, limit); //차이 계산
		int seconds = (int)duration.toSeconds();
		
		//쿠키는 발급한 곳에서만 사용이 가능하다
		//- 현재 위치가 /rest/cookie/ad 인데, 전체에서 사용 가능한 쿠키를 발행해야 함
		Cookie cookie = new Cookie("adblock", "OK");
		cookie.setMaxAge(seconds); //자정까지 남은 시간 설정
		cookie.setPath("/"); //사용 가능한 주소 설정
		response.addCookie(cookie);
	}
	
}
