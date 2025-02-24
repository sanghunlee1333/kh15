package com.kh.spring11;

import java.util.Properties;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@SpringBootTest
public class Test01단문메세지발송 {
	
	//이메일(E-mail)이 무엇인가?
	//- SMTP(Simple Mail Transfer Protocol)에서 주고받는 메세지
	//- 문자(SMS)와 비슷한 통신방식을 가진다
	//- SMTP 서버끼리 메세지를 주고받아야 하기 때문에 SMTP 서버 구축이 필요
	//- 직접 서버를 구축하지 않고 Gmail의 이메일 서비스를 이용(2단계 인증 및 앱 비밀번호 생성이 필요)
	
	//구현 순서
	//[1] 이메일 전송 도구 생성(활 준비)
	//[2] 이용할 서비스(Gmail) 정보 입력(맞출 과녁 조준)
	//[3] 메세지 생성(화살 생성)
	//[4] 메세지 전송(화살 발사)
	
	@Test
	public void test() {
		System.out.println("단문 메세지 발송 테스트 시작");
		
		//[1]
		JavaMailSenderImpl sender = new JavaMailSenderImpl();
		
		//[2]
		sender.setHost("smtp.gmail.com"); //Host는 이용할 업체의 별칭 또는 IP
		sender.setPort(587); //이용할 업체의 서비스 실행번호
		sender.setUsername("sanghuntest15"); //이용할 업체의 사용자 계정이름
		sender.setPassword("towcsejsjensfbgd"); //이용할 업체의 사용자 계정 비밀번호(구글은 앱 비밀번호)
		
		Properties props = new Properties(); //추가 정보 저장소 생성
		props.setProperty("mail.smtp.auth", "true"); //인증 후 이용 설정
		props.setProperty("mail.smtp.debug", "true"); //디버깅 허용 설정
		props.setProperty("mail.smtp.starttls.enable", "true"); //TLS 사용 설정
		props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2"); //TLS 버전 설정
		props.setProperty("mail.smtp.ssl.trust", "smtp.gmail.com"); //신뢰할 수 있는 주소로 등록
		sender.setJavaMailProperties(props); //추가 정보 설정
		
		//[3]
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo("sanghunlee1333@gmail.com"); //수신인(여러 개 가능)
		//message.setCc(null); //참조인(여러 개 가능)
		//message.setBcc(null); //숨은 참조(여러 개 가능)
		message.setSubject("테스트 이메일"); //제목
		message.setText("Hello!"); //내용
		
		//[4]
		sender.send(message);
		
		System.out.println("단문 메세지 발송 테스트 종료");
	}
}
