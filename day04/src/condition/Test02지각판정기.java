package condition;

import java.util.Scanner;

public class Test02지각판정기 {

	public static void main(String[] args) {
		
		//입력
		//Scanner sc = new Scanner(System.in);
		
		System.out.print("입실시각 : ");
		int time = 935;
		//int time = sc.nextInt();
		//int h = time / 100;
		//int m = time % 100;
		
		//처리
		int deadline = 940;
		boolean ok = time <= deadline;
		
		//출력
		if (ok == true) {
			System.out.println("정상 출석입니다");
		}
		else {
			System.out.println("지각입니다");
		}
		
		/*
		//출력
		if (h <= 9 && m <= 40 ) {
		System.out.println("정상 출석입니다.");
		}
		else {
		System.out.println("지각입니다.");
		}
		*/
	}

}
