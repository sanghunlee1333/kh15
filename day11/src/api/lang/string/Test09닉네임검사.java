package api.lang.string;

import java.util.Scanner;

public class Test09닉네임검사 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String nickname = sc.next();

		if (nickname.length() < 2 || nickname.length() > 10) {
			System.out.println("닉네임 형식에 맞지 않습니다");
		}

		else if (nickname.contains("운영자")) {
			System.out.println("닉네임 형식에 맞지 않습니다");
		}

		for (int i = '0'; i <= '9'; i++) {
			if (nickname.charAt(0) == (char) i) {
				System.out.println("닉네임 형식에 맞지 않습니다");
				break;
			}
		}

		for (int i = 0; i < nickname.length(); i++) {
			if (nickname.charAt(i) < '가' && nickname.charAt(i) > '힣') {
				System.out.println("닉네임 형식에 맞지 않습니다");
				break;
			}
		}
		for (int i = 1; i < nickname.length(); i++) {
			if (nickname.charAt(i) < '0' || nickname.charAt(i) > '9' || nickname.charAt(i) < '가' || nickname.charAt(i) > '힣') {
				System.out.println("닉네임 형식에 맞지 않습니다");
				break;
			}
			System.out.println("닉네임 설정 완료");
		}
		

	}

}
