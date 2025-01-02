package jdbc.select;

import java.util.List;

import jdbc.dao.MenuDao;
import jdbc.dto.MenuDto;

public class Test04메뉴조회 {

	public static void main(String[] args) {
		
		MenuDao menuDao = new MenuDao();
		List<MenuDto> list = menuDao.selectList();
		
		for(MenuDto menuDto : list) {
			System.out.println(menuDto);
		}
		
	}

}
