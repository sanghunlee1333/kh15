package data3;

import java.time.LocalDate;

public class Test02성인판정프로그램2 {
	public static void main (String[] args) {
		
		//입력
		int birth = 2006;
		//int year = Year.now().getValue(); //google
		int year = LocalDate.now().getYear(); //gpt
		
		//처리
		//- birth로 사용자의 나이를 구한 뒤 비교
		int age = year - birth + 1;
		boolean adult = age >= 20;
		
		//출력
		System.out.println(adult);
	}
}
