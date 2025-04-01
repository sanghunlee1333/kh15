package com.kh.spring12.security;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class Test07BCrypt암호화 {

	@Test
	public void test() {
		//BCrypt는 암호화를 할 때마다 무작위 salt를 생성해서 결과가 달라지도록 
		//암호화 결과는 60bytes
		//- 앞 4byte는 버전
		//- 3byte는 가중치
		//- 22byte는 salt
		//- 나머지(31byte)가 암호화된 결과
		
		//도구 생성
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		//암호화
		String origin = "hello";
		String encrypt = encoder.encode(origin);
		log.debug("origin = {}", origin);
		log.debug("encrypt = {}", encrypt);
		
		//비교 - encoder가 제공하는 명령으로만 비교해야 함
		String input = "hello";
		boolean isValid = encoder.matches(input, encrypt); //좌측이 암호화 안 된 것, 우측이 암호화된 것
		log.debug("isValid = {}", isValid);
		
	}
}
