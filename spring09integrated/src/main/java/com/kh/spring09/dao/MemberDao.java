package com.kh.spring09.dao;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring09.dto.MemberDto;
import com.kh.spring09.mapper.MemberMapper;

import jakarta.servlet.http.HttpSession;

@Repository
public class MemberDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private MemberMapper memberMapper;

	// 가입(등록) 메소드
	// - 사용자 입력항목 : 14개 중에 9개를 입력하며 필수는 4개
	// - 아이디, 비밀번호, 닉네임, 생년월일, 연락처, 이메일
	// - 주소(우편번호, 기본주소, 상세주소)
	public void insert(MemberDto memberDto) {
//		String sql = "insert into member("
//		+ "member_id, member_pw, member_nickname,"
//		+ "member_birth, member_contact, member_email,"
//		+ "member_level, member_point,"
//		+ "member_post, member_address1, member_address2,"
//		+ "member_join, member_login, member_change"
//	+ ") "
//	+ "values(?, ?, ?, ?, ?, ?, '일반회원', 0, ?, ?, ?, systimestamp, null, null)";
		String sql = "insert into member(" + "member_id, member_pw, member_nickname,"
				+ "member_birth, member_contact, member_email," + "member_post, member_address1, member_address2" + ") "
				+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Object[] data = { memberDto.getMemberId(), memberDto.getMemberPw(), memberDto.getMemberNickname(),
				memberDto.getMemberBirth(), memberDto.getMemberContact(), memberDto.getMemberEmail(),
				memberDto.getMemberPost(), memberDto.getMemberAddress1(), memberDto.getMemberAddress2() };
		jdbcTemplate.update(sql, data);
	}

	// 상세조회 기능
	public MemberDto selectOne(String memberId) {
		String sql = "select * from member where member_id=?";
		Object[] data = { memberId };
		List<MemberDto> list = jdbcTemplate.query(sql, memberMapper, data);
		return list.isEmpty() ? null : list.get(0);
	}
	
//	public Timestamp updateMemberlogin(Timestamp timestamp) {
//		String sql = "insert ino member(" 
//	}

	

}
