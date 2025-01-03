package jdbc.select3;

import jdbc.dao.ItemDao;
import jdbc.dto.ItemDto;

public class Test05아이템상세 {

	public static void main(String[] args) {
		
		int itemNo = 25;
		
		ItemDao itemDao = new ItemDao();
		ItemDto itemDto = itemDao.selectOne(itemNo);
		
		if(itemDto == null) {
			System.out.println("존재하지 않은 아이템 번호");
		}
		else {
			System.out.println(itemDto);
		}
		
	}

}
