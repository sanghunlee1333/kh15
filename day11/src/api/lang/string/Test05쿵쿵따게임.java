package api.lang.string;

import java.util.Scanner;

public class Test05쿵쿵따게임 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String given = "토요일";
		while (true) {

			System.out.print(given + "! 쿵쿵따!");
			String input = sc.next();

			// 유효한 입력인지 검사

			// 조건이 안맞을 경우만 작성! 맞을 경우엔 반복문 처음으로 돌아가도록
			if (input.length() != 3)
				break; // 3글자가 아니면 break
			if (input.charAt(0) != given.charAt(given.length() - 1))
				break;
			// 연결되지 않으면 break //원시형(char, int..)끼리의 비교는 비교연산자 사용 가능!
			// 문자열은 참조형이므로 비교연산자 사용하면 안됨

			given = input; // 제시어 교체

		}

		System.out.print("GAME OVER");
	}

}
