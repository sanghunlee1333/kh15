package jdbc.select;

import java.util.List;

import jdbc.dao.ItemDao;
import jdbc.dto.ItemDto;

public class Test05아이템조회 {

	public static void main(String[] args) {
		
		ItemDao itemDao = new ItemDao();
		List<ItemDto> list = itemDao.selectList();
		
		for(ItemDto itemDto : list) {
			System.out.println(itemDto);
		}
		
		
	}

}
