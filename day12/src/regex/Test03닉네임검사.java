package regex;

import java.util.Scanner;

public class Test03닉네임검사 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("닉네임을 입력하세요 : ");
		String nickname = sc.next();
		String regex = "^[가-힣][가-힣0-9]{1,9}$"; //일반검사
		//String regex = "^(?!=.*?운영자)[가-힣][가-힣0-9]{1,9}$"; //부정탐색
		
		if(nickname.matches(regex)) {
				System.out.println("올바른 형식의 닉네임입니다");
		}
		else {
			System.out.println("닉네임은 한글로 시작하며 숫자 포함 2~10자로 작성해야 합니다");
		}
	}
	
//	^(0[1-9]|[1-4][0-9]|50)$ // ( = 그룹을 만들어주는 용도
//	^(0[1-9]|1[0-9]|2[0-9]|3[0-9]|4[0-9]|50)$ // | = or

}
