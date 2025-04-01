package com.kh.spring12.security;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class Test01암호화 {

	@Test
	public void test() {
		//암호화(Encryption)란?
		//- 내가 원하는 대상만 정보를 알아들을 수 있도록 변조하는 행위
		//- 일관된 규칙에 의해서 만들어져야 한다
		//- 반대되는 개념은 복호화(Decryption)이며 가능할 수도 불가능할 수도 있다
		//- 복호화가 가능한 암호화 방식을 양방향 암호화라고 한다
		//- 복호화가 불가능한 암호화 방식을 단방향 암호화라고 한다
		//- 여러 라이브러리들이 있지만 spring-security 프레임워크의 기술을 사용
		
		//가장 간단한 양방향 암호화 (시저 암호화)
		//- 원문에 일정 수치만큼을 더하거나 빼서 새로운 값을 만들어내는 방식
		
		String origin = "hello";
		int offset = 3; //더할 수치
		
		//암호화
		StringBuffer buffer = new StringBuffer();
		for(int i = 0; i < origin.length(); i++) {
			char ch = origin.charAt(i); //글자 추출
			ch += offset;
			buffer.append(ch);
			//log.debug("ch = {}", ch);
		}
		
		String encrypt = buffer.toString(); //암호화된 결과
		log.debug("origin = {}", origin);
		log.debug("encrypt = {}", encrypt);
		
		//복호화
		buffer = new StringBuffer();
		for(int i = 0; i < encrypt.length(); i++) {
			char ch = encrypt.charAt(i);
			ch -= offset;
			buffer.append(ch);
		}
		String decrypt = buffer.toString(); //복호화된 결과
		log.debug("decrypt = {}", decrypt);
	}
	
}
