package com.kh.spring12.dao.websocket;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring12.dto.websocket.MemberMessageDto;

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
	
}
