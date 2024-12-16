package api.lang.object;

//자바는 java.lang 패키지에 대한 import를 자동으로 해준다(필수 패키지)
//import java.lang.Object;

public class Test01Object클래스 {

	public static void main(String[] args) {
		//Object 클래스
		//- 모든 클래스의 규격을 정의하는 최상위 클래스
		//- 인스턴스는 고유한 해시코드(일련번호)를 가진다
		//- 인스턴스는 요약 정보를 출력할 수 있는 메소드를 가진다
		//- 모든 클래스는 필요에 따라 위 메소드들을 재정의할 수 있다
		
		//인스턴스 생성
		Object a = new Object();
		Object b = new Object();
		
		//메소드 실행
		System.out.println("a = " + a.hashCode()); //hashCode는 인스턴스의 일련번호(주소X)를 알려주는 메소드
		System.out.println("b = " + b.hashCode());
		
		System.out.println("a = " + a.toString());
		System.out.println("b = " + b.toString());
		
		//뭐가 같은지 정확히 모름. a와 b가 같은 학생인가요? 
		System.out.println(a == b); //a와 b가 같나요? 연산자는 변경 불가
		System.out.println(a.equals(b)); //a와 b가 같나요? 메소드는 변경 가능
		System.out.println(a.equals("hello"));
		System.out.println(a.equals(100));
	}

}
