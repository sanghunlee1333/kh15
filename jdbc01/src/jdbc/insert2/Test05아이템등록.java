package jdbc.insert2;

public class Test05아이템등록 {

	public static void main(String[] args) {
		
		ItemDto itemDto = new ItemDto();
		itemDto.setItemName("휴지");
		itemDto.setItemType("생필품");
		itemDto.setItemPrice(10000);
		itemDto.setItemDiscountRate(0.2f);
		itemDto.setItmQty(4);
		itemDto.setItemEarly("N");
		
		ItemDao itemDao = new ItemDao();
		itemDao.insert(itemDto);
		
		System.out.println("아이템 등록 완료");
		
	}

}
