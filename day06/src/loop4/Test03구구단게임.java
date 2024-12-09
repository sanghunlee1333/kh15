package loop4;

import java.util.Random;
import java.util.Scanner;

public class Test03구구단게임 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		int life = 3;

		while (true) {
			int left = r.nextInt(8) + 2;
			int right = r.nextInt(9) + 1;
			System.out.print(left + " x " + right + " = ");
			int user = sc.nextInt();

			boolean answer = left * right == user;
			if (!answer) {
				life--;
				if (life == 0) {
					break;
				}
				System.out.println("틀렸습니다. 기회는 " + life + "번 남았습니다");
			} else {
				System.out.println("정답입니다");
			}

		}
		System.out.println("게임 오버");

	}

}
