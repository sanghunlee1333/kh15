package regex;

import java.util.Scanner;

public class Test02아이디검사 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("아이디를 입력하세요 : ");
		String id = sc.next();
				
		String regex = "^[a-z][a-z0-9\\-_]{4,19}$"; // \으로 애매한 표현 구분 
													// 정규표현식은 \ 하나로 표현되지만, 자바에서는 \하나로면 표기할 수 없기 때문에 \\ 두개로 표현
		
		if(id.matches(regex)) {
			System.out.print("올바른 아이디 형식입니다");
		}
		else {
			System.out.print("아이디는 영문소문자로 시작하고 숫자를 포함해 5~20자로 작성해야 합니다");
		}
		
	}

}
