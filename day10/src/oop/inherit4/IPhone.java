package oop.inherit4;


public class IPhone extends Phone {
	
	//Source - Generate Constructors from SuperClass
	//상위 클래스 생성자를 맞춰서 생성
	public IPhone(String number) {
		super(number); //아래(IPhone)에서 위(Phone)로 데이터 전달
	}
	
	//오버로딩(overload - 과적하다) - 원래의 기능에서 여러 옵션을 주기 위해
	//오버라이딩(override - 보다 우선하다) - 원래의 기능을 가려버리기 위해 (수정된 것 같은 효과)
	
	//상위 클래스의 메소드를 동일하게 한 번 더 작성한다(override)
	public void call() {
		System.out.println("아이폰의 통화 기능 실행"); //상위 클래스의 메소드가 실행이 안됨
	}
	
}
