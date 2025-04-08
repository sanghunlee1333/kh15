package com.kh.spring12.complex;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring12.dto.AccountDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class Test01복합검색 {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void test() {
		Map<String, Object> params = new HashMap<>();
//		params.put("accountId", "testuser1"); //아이디가 정확하게 testuser1인 경우
//		params.put("accountNickname", "테스트유저12"); //닉네임 일치
//		params.put("accountContact", "010"); //시작검사
//		params.put("accountPoint", 13000); //의미없음
//		params.put("minAccountPoint", 1000); //포인트 최소값
//		params.put("maxAccountPoint", 10000); //포인트 최대값
//		params.put("beginAccountJoin", "2025-01-01"); //가입일 시작값
//		params.put("endAccountJoin", "2025-05-01"); //가입일 종료값
//		params.put("accountLevels", List.of()); 
//		params.put("accountLevels", List.of("일반회원"));
//		params.put("accountLevels", List.of("일반회원", "우수회원")); 
//		params.put("accountLevels", List.of("일반회원", "우수회원", "관리자")); 
//		params.put("accountLevels", new String[]{"일반회원", "우수회원", "관리자"});
		params.put("accountAddress", "서울");
		
		List<AccountDto> list = sqlSession.selectList("account.complexSearch", params);
		log.debug("검색 결과 : {}개", list.size());
		for(AccountDto accountDto : list) {
			log.debug("dto = {}", accountDto);
		}
	}

}
