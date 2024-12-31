package jdbc.insert2;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.util.JdbcFactory;

public class ItemDao {
	
	public void insert(ItemDto itemDto) {
		
		JdbcTemplate jdbcTemplate = JdbcFactory.createTemplate();
		String sql = "insert into item(item_no, item_name, item_type, item_price, item_discount_rate, item_qty, item_early) "
				+ "values(item_seq.nextval, ?, ?, ?, ?, ?, ?)";
		Object[] data = {
				itemDto.getItemName(), itemDto.getItemType(), itemDto.getItemPrice(), itemDto.getItemDiscountRate(), itemDto.getItmQty(), itemDto.getItemEarly()
		};
		jdbcTemplate.update(sql, data);
		
	}

}
