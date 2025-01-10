package com.kh.spring09.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring09.dto.MemberDto;
import com.kh.spring09.mapper.MemberMapper;

@Repository
public class MemberDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

//	@Autowired
//	private MemberMapper memberMapper;

	// 객체지향스러운 등록 메소드(추천)
	public void insert(MemberDto memberDto) {
		String sql = "insert into member(" + "member_id, member_pw, member_nickname, member_email" + ") "
				+ "values(?, ?, ?, ?)";
		Object[] data = { memberDto.getMemberId(), memberDto.getMemberPw(), memberDto.getMemberNickname(), memberDto.getMemberEmail() };
		jdbcTemplate.update(sql, data);
	}


}
