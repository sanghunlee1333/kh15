package com.kh.spring12.security;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring12.dao.AccountDao;
import com.kh.spring12.dto.AccountDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class Test08회원가입테스트 {

	@Autowired
	private AccountDao accountDao;
	
	@Test
	public void test() {
		accountDao.insert(AccountDto.builder()
				.accountId("testuser1")
				.accountPw("Testuser1!")
				.accountNickname("테스트유저1")
				.accountEmail("testuser1@kh.com")
			.build());
	}
}
