package jdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.MenuDto;
import jdbc.util.JdbcFactory;

public class MenuDao {
	
	public void insert(MenuDto menuDto) {
		
		JdbcTemplate jdbcTemplate = JdbcFactory.createTemplate();
		String sql = "insert into menu(menu_no, menu_name, menu_type, menu_price, menu_event) "
				+ "values(menu_seq.nextval, ?, ?, ?, ?)";
		Object[] data = {
			menuDto.getMenuName(), menuDto.getMenuType(), menuDto.getMenuPrice(), menuDto.getMenuEvent()
		};
		jdbcTemplate.update(sql, data);
		
	}
	
	public boolean update(MenuDto menuDto) {
		JdbcTemplate jdbcTemplate = JdbcFactory.createTemplate();
		String sql = "update menu set menu_name = ?, menu_type = ?, menu_price = ?, menu_event = ? where menu_no = ?";
		Object[] data = {
				menuDto.getMenuName(), menuDto.getMenuType(), menuDto.getMenuPrice(), menuDto.getMenuEvent(), menuDto.getMenuNo()
		};
		int rows = jdbcTemplate.update(sql, data);
		
		return rows > 0;
	}
	
}
