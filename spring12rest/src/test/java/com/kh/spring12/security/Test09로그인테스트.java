package com.kh.spring12.security;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.kh.spring12.dao.AccountDao;
import com.kh.spring12.dto.AccountDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class Test09로그인테스트 {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Test
	public void test() {
		AccountDto accountDto = AccountDto.builder()
				.accountId("testuser1")
				.accountPw("Testuser1!")
			.build();
		
		//AccountDto findDto = sqlSession.selectOne("account.find", accountDto.getAccountId());
		AccountDto findDto = sqlSession.selectOne("account.find", accountDto);
		if(findDto == null) {
			//System.err.println("아이디 없음");
			log.error("아이디 없음");
			return;
		}
		
		//비밀번호는 equals가 아니라 encoder를 이용해서 비교
		boolean isValid = encoder.matches(accountDto.getAccountPw(), findDto.getAccountPw());
		
		if(isValid) {
			log.debug("로그인 성공");
		}
		else {
			log.debug("로그인 실패"); 
		}
	}
}
