package api.lang.string;

import java.util.Scanner;

public class Test03로그인문제 {

	public static void main(String[] args) {

		// 입력
		Scanner sc = new Scanner(System.in);

		System.out.print("아이디를 입력하세요 : ");
		String userID = sc.next();
		System.out.print("비밀번호를 입력하세요 : ");
		String userPassword = sc.next();

		// 처리
		//valid -> 유효하다
		//boolean valid = userID == "khacademy" && userPassword == "123456"; // 아이디 일치 && 비밀번호 일치 -> 실패
		boolean valid = userID.equalsIgnoreCase("khacamedy") && userPassword.equals("123456"); //-> 성공
		if (valid) {
			System.out.println("로그인 성공");

		} 
		else {
			System.out.println("로그인 실패");
		}
	}

}
