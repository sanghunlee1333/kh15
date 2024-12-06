package loop2;

import java.util.Scanner;

public class Test02짝수홀수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int even = 0, odd = 0;

		for (int i = 0; i < 10; i++) {
			System.out.print("숫자를 입력하세요 : ");
			int num = sc.nextInt();
			if (num % 2 == 0) {
				even++;
			} else if (num % 2 == 1) {
				odd++;
			}
		}
		System.out.println("짝수 : " + even + "번, " + "홀수 : " + odd + "번");
	}

}
