package com.kh.spring12.security;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.encrypt.AesBytesEncryptor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class Test04AES암호화 {

	//암호키 = 암호화 or 복호화에 사용하는 들키면 안되는 열쇠 역할의 값
	//솔트 = 암호화할 문자열에 합성할 추가 양념 역할의 값
	AesBytesEncryptor encryptor = new AesBytesEncryptor("khacademy", "123456");
	
	@Test
	public void test() {
		
		String origin = "hello";
		byte[] encBytes = encryptor.encrypt(origin.getBytes());
		String convert = new String(encBytes); //암호화
		
		byte[] decBytes = encryptor.decrypt(encBytes); //복호화
		String recover = new String(decBytes);
		
		log.debug("origin = {}", origin);
		log.debug("convert = {}", convert);
		log.debug("recover = {}", recover);
	}
	
}
