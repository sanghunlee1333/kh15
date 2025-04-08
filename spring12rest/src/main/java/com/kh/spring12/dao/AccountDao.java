package com.kh.spring12.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.kh.spring12.dto.AccountDto;

@Repository
public class AccountDao {
	@Autowired
	private SqlSession sqlSession;
	@Autowired
	private PasswordEncoder encoder;
	
	public void insert(AccountDto accountDto) {
		//암호화 코드
		String encrypt = encoder.encode(accountDto.getAccountPw());
		accountDto.setAccountPw(encrypt);
		sqlSession.insert("account.join", accountDto);
	}
	
	public AccountDto selectOne(String accountId) {
		return sqlSession.selectOne("account.find", accountId);
	}
	public AccountDto selectOne(AccountDto accountDto) {
		return sqlSession.selectOne("account.find", accountDto);
	}
	public AccountDto selectOneByAccountNickname(String accountNickname) {
		return sqlSession.selectOne("account.findNickname", accountNickname);
	}
	public AccountDto login(AccountDto accountDto) {
//		AccountDto findDto = sqlSession.selectOne("account.find", accountDto);
		AccountDto findDto = selectOne(accountDto);
		if(findDto == null) return null;//false 대신
		boolean isValid = encoder.matches(accountDto.getAccountPw(), findDto.getAccountPw());
		return isValid ? findDto : null;
	}
	public boolean update(AccountDto accountDto) {
		return sqlSession.update("account.editUnit", accountDto) > 0;
	}
}