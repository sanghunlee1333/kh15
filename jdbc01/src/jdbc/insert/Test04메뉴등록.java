package jdbc.insert;

import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.util.JdbcFactory;

public class Test04메뉴등록 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("메뉴 이름 : ");
		String menuName = sc.next();
		
		System.out.print("메뉴 종류 : ");
		String menuType = sc.next();
		
		System.out.print("메뉴 가격 : ");
		int menuPrice = sc.nextInt();
		
		System.out.print("행사 여부(1:행사중, 2:행사아님) : ");
		int menuEvent = sc.nextInt();		
		
		JdbcTemplate jdbctemplate = JdbcFactory.createTemplate();
		String sql = "insert into menu(menu_no, menu_name, menu_type, menu_price, menu_event) "
				+ "values(menu_seq.nextval, ?, ?, ?, ?)";
		Object[] data = {menuName, menuType, menuPrice, (menuEvent == 1) ? 'Y' : 'N'};
				
		jdbctemplate.update(sql, data);
		
	}

}
