package oop.method4;

public class Product {
	// 멤버 필드
	String name;
	String type;
	int price;
	int discount; // 더하고 빼고 할 수 있으니 문자가 아닌, 숫자로 구분!
	int amount;
	boolean dawnDelivery;

	// 멤버 메소드
	void init(String name, String type, int price) {
		this.init(name, type, price, 0, 0, false); // this(주인공).init(매개변수1, 매개변수2,...) -> 많은 경우를 다 매칭시키기 귀찮기 때문에 해당 방식으로도 가능
	}

	// void init(String name, String type, int price, int discount) {} //이름만 다르지 같은
	// 자료형 형태를 띄고 있으므로 불가하다!
	void init(String name, String type, int price, int amount) {
		this.init(name, type, price, amount, 0, false);
	}

	void init(String name, String type, int price, int amount, int discount) {
		this.init(name, type, price, amount, discount, false);
	}

	void init(String name, String type, int price, int amount, int discount, boolean dawnDelivery) {
		this.name = name;
		this.type = type;
		this.price = price;
		this.amount = amount;
		this.discount = discount;
		this.dawnDelivery = dawnDelivery;
	}

	void show() {
		System.out.println("[상품 정보]");
		System.out.println("상품명 : " + this.name);
		System.out.println("상품분류 : " + this.type);
		if (this.discount == 0) {
			System.out.println("판매가 : " + this.price + "원");
			System.out.println("수량 : " + this.amount);
		}
		else {
			int discount = this.price * (100 - this.discount) / 100;
			System.out.println("판매가 : " + discount + "원(" + this.price + "원)");
		}
		System.out.println("수량 : " + this.amount);
		if (this.dawnDelivery) {
			System.out.println("새벽배송 여부 가능하며 3천원 추가됩니다");
		}
	}
}
