package com.kh.spring09.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.kh.spring09.dto.MenuDto;

@Component
public class MenuMapper implements RowMapper<MenuDto>{

	@Override
	public MenuDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		MenuDto menuDto = new MenuDto();
		menuDto.setMenuNo(rs.getInt("menu_no"));
		menuDto.setMenuName(rs.getString("menu_name"));
		menuDto.setMenuEvent(rs.getString("menu_event"));
		menuDto.setMenuPrice(rs.getInt("menu_price"));
		menuDto.setMenuType(rs.getString("menu_type"));
		
		return menuDto;
	}

}
