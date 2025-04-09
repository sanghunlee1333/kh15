package com.kh.spring12.complex;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring12.dto.AccountDto;
import com.kh.spring12.vo.AccountSearchVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class Test02VO활용 {

	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void test() {
		AccountSearchVO vo = AccountSearchVO.builder()
//				.accountId("testuser1")
//				.accountNickname("테스트유저1")
//				.accountContact("010")
//				.minAccountPoint(1000)
//				.maxAccountPoint(2000)
//				.beginAccountJoin("2025-01-01")
//				.endAccountJoin("2025-05-01")
//				.accountLevels(List.of("일반회원", "관리자"))
//				.accountAddress("서울시")
				.beginRow(1)
				.endRow(3)
			.build();
		
		List<AccountDto> list = sqlSession.selectList("account.complexSearch", vo);
		for(AccountDto accountDto : list) {
			log.debug("accountDto = {}", accountDto);
		}
	}
}
