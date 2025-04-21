package com.kh.spring12.dao.websocket;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring12.dto.websocket.RoomDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class RoomDao {

	@Autowired
	private SqlSession sqlSession;
	
	public RoomDto insert(RoomDto roomDto) {
		long roomNo = sqlSession.selectOne("room.sequence");
		roomDto.setRoomNo(roomNo);
		sqlSession.insert("room.create", roomDto);
		return roomDto;
	}
	public List<RoomDto> selectList() {
		return sqlSession.selectList("room.list");
	}
	public RoomDto selectOne(long roomNo) {
		return sqlSession.selectOne("room.find", roomNo);
	}
	public boolean delete(long roomNo) {
		return sqlSession.delete("room.delete", roomNo) > 0;
	}
	
}
