package jdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.MenuDto;
import jdbc.mapper.MenuMapper;
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
	
	public boolean delete(int menuNo) {
		
		JdbcTemplate jdbcTemplate = JdbcFactory.createTemplate();
		String sql = "delete menu where menu_no = ?";
		Object[] data = {menuNo};
		return jdbcTemplate.update(sql, data) > 0;
	
	}
	
	private MenuMapper menuMapper = new MenuMapper();
	
	public List<MenuDto> selectList(){
		
		JdbcTemplate jdbcTemplate = JdbcFactory.createTemplate();
		String sql = "select * from menu";
		return jdbcTemplate.query(sql, menuMapper);
		
	}
	
}
