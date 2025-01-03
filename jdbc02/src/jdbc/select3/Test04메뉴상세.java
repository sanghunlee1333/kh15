package jdbc.select3;

import jdbc.dao.MenuDao;
import jdbc.dto.MenuDto;

public class Test04메뉴상세 {

	public static void main(String[] args) {

		int menuNo = 27;
		
		MenuDao menuDao = new MenuDao();
		MenuDto menuDto = menuDao.selectOne(menuNo);
		
		if(menuDto == null) {
			System.out.println("존재하지 않은 메뉴 번호");
		}
		else {
			System.out.println(menuDto);
		}
		
	}

}
