package api.lang.object;

//자바는 java.lang 패키지에 대한 import를 자동으로 해준다(필수 패키지)
//import java.lang.Object;

public class Test01Object클래스 {

	public static void main(String[] args) {
		//인스턴스 생성
		Object a = new Object();
		Object b = new Object();
		
		//메소드 실행
		System.out.println("a = " + a.hashCode());
		System.out.println("b = " + b.hashCode());
	}

}
