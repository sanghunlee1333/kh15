package oop.inherit7;

public class Galaxy24s extends Galaxy { //일반 클래스에서 빨간줄 뜨는 문제는 생성자 생성 문제 및 추상 메소드 미구현 문제 때문!
	
	public Galaxy24s(String number, String color) {
		super(number, color);
	}
	
	@Override//애노테이션(annotation) - 바로 뒤 코드의 역할을 지정(명찰, 해시태그) 지우지 않는게 맞다
	public void call() {
		System.out.println("갤럭시24s 전화 기능 실행");
	}
	
	@Override 
	public void sms() {
		System.out.println("갤럭시24s 문자 기능 실행");
	}
	
	@Override
	public void samsungPay() {
		System.out.println("갤럭시24s 삼성페이 기능 실행");
	}
	
	public void bixby() {
		System.out.println("갤럭시24s 음성인식 기능 실행");
	}

	
	
	
	
}
