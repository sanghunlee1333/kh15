package loop4;

import java.util.Random;
import java.util.Scanner;

public class Test04업다운게임 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Random r = new Random();

		int count = 0; // while문에서는 for문과 달리 반복문이 몇 번 실행됐는지 알기어려우므로, count를 생성
		int answer = r.nextInt(1000) + 1;
		// System.out.println(answer); //개발 중에는 결과가 항상 보이도록 하는게 중요. 개발 중에도 안보이면 굉장히 어려움.

		while (true) {
			System.out.print("1~1000 사이 숫자를 입력하세요 : ");
			int user = sc.nextInt();
			count++;
			if (answer == user) {
				System.out.println("게임 종료!");
				System.out.println("정답! 총 " + count + "번 만에 맞추셨습니다!");
				break;
			} else if (answer > user) {
				System.out.println("업!");
			} else {
				System.out.println("다운!");
			}

		}

	}

}
