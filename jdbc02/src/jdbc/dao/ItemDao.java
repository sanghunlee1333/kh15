package jdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.ItemDto;
import jdbc.util.JdbcFactory;

public class ItemDao {
	
	public void insert(ItemDto itemDto) {
			
	}
	
	public boolean update(ItemDto itemDto) {
		
		JdbcTemplate jdbcTemplate = JdbcFactory.createTemplate();
		String sql = "update item set item_name = ?, item_type = ?, item_price = ?, item_discount_rate = ?, item_qty = ?, item_early = ? where item_no = ?";
		Object[] data = {
				itemDto.getItemName(), itemDto.getItemType(), itemDto.getItemPrice(), itemDto.getItemDiscountRate(), 
				itemDto.getItmQty(), itemDto.getItemEarly(), itemDto.getItemNo()
		};
		int rows = jdbcTemplate.update(sql, data);
		
		return rows > 0;
		
	}

}
