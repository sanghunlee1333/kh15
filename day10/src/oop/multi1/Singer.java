package oop.multi1;
//인터페이스
//- 다중상속 전용 클래스
//- 다중 상속 시 문제가 되는 요소를 제거했음
//- public 접근 제한만 가능
public interface Singer {
	//필드 생성 불가 (상수만 생성 가능)
	//private String name;
	
	//- 생성자 생성 불가 - 상위 클래스에서 생성자 만들면 하위에서도 만들어야 하므로
	
	//- 메소드는 추상 메소드만 생성 가능
	//어떤 기능이 있다고만 설정
	/*public abstract*/ void sing(); //앞에 키워드를 써도 안 써도 똑같다
	
}
