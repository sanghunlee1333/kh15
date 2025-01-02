package jdbc.delete;

import jdbc.dao.MenuDao;

public class Test04메뉴삭제 {

	public static void main(String[] args) {
		
		int menuNo = 26;
		
		MenuDao menuDao = new MenuDao();
		boolean success = menuDao.delete(menuNo);
		
		if(success) System.out.println("메뉴 삭제 완료");
		else System.out.println("존재하지 않은 메뉴");
		
	}

}
