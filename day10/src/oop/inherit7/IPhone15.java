package oop.inherit7;

public class IPhone15 extends IPhone {

	public IPhone15(String number, String color) {
		super(number, color);
	}

	@Override
	public void call() {
		System.out.println("아이폰15 전화 기능 실행");
	}
	
	@Override
	public void sms() {
		System.out.println("아이폰15 문자 기능 실행");
	}

	@Override
	public void siri() {
		System.out.println("아이폰15 음성인식 기능 실행");
	}

	//@Override -> 이걸 붙이면 에러뜬다! 사기라고 뜨는 것.
	public void itunes() {
		System.out.println("아이폰15 아이튠즈 기능 실행");
	}

}
