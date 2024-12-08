package loop2;

import java.util.Scanner;

public class Test03소수찾기 {

	public static void main(String[] args) {

		// 입력
		Scanner sc = new Scanner(System.in);

		System.out.print("숫자 입력 : ");
		int number = sc.nextInt();
		int count = 0;

		// 처리
		boolean flag = true;
		for (int i = 1; i <= number; i++) {
			if (number % i == 0) {
				count++;
				// (성능 업그레이드)number가 되기 전에 카운트가 2이상이면 더 볼 필요 없다.
				if (i < number && count >= 2) {
					flag = false;
					break; // 이 구문을 나가라
				}
			}
		}

		// 출력
		//System.out.println("0이 나온 횟수 : " + count);
		if (flag == true /*count == 2*/) {
			System.out.println("소수입니다.");
		} else {
			System.out.println("소수가 아닙니다.");
		}
	}

}
