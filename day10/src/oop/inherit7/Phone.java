package oop.inherit7;

public abstract class Phone {
	// 필드
	private String number; // 선택 가능
	protected String color; // 고정 불가

	public String getNumber() {
		return number;
	}

	// 생성자
	public Phone(String number, String color) {
		this.setNumber(number);
		this.setColor(color);
	}

	// 메소드
	public void setNumber(String number) {
		this.number = number;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public abstract void call();

	public abstract void sms();

	public final void show() { // 추상으로 만들면 안됨
		System.out.println("<전화기 정보>");
		System.out.println("전화번호 : " + this.number);
		System.out.println("색상 : " + this.color);
	}
}
