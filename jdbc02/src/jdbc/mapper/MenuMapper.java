package jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import jdbc.dto.MenuDto;

public class MenuMapper implements RowMapper<MenuDto> {

	@Override
	public MenuDto mapRow(ResultSet rs, int arg1) throws SQLException {
		
		MenuDto menuDto = new MenuDto();
		menuDto.setMenuNo(rs.getInt("menu_no"));
		menuDto.setMenuName(rs.getString("menu_name"));
		menuDto.setMenuEvent(rs.getString("menu_event"));
		menuDto.setMenuPrice(rs.getInt("menu_price"));
		menuDto.setMenuType(rs.getString("menu_type"));
		
		return menuDto;
	}

}
