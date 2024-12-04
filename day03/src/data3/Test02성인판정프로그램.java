package data3;

public class Test02성인판정프로그램 {
	public static void main (String[] args) {
		
		//입력
		int birth = 2006;
		
		//처리
		//- 20살은 2005년생이니까.. 안좋은 예시
		boolean adult = birth <= 2005;
		
		//출력
		System.out.println(adult);
	}
}
