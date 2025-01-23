package com.kh.spring09.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring09.dto.MemberDto;
import com.kh.spring09.error.NoPermissionException;
import com.kh.spring09.mapper.MemberMapper;
import com.kh.spring09.vo.PageVO;

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

	// 최종 로그인 시각 갱신 메소드
	public boolean updateMemberLogin(String memberId) {
		String sql = "update member set member_login = systimestamp where member_id = ?";
		Object[] data = { memberId };
		return jdbcTemplate.update(sql, data) > 0;
	}

	// 비밀번호 변경 시 최종 비밀번호 변경일도 같이 변경되게 구현
	public boolean updateMemberPassword(MemberDto memberDto) {
		String sql = "update member set member_pw = ?, member_change = systimestamp where member_id = ?";
		Object[] data = { memberDto.getMemberPw(), memberDto.getMemberId() };
		return jdbcTemplate.update(sql, data) > 0;
	}

	public boolean update(MemberDto memberDto) {
		String sql = "update member set " + "member_pw = ?, member_nickname = ?, "
				+ "member_birth = ?, member_contact = ?, " + "member_email = ?, member_post = ?, "
				+ "member_address1 = ?, member_address2 = ?, " + "member_level = ?, member_point = ? "
				+ "where member_id = ?";
		Object[] data = { memberDto.getMemberPw(), memberDto.getMemberNickname(), memberDto.getMemberBirth(),
				memberDto.getMemberContact(), memberDto.getMemberEmail(), memberDto.getMemberPost(),
				memberDto.getMemberAddress1(), memberDto.getMemberAddress2(), memberDto.getMemberLevel(),
				memberDto.getMemberPoint(), memberDto.getMemberId() };
		return jdbcTemplate.update(sql, data) > 0;
	}

	public boolean delete(String memberId) {
		String sql = "delete member where member_id = ?";
		Object[] data = { memberId };
		return jdbcTemplate.update(sql, data) > 0;
	}

	
	public List<MemberDto> selectList(PageVO pageVO) {
		if(pageVO.isList()) {
			String sql = "select * from ("
							+ "select rownum rn, TMP.* from ("
								+ "select * from member order by member_id asc"
							+ ")TMP"
						+ ") "
						+ "where rn between ? and ?";
			Object[] data = {pageVO.getStartRownum(), pageVO.getFinishRownum()};
			return jdbcTemplate.query(sql, memberMapper, data);
		}
		else {
			String sql = "select * from ("
							+ "select rownum rn, TMP.* from ("
								+ "select * from member "
								+ "where instr(#1, ?) > 0 "
								+ "order by #1 asc, member_id asc"
							+ ")TMP"
						+ ") "
						+ "where rn between ? and ?";
			sql = sql.replace("#1", pageVO.getColumn());
			Object[] data = {
					pageVO.getKeyword(),
					pageVO.getStartRownum(),
					pageVO.getFinishRownum()
			};
			return jdbcTemplate.query(sql,  memberMapper, data);
		}
	}
	
	public int count(PageVO pageVO) {
		if(pageVO.isList()) {
			String sql = "select count(*) from member";
			return jdbcTemplate.queryForObject(sql, int.class);
		}
		else {
			String sql = "select count(*) from member "
					+ "where instr(#1, ?) > 0";
			sql = sql.replace("#1", pageVO.getColumn());
			Object[] data = {pageVO.getKeyword()};
			return jdbcTemplate.queryForObject(sql, int.class, data);
		}
	}

	// 검색 목록 조회
	public List<MemberDto> selectList(String column, String keyword) {
		// 검색 항목 검사
		switch (column) {
		case "member_id":
		case "member_nickname":
			break;
		default:
			throw new NoPermissionException("검색할 수 없는 항목");
		}

		String sql = "select * from member "
				+ "where instr(#1, ?) > 0 ";
		sql = sql.replace("#1", column);
		Object[] data = { keyword };
		return jdbcTemplate.query(sql, memberMapper, data);

	}

}
