package com.kh.spring12.dao.websocket;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring12.dto.websocket.MemberMessageDto;
import com.kh.spring12.dto.websocket.MemberMessageViewDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class MemberMessageDao {

	@Autowired
	private SqlSession sqlSession;
	
	public MemberMessageDto add(MemberMessageDto memberMessageDto) {
		long memberMessageNo = sqlSession.selectOne("memberMessage.sequence");
		memberMessageDto.setMemberMessageNo(memberMessageNo);
		sqlSession.insert("memberMessage.add", memberMessageDto);
		return memberMessageDto;
	}

	public List<MemberMessageViewDto> selectListForAnonymous() {
		return sqlSession.selectList("memberMessage.listForAnonymous");
	}
	public List<MemberMessageViewDto> selectListForMember(String userId) {
		return sqlSession.selectList("memberMessage.listForMember", userId);
	}
	
	public List<MemberMessageViewDto> selectListForAnonymousByPaging(){
		return sqlSession.selectList("memberMessage.listForAnonymouseByPaging");
	}
	public List<MemberMessageViewDto> selectListForAnonymousByPaging(long memberMessageNo){
		return sqlSession.selectList("memberMessage.listForAnonymouseByPaging", memberMessageNo);
	}
	public List<MemberMessageViewDto> selectListForMemberByPaging(String userId) {
		Map<String, Object> params = new HashMap<>();
		params.put("userId", userId);
		return sqlSession.selectList("memberMessage.listForMemberByPaging", params);
	}
	public List<MemberMessageViewDto> selectListForMemberByPaging(String userId, long memberMessageNo) {
		Map<String, Object> params = new HashMap<>();
		params.put("userId", userId);
		params.put("memberMessageNo", memberMessageNo);
		return sqlSession.selectList("memberMessage.listForMemberByPaging", params);
	}
	public int countForAnonymousByPaging() {
		return sqlSession.selectOne("memberMessage.countForAnonymouseByPaging");
	}
	public int countForAnonymousByPaging(long memberMessageNo) {
		Map<String, Object> params = new HashMap<>();
		params.put("memberMessageNo", memberMessageNo);
		return sqlSession.selectOne("memberMessage.countForAnonymouseByPaging", params);
	}
	public int countForMemberByPaging(String userId) {
		Map<String, Object> params = new HashMap<>();
		params.put("userId", userId);
		return sqlSession.selectOne("memberMessage.countForMemberByPaging", params);
	}
	public int countForMemberByPaging(String userId, long memberMessageNo) {
		Map<String, Object> params = new HashMap<>();
		params.put("userId", userId);
		params.put("memberMessageNo", memberMessageNo);
		return sqlSession.selectOne("memberMessage.countForMemberByPaging", params);
	}
	
}