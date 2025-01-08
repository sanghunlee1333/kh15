package com.kh.spring09.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.kh.spring09.dto.ItemDto;

@Component
public class ItemMapper implements RowMapper<ItemDto>{

	@Override
	public ItemDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		ItemDto itemDto = new ItemDto();
		itemDto.setItemNo(rs.getInt("Item_no"));
		itemDto.setItemName(rs.getString("Item_name"));
		itemDto.setItemPrice(rs.getInt("Item_price"));
		itemDto.setItemType(rs.getString("Item_type"));
		itemDto.setItemDiscountRate(rs.getObject("item_discount_rate", Float.class)); // Float클래스를 알려줄테니 다운 캐스팅 해줘 //추천 (형태를 지정해서 추출)
		itemDto.setItmQty(rs.getInt("item_qty"));
		itemDto.setItemEarly(rs.getString("item_early"));
		
		return itemDto;
	}
	
	

}
