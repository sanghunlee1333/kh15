package jdbc.update;

import jdbc.dao.ItemDao;
import jdbc.dto.ItemDto;

public class Test05아이템정보수정 {

	public static void main(String[] args) {
		
		ItemDto itemDto = new ItemDto();
		itemDto.setItemNo(25);
		itemDto.setItemName("키친타올");
		itemDto.setItemType("생필품");
		itemDto.setItemPrice(15000);
		itemDto.setItemDiscountRate(0.5f);
		itemDto.setItmQty(2);
		itemDto.setItemEarly("Y");
		
		ItemDao itemDao = new ItemDao();
		boolean success = itemDao.update(itemDto);
		if(success) System.out.println("아이템 정보 수정 완료");
		else System.out.println("대상이 아닙니다");
		
	}

}
