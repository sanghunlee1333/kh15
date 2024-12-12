package oop.keyword1;

public class Test01Final키워드 {

	public static void main(String[] args) {
		// final 키워드는 변수, 메소드, 클래스에 붙여 "마지막"효과를 부여
		// - 변수 - 값을 재할당(assignment)하는 것이 금지된다.
		// - 메소드 - 메소드를 재정의(override)하는 것이 금지된다.
		// - 클래스 - 클래스를 상속(inherit)받는 것이 금지된다.
		
//		int a = 10;
//		a = 20; //10이 사라지고 20이 할당
//		a++;
//		System.out.println("a = " + a);
		
		final int a = 10; //할당
		//a = 20; //재할당
		//a++; //재할당
		System.out.println("a = " + a);
	}

}
