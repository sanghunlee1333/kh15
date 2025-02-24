package com.kh.spring11;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring11.service.CertService;

@SpringBootTest
public class Test02인증번호발송6 {

	@Autowired
	private CertService certService;
	
	@Test
	public void test() {
		System.out.println("단문 메세지 발송 테스트 시작");
		String email = "sanghunlee1333@gmail.com"; // 수신인
		certService.sendCertEmail(email);
		System.out.println("단문 메세지 발송 테스트 종료");
	}
}
