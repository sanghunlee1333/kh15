package com.kh.spring12.service;

import java.time.Duration;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.kh.spring12.dao.CertDao;
import com.kh.spring12.dto.CertDto;
import com.kh.spring12.util.RandomGenerator;

@Service
public class CertService {
	
	@Autowired
	private CertDao certDao;
	
	@Autowired
	private JavaMailSender sender;
	
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

	public boolean checkCert(CertDto certDto) {
		CertDto findDto = certDao.selectOne(certDto);
		if(findDto == null) return false; //인증발송 내역 없음
		
		//boolean c1 = //DB인증번호와 제출한 번호가 같을 것
		//boolean c2 = //제한시간을 넘기지 않을 것
		boolean c1 = findDto.getCertNumber().equals(certDto.getCertNumber());
		LocalDateTime t1 = findDto.getCertTime().toLocalDateTime(); //발송시각
		LocalDateTime t2 = LocalDateTime.now(); //현재시각
		Duration duration = Duration.between(t1,  t2); //차이 계산
		boolean c2 = duration.toMinutes() < 10; //10분 미만
		boolean isValid = c1 && c2; //최종결과
		
		if(isValid) {
			//certDao.delete(certDto.getCertEmail()); //삭제
			certDao.confirm(certDto.getCertEmail()); //인증시간 기록
			return true; //인증 성공
		}
		
		return false; //인증 실패
	}
}
