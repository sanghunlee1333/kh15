package com.kh.spring12.dao.websocket;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring12.dto.websocket.RoomDto;
import com.kh.spring12.vo.websocket.UserVO;

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
	public void enterRoom(long roomNo, String accountId) {
		Map<String, Object> params = new HashMap<>();
		params.put("roomNo", roomNo);
		params.put("accountId", accountId);
		sqlSession.insert("room.enter", params);
	}
	public boolean checkRoom(long roomNo, String accountId) {
		Map<String, Object> params = new HashMap<>();
		params.put("roomNo", roomNo);
		params.put("accountId", accountId);
		int count = sqlSession.selectOne("room.check", params); 
		return count > 0;
		//select count(*) from room_user where room_user_no = ? and account_id = ?
	}
	public List<UserVO> getUsers(long roomNo){
		//return sqlSession.selectList("room.getUsers", roomNo); //모호한 표현
		Map<String, Long> params = Map.of("roomNo", roomNo);
		return sqlSession.selectList("room.getUsers", params); //정확한 표현
	}
	public boolean leaveRoom(long roomNo, String accountId) {
		Map<String, Object> params = new HashMap<>();
		params.put("roomNo", roomNo);
		params.put("accountId", accountId);
		return sqlSession.delete("room.leave", params) > 0; 
	}
}
