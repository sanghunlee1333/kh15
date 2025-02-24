package com.kh.spring11.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.kh.spring11.dao.CertDao;
import com.kh.spring11.dto.CertDto;
import com.kh.spring11.util.RandomGenerator;

@Service // Service는 2가지 이상의 Component(작업 1개)를 묶은 것
public class CertService {

	@Autowired
	private JavaMailSender sender;

	@Autowired
	private CertDao certDao;

	@Autowired
	private RandomGenerator randomGenerator;

	public void sendCertEmail(String email) {
		// 인증번호 생성
		String number = randomGenerator.randomNumber(8);

		// 메세지 생성
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(email); // 수신인(여러 개 가능) 설정
		message.setSubject("[KH정보교육원] 인증번호 안내"); // 제목 설정
		message.setText("인증번호는 [" + number + "]입니다."); // 내용 설정
		sender.send(message); //전송

		// (+추가)DB등록
		certDao.insertOrUpdate(CertDto.builder()
				.certEmail(email)
				.certNumber(number)
			.build());

	}
}
