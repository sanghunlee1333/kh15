package com.kh.spring11;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@SpringBootTest
public class Test03마임메세지3 {

	@Autowired
	private JavaMailSender sender;
	
	@Test
	public void test() throws MessagingException, IOException {
		//sender에게 기본 마임메세지 인스턴스를 생성하도록 지시
		MimeMessage message = sender.createMimeMessage();
		
		//복잡한 설정과정을 도와주는 도우미를 생성
		MimeMessageHelper helper = new MimeMessageHelper(message, false, "UTF-8");
		
		//도우미를 통해서 메세지에 정보를 설정
		helper.setTo("sanghunlee1333@gmail.com"); //1개
		//helper.setTo(new String[] {"sanghunlee1333@gmail.com"}); //여러 개
		helper.setSubject("외부템플릿 테스트");
		
		//외부에 존재하는 템플릿 HTML을 불러와서 전송
		//- classpath - src 내부에 존재하는 위치
		//- filepath - 프로젝트 상의 위치
		ClassPathResource resource = new ClassPathResource("templates/welcome.html");
		File target = resource.getFile(); // 파일추출
		Scanner sc = new Scanner(target); //입력도구
		StringBuffer buffer = new StringBuffer(); //저장도구생성
		while(sc.hasNextLine()) { //남아있는 줄이 있다면 
			buffer.append(sc.nextLine()); //읽어서 버퍼에 추가
		}
		sc.close(); //도구 정리
		
		helper.setText(buffer.toString(), true); //HTML 사용
	
		//전송
		sender.send(message);
	}
	
	
}
