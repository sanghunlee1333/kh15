package oop.poly2_1;

//상속을 받든 안받든 똑같이 메소드를 만들어야하긴 하다
//하지만 상속을 받으면, 다형성이라는 장점이 있다

public class Macbook extends Notebook {
	
	@Override
	public void power() {
		System.out.println("맥북의 전원을 켭니다");
	}
	@Override
	public void video() {
		System.out.println("맥북의 동영상 재생 기능을 실행합니다");
	}
	@Override
	public void typing() {
		System.out.println("맥북의 타이핑 기능을 실행합니다");
	}

}
