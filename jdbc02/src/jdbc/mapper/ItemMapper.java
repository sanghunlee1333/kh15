package jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import jdbc.dto.ItemDto;

public class ItemMapper implements RowMapper<ItemDto>{

	@Override
	public ItemDto mapRow(ResultSet rs, int arg1) throws SQLException {
		
		ItemDto itemDto = new ItemDto();
		itemDto.setItemNo(rs.getInt("Item_no"));
		itemDto.setItemName(rs.getString("Item_name"));
		itemDto.setItemPrice(rs.getInt("Item_price"));
		itemDto.setItemType(rs.getString("Item_type"));
		//itemDto.setItemDiscountRate(rs.getFloat("item_discount_rate")); //비추천
		//itemDto.setItemDiscountRate((Float)rs.getObject("item_discount_rate")); //다운캐스팅 해서 null이 안 나오게끔 변경 //추천
		itemDto.setItemDiscountRate(rs.getObject("item_discount_rate", Float.class)); // Float클래스를 알려줄테니 다운 캐스팅 해줘 //추천
		itemDto.setItmQty(rs.getInt("item_qty"));
		itemDto.setItemEarly(rs.getString("item_early"));
		
		return itemDto;
	}
	

}
