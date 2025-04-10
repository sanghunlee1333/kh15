package com.kh.spring12.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring12.dto.ItemDto;

@Repository
public class ItemDao {
	@Autowired
	private SqlSession sqlSession;
	
	public List<ItemDto> selectList() {
		return sqlSession.selectList("item.list");
	}
	public ItemDto selectOne(long itemNo) {
		return sqlSession.selectOne("item.find", itemNo);
	}
	public ItemDto selectOne(ItemDto itemDto) {
		return sqlSession.selectOne("item.find", itemDto);
	}
}
