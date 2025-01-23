package com.kh.spring09.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.kh.spring09.dto.GiftcardDto;

public class GiftcardMapper implements RowMapper<GiftcardDto> {

	@Override
	public GiftcardDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		GiftcardDto giftcardDto = new GiftcardDto();
		giftcardDto.setGiftcardNo(rs.getInt("giftcard_no"));
		giftcardDto.setGiftcardName(rs.getString("giftcard_name"));
		giftcardDto.setGiftcardContent(rs.getString("giftcard_content"));
		giftcardDto.setGiftcardCharge(rs.getInt("giftcard_charge"));
		giftcardDto.setGiftcardPrice(rs.getInt("giftcard_price"));
		
		return giftcardDto;
	}

}
