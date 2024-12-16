package api.lang.string;

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
