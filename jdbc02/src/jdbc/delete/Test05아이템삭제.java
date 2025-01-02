package jdbc.delete;

import jdbc.dao.ItemDao;

public class Test05아이템삭제 {

	public static void main(String[] args) {
		
		int itemNo = 24;
		
		ItemDao itemDao = new ItemDao();
		boolean success = itemDao.delete(itemNo);
		
		if(success) System.out.println("아이템 삭제 완료");
		else System.out.println("존재하지 않은 아이템");
		
	}

}
