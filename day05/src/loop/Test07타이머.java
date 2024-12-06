package loop;

import java.util.Scanner;

public class Test07타이머 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("분 입력 : ");
		int minute = sc.nextInt();
		System.out.print("초 입력 : ");
		int second = sc.nextInt();

		int total = minute * 60 + second;
		
		/*
		for (int i = total; i > 0; i--) {
			System.out.println(minute + "분 " + second + "초 후 알림이 울립니다");
			second--;
			if (second == -1) {
				minute--;
				second = 59;
			}
		}
		System.out.println("시간이 다 되었습니다!");
		*/
		for (int i = total; i > 0; i--) {
			int m = i / 60, s = i % 60;
			System.out.println(m + "분 " + s + "초 후 알림이 울립니다");
		}
		System.out.println("시간이 다 되었습니다!");
	}

}
