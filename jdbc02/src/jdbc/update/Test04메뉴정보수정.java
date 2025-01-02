package jdbc.update;

import jdbc.dao.MenuDao;
import jdbc.dto.MenuDto;

public class Test04메뉴정보수정 {

	public static void main(String[] args) {
		
		MenuDto menuDto = new MenuDto();
		menuDto.setMenuNo(26);
		menuDto.setMenuName("아샷추");
		menuDto.setMenuType("음료");
		menuDto.setMenuPrice(6000);
		menuDto.setMenuEvent("N");
		
		MenuDao menuDao = new MenuDao();
		boolean success = menuDao.update(menuDto);
		if(success) System.out.println("메뉴 정보 수정 완료");
		else System.out.println("대상이 아닙니다");
		
	}

}
