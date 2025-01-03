package jdbc.select2;

import java.util.List;

import jdbc.dao.MenuDao;
import jdbc.dto.MenuDto;

public class Test04메뉴검색 {

	public static void main(String[] args) {
	
//		String column = "메뉴명";
//		String keyword = "핫아메리카노";
		String column = "메뉴종류";
		String keyword = "음료";

		MenuDao menuDao = new MenuDao();
		List<MenuDto> list = menuDao.selectList(column, keyword);
		
		for(MenuDto menuDto : list) {
			System.out.println(menuDto);
		}
		
	}

}
