package oop.poly2_1;

public class Galaxybook extends Notebook {
	
	@Override
	public void power() {
		System.out.println("갤럭시북의 전원을 켭니다");
	}
	@Override
	public void video() {
		System.out.println("갤럭시북의 동영상 재생 기능을 실행합니다");
	}
	@Override
	public void typing() {
		System.out.println("갤럭시북의 타이핑 기능을 실행합니다");
	}


}
