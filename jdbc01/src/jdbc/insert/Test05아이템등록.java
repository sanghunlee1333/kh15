package jdbc.insert;

import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.util.JdbcFactory;

public class Test05아이템등록 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//입력
		System.out.print("아이템 이름 : ");
		String itemName = sc.next();
		
		System.out.print("아이템 종류 : ");
		String itemType = sc.next();
		
		System.out.print("가격 : ");
		int itemPrice = sc.nextInt();
		
		System.out.print("할인율(0 ~ 1) : ");
		Float itemDiscountRate = sc.nextFloat(); //null이 가능해야하기 때문에 Float로 써야한다! + 소수점
		
		System.out.print("수량 : ");
		int itemQty = sc.nextInt();
		
		System.out.print("새벽배송 여부(가능 : Y, 불가능 : N) : ");
		String itemEarly = sc.next();
		
		//처리
		JdbcTemplate jdbctemplate = JdbcFactory.createTemplate();
		String sql = "insert into item(item_no, item_name, item_type, item_price, item_discount_rate, item_qty, item_early) "
				+ "values(item_seq.nextval, ?, ?, ?, ?, ?, ?)";
		Object[] data = {itemName, itemType, itemPrice, itemDiscountRate, itemQty, itemEarly};
		
		jdbctemplate.update(sql, data);
		
		//출력
		System.out.println("아이템 등록 완료");
		
	}

}
