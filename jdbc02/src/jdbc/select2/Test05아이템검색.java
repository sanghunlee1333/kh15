package jdbc.select2;

import java.util.List;

import jdbc.dao.ItemDao;
import jdbc.dto.ItemDto;

public class Test05아이템검색 {

	public static void main(String[] args) {
		
//		String column = "아이템명";
//		String keyword = "돼지바";
		String column = "아이템종류";
		String keyword = "식품";
				
		ItemDao itemDao = new ItemDao();
		List<ItemDto> list = itemDao.selectList(column, keyword);
		
		for(ItemDto itemDto : list) {
			System.out.println(itemDto);
		}
		
	}

}
