package com.kh.spring12.complex;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring12.dao.AccountDao;
import com.kh.spring12.dto.AccountDto;

@SpringBootTest
public class Test03더미회원추가 {

	@Autowired
	private AccountDao accountDao;
	
	@Test
	public void test() {
		//일반회원 1000명 가입
//		for(int i = 1; i <= 1000; i++) {
//			accountDao.insert(AccountDto.builder()
//					.accountId("testuser"+i)
//					.accountPw("Testuser" + i + "!")
//					.accountNickname("테스트유저" + i)
//					.accountEmail("testuser" + i + "@kh.com")
//				.build());
//		}
		
		//우수회원 1000명 가입
//		for(int i = 1; i <= 1000; i++) {
//			accountDao.insert(AccountDto.builder()
//					.accountId("vipuser"+i)
//					.accountPw("Vipuser" + i + "!")
//					.accountNickname("우수회원" + i)
//					.accountEmail("vipuser" + i + "@kh.com")
//				.build());
//		}
		
		//관리자 1000명 가입
		for(int i = 1; i <= 1000; i++) {
			accountDao.insert(AccountDto.builder()
					.accountId("adminuser"+i)
					.accountPw("Adminuser" + i + "!")
					.accountNickname("관리자" + i)
					.accountEmail("adminuser" + i + "@kh.com")
				.build());
		}
	}
}
