package loop5;

import java.util.Scanner;

public class Test01선실행후반복 {

	public static void main(String[] args) {
		// do-while 반복문 -> while로 대체 가능
		// 중괄호 뒤에 세미콜론을 찍어야돼서 요즘 흐름과 맞지 않아 잘 사용X
		// 또한 do와 while 같은 구문임에도 불구하고 중괄호를 나눠야해서 변수를 따로 선언해둬야 한다.
		// - 먼저 실행하고 반복할지 말지를 나중에 검사하는 형태의 반복문

		// (ex) 사용자에게 점수(0~100)를 정상적으로 입력할 때까지 입력받기
		Scanner sc = new Scanner(System.in);
		int score;

		do {
			System.out.print("점수 입력 : ");
			score = sc.nextInt();
		}
		// while (반복 조건);
		while (score < 0 || score > 100); // 조건 - 잘못 입력했다면 반복해라
	}

}
