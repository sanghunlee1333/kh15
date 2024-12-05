package condition;

import java.util.Scanner;

public class Test07주차요금계산기 {

	public static void main(String[] args) {

		// 입력
		Scanner sc = new Scanner(System.in);
		System.out.print("들어온 시간 : ");
		int in = sc.nextInt();
		System.out.print("나간 시간 : ");
		int out = sc.nextInt();

		// 처리
		int inHour = in / 100, inMinute = in % 100;
		int outHour = out / 100, outMinute = out % 100;

		int inTime = inHour * 60 + inMinute;
		int outTime = outHour * 60 + outMinute;

		int time = outTime - inTime; // 시간차이(분)
		int hour = time / 60, minute = time % 60;

		// time을 이용하여 요금을 계산
		int price = time / 10 * 500;

		// 출력
		System.out.println("주차시간 총 " + hour + "시간 " + minute + "분");
		if (time <= 30) {
			System.out.println("30분 미만 주차(회차)");
		} else if (price > 10000) {
			System.out.println("주차요금 : 10000원");
		} else {
			System.out.println("주차요금 : " + price + "원");
		}

	}

}
