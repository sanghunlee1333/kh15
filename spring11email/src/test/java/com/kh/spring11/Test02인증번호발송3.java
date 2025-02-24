package com.kh.spring11;

import java.text.DecimalFormat;
import java.text.Format;
import java.util.Random;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@SpringBootTest
public class Test02인증번호발송3 {
	
	//이메일(E-mail)이 무엇인가?
	//- SMTP(Simple Mail Transfer Protocol)에서 주고받는 메세지
	//- 문자(SMS)와 비슷한 통신방식을 가진다
	//- SMTP 서버끼리 메세지를 주고받아야 하기 때문에 SMTP 서버 구축이 필요
	//- 직접 서버를 구축하지 않고 Gmail의 이메일 서비스를 이용(2단계 인증 및 앱 비밀번호 생성이 필요)
	
	//구현 순서
	//[1] 이메일 전송 도구 생성(활 준비)
	//[2] 이용할 서비스(Gmail) 정보 입력
	//[3] 메세지 생성
	//[4] 메세지 전송(화살 발사)
	
	@Autowired
	//private JavaMailSenderImpl sender; //[1], [2]을 대체
	private JavaMailSender sender; //[1], [2]을 대체(업캐스팅)
	
	@Test
	public void test() {
		System.out.println("단문 메세지 발송 테스트 시작");
		
		//[3]
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo("sanghunlee1333@gmail.com", "dltkdgns9912@naver.com"); //수신인(여러 개 가능)
		
		//인증번호 생성
		Random r = new Random();
		int certNumber = r.nextInt(1000000); //6자리
		Format f = new DecimalFormat("000000");
		
		message.setSubject("[KH정보교육원] 인증번호 안내"); //제목
		message.setText("인증번호는 [" +f.format(certNumber) + "]입니다."); //내용
		
		//[4]
		sender.send(message);
		
		System.out.println("단문 메세지 발송 테스트 종료");
	}
}
