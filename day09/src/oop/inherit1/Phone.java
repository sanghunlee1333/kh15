package oop.inherit1;

//휴대폰의 공통 내용

public class Phone {
	private String number; //전화번호는 계산 안 하니까 String으로 선언
	private String color;
	
	//setter & getter 생략
		
	public void call() {}
	public void sms() {}
	public void camera() {}
	public void internet() {}
	public void game() {}
}
