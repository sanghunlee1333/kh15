package oop.method3;

public class Test01커피숍메뉴정보 {

	public static void main(String[] args) {
		//인스턴스(객체) 생성
		Menu m1 = new Menu();
		Menu m2 = new Menu();
		Menu m3 = new Menu();
		Menu m4 = new Menu();
		
		//초기화
		m1.init("아메리카노", "음료", 2500, true);
		m2.init("모카라떼", "음료", 3500);
		m3.init("치즈케이크", "디저트", 5000, true);
		m4.init("마카롱", "디저트", 3000);
		
		m1.show();
		m2.show();
		m3.show();
		m4.show();
	}

}
