package com.kh.spring12.security;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class Test06SHA암호화 {

	//Spring Security에서 SHA(Secure Hash Algorithm) 관련 라이브러리가 사라짐
	//학습을 위해 Apache commons codec이라는 라이브러리로 테스트 (의존성 추가 필요)
	
	@Test
	public void test() {
		//암호화 도구 생성
		//DigestUtils codec = new DigestUtils("SHA-256"); //SHA-2(256)
		//DigestUtils codec = new DigestUtils("SHA3-256"); //SHA-3(256)
		DigestUtils codec = new DigestUtils("SHA3-512"); //SHA-3(512)
		
		String origin = "hello";
		String convert = codec.digestAsHex(origin);
		log.debug("convert = {}", convert);
		log.debug("글자수 = {}", convert.length());
		
	}
}
