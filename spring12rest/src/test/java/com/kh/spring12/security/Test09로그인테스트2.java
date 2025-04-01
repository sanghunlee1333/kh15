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
public class Test09로그인테스트2 {

	@Autowired
	private AccountDao accountDao;
	
	@Test
	public void test() {
		AccountDto accountDto = AccountDto.builder()
					.accountId("testuser1")
					.accountPw("Testuser1!")
				.build();
		
		AccountDto findDto = accountDao.login(accountDto);
		if(findDto == null) {
			log.error("로그인 실패");
		}
		else {
			log.debug("로그인 성공");
		}
		
	}
}
