package com.kh.spring12.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring12.dto.AccountTokenDto;

@Repository
public class AccountTokenDao {

	@Autowired
	private SqlSession sqlSession;
	
//	public long sequence() {
//		return sqlSession.selectOne("accountToken.sequence");
//	}
//	public void insert(AccountTokenDto accountTokenDto) {
//		sqlSession.insert("accountToken.add", accountTokenDto);
//	}
	public AccountTokenDto insert(AccountTokenDto accountTokenDto) {
		long accountTokenNo = sqlSession.selectOne("accountToken.sequence");
		accountTokenDto.setAccountTokenNo(accountTokenNo);
		sqlSession.insert("accountToken.add", accountTokenDto);
		//return accountTokenDto; //현재 상태는 시간이 포함되지 않음
		return sqlSession.selectOne("accountToken.find", accountTokenDto); //모든 정보 포함
	}
	
	public AccountTokenDto findByTargetAndToken(AccountTokenDto accountTokenDto) {
		return sqlSession.selectOne("accountToken.findByTargetAndToken", accountTokenDto);
	}

	public boolean delete(AccountTokenDto accountTokenDto) {
		return sqlSession.delete("accountToken.delete", accountTokenDto) > 0;
	}
	
	
	
}
