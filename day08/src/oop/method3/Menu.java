package oop.method3;

public class Menu {
	// 멤버 필드
	String menu;
	String division;
	int price;
	boolean event;

	// 멤버 메소드
	// 메소드 오버로딩(method overloading)
	//- 같은 이름으로 형태만 다르게 해서 여러 개의 메소드를 만드는 행위
	//- 이용의 편리성을 극대화
	//- 뭘 좋아할 지 몰라서 다 준비해봤어
	void init(String menu, String division, int price) {
		this.menu = menu;
		this.division = division;
		this.price = price;
		this.event = false;
	}
	
	void init(String menu, String division, int price, boolean event) {
		this.menu = menu;
		this.division = division;
		this.price = price;
		this.event = event;
	}

	void show() {
		System.out.println("[메뉴 정보]");
		if (this.event) {
			System.out.println("메뉴명 : " + this.menu + "(행사중)");
			System.out.println("분류 : " + this.division);
			System.out.println("가격 : " + this.price * (100 - 20) / 100 + "원");
		} else {
			System.out.println("메뉴명 : " + this.menu);
			System.out.println("분류 : " + this.division);
			System.out.println("가격 : " + this.price + "원");
		}

	}

}
