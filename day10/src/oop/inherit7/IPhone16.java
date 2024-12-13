package oop.inherit7;

public class IPhone16 extends IPhone {

	public IPhone16(String number, String color) {
		super(number, color);
	}

	@Override
	public void call() {
		System.out.println("아이폰16 전화 기능 실행");
	}

	@Override
	public void sms() {
		System.out.println("아이폰16 문자 기능 실행");
	}

	@Override
	public void siri() {
		System.out.println("아이폰16 음성인식 기능 실행");
	}

	public void facetime() {
		System.out.println("아이폰16 영상통화 기능 실행");
	}

}
