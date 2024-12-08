package loop2;

import java.util.Random;
import java.util.Scanner;

public class Test05구구단게임 {

	public static void main(String[] args) {

		Random r = new Random();
		Scanner sc = new Scanner(System.in);

		int correct = 0;
		int wrong = 0;
		int sumScore = 0;
		int basicScore = 10, hardScore = 20;
		int combo = 0;
		int total = 0;

		for (int i = 0; i < 10; i++) {
			int left = r.nextInt(8) + 2;
			int right = r.nextInt(9) + 1;
			System.out.print(left + " x " + right + " = ");
			int answer = sc.nextInt();

			if (answer == left * right) {
				correct++;
				combo++;
				if (left >= 6) {
					sumScore = combo * hardScore;
				} else {
					sumScore = combo * basicScore;
				}
				total += sumScore;
			} else {
				wrong++;
				combo = 0;
				sumScore = 0;
			}
		}
		System.out.println("정답 " + correct + "개");
		System.out.println("오답 " + wrong + "개");
		System.out.println("총 점수는 " + total + "점");
	}

}
