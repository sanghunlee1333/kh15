package oop.inherit6;

public class Galaxy extends Phone {
	
	//재정의/구현이 안되어 있으면 에러 뜸
	
	//재정의(override) or 구현(implement)
	@Override
	public void call() {
		System.out.println("갤럭시의 전화기능 실행");
	}

	@Override
	public void sms() {
		System.out.println("갤럭시의 문자기능 실행");
	}

	@Override
	public void internet() {
		System.out.println("갤럭시의 인터넷기능 실행");
	} 
	
	
}
