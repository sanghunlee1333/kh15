package com.kh.spring12.security;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class Test03패딩암호화 {

	@Test
	public void test() {
		String origin = "hello";
		String convert = encrypt(origin);
		String recover = decrypt(convert);
		log.debug("origin = {}", origin);
		log.debug("convert = {}", convert);
		log.debug("recover = {}", recover);
	}
	
	private char padding = 'a';
	public String encrypt(String origin) {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < origin.length(); i++) {
			char ch = origin.charAt(i);
			buffer.append(ch); //글자 추가 후
			buffer.append(padding); //패딩 추가 후
		}
		return buffer.toString();
	}
	public String decrypt(String convert) {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < convert.length(); i += 2) { //홀수 자리만 반복
			char ch = convert.charAt(i);
			buffer.append(ch); //글자 추가 후
		}
		return buffer.toString();
	}
	
}
