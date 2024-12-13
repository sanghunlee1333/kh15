package oop.inherit7;

public class GalaxyFold6 extends Galaxy {

	public GalaxyFold6(String number, String color) {
		super(number, color);
	}

	@Override
	public void call() {
		System.out.println("갤럭시폴드6 전화 기능 실행");
	}

	@Override
	public void sms() {
		System.out.println("갤럭시폴드6 문자 기능 실행");
	}

	@Override
	public void samsungPay() {
		System.out.println("갤럭시폴드6 삼성페이 기능 실행");
	}

	public void iris() {
		System.out.println("갤럭시폴드6 홍채인식 기능 실행");
	}

}
