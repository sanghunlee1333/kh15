package jdbc.insert2;

public class Test04메뉴등록 {

	public static void main(String[] args) {
		
		MenuDto menuDto = new MenuDto();
		menuDto.setMenuName("초코케이크");
		menuDto.setMenuType("케이크");
		menuDto.setMenuPrice(25000);
		menuDto.setMenuEvent("Y");
		
		MenuDao menuDao = new MenuDao();
		menuDao.insert(menuDto);
		
		System.out.println("메뉴 등록 완료");
		
	}

}
