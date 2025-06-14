package oop.inherit6;

//상위 클래스를 만들 때 불편사항?
//1. 상위 클래스의 인스턴스 생성이 안되어야 하지만 된다. 구현은 안하고 기준이 되는 설계도만 작성할 것이므로..
//2. 내용 구현하기가 애매한 메소드들이 발생한다. ex) 전화기라면 전화기능이 있어야 한다. 하지만 전화기 마다 전화 기능이 다르므로 어떻게 구현할지는 모른다.
//---> abstract 키워드를 클래스와 메소드에 붙여서 해결! 왼쪽에 파일 이미지에도 A가 붙음
//---> 재정의 강제 키워드. 반드시 상속받은 하위 클래스에서 재정의(override) 혹은 구현(implement)를 해야함
//앞으로 상위는 추상 클래스 / 하위는 일반 클래스로 만들자

//상속을 하면 실수없이, 빠르게 코드를 작성할 수 있음!! (장점)

public abstract class Phone { //추상 클래스
	
	//일반 필드, 메소드, 생성자도 만들 수 있음
	
	//추상 메소드 -> 단, 추상 클래스에만 생성 가능!
	public abstract void call(); //구현이 애매한 것들은 선언만 해두는 것
	public abstract void sms();
	public abstract void internet();
	
		
	
}
