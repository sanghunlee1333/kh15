package condition;

import java.util.Scanner;

public class Test02지각판정기3 {

	public static void main(String[] args) {

		// 입력
		Scanner sc = new Scanner(System.in);
		System.out.print("입실시각 : ");
		int time = sc.nextInt();

		// 처리
		int deadline = 940;

		// - 시간과 분을 분할한 다음 분으로 합쳐서 비교
		int h1 = time / 100;
		int m1 = time % 100;
		int h2 = deadline / 100;
		int m2 = deadline % 100;

		int t1 = h1 * 60 + m1;
		int t2 = h2 * 60 + m2;

		boolean ok = t1 <= t2;

		// 출력
		// if (ok == true) { // 있으나마나한 코드
		if (ok) {
			System.out.println("정상 출석입니다");
		} else {
			System.out.println("지각입니다");
		}

	}

}
