package api.lang.string;

//API(Application Programming Interface)
//- 자바 API는 자바에서 제공해주는 기능들의 총합
//- API에는 반드시 문서(Document)가 존재
//- 문서에서 필요한 기능을 찾아 사용할 수 있으면 충분
//- 문서에서는 코드를 제공하지 않고 간단한 소개만 존재
//- JDK 버전을 맞춰서 보는 게 좋다
//
//자바API의 체계
//- 모듈(module) > 패키지(package) > 구성요소
//- 모듈은 배포가 가능한 하나의 단위(ex : 웹개발용 모듈, 데스크탑 개발용 모듈, 모바일 개발용 모듈)
//- 패키지는 용도별로 구성요소들을 모아둔 단위
//- 구성요소는 class, interface, enum, annotation, exception, error 등 이 존재
//
//Object는 모든 클래스 체계에서 최상위 클래스
//내가 만든 클래스도 적용될까?


public class Test01String클래스 {

	public static void main(String[] args) {
		//인스턴스 생성
		//String a = "hello";
		
		String a = new String("hello");
		char[] ch = new char[] {'h','e','l','l','o'};
		String b = new String(ch);
		
		byte[] by = new byte[] {104, 101, 108, 108, 111};
		String c = new String(by);
		
		System.out.println("a = " + a.hashCode()); //글자가 같으면 같다고 생각
		System.out.println("b = " + b.hashCode());
		System.out.println("c = " + c.hashCode());
		
		System.out.println("a = " + a.toString()); //글자가 같으면 같다고 생각
		System.out.println("b = " + b.toString());
		System.out.println("c = " + c.toString());
		
		System.out.println(a == b); //인스턴스를 비교
		System.out.println(a.equals(b)); //글자를 비교
		
		String d = "Hello"; //문자열의 약식 생성 명령
		System.out.println(a.equals(d)); //a와 d가 같습니까?
		System.out.println(a.equalsIgnoreCase(d)); //대소문자 무시하고 비교 //Object가 아니고 String
	}

}
