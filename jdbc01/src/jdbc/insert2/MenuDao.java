package jdbc.insert2;

import org.springframework.jdbc.core.JdbcTemplate;

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
	
}
