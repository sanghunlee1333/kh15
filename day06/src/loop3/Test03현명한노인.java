package loop3;

import java.util.Scanner;

public class Test03현명한노인 {

	public static void main(String[] args) {

		/*
		 * int coin = 1; int total = 0; for (int day = 1; day <= 30; day++) { total +=
		 * coin; System.out.println(day + "일차 금화 개수 : " + coin + "개"); coin *= 2; }
		 * System.out.println("총 금화 개수 : " + total + "개");
		 */

		// 뒤짚힘 현상

		long coin = 1L; //long타입은 끝에 L붙여야 함
		long total = 0L;
		for (int day = 1; day <= 40; day++) { //결과값이 int의 범위를 벗어나므로 더 큰 타입을 사용
			total += coin;
			System.out.println(day + "일차 금화 개수 : " + coin + "개");
			coin *= 2;
		}
		System.out.println("총 금화 개수 : " + total + "개");

	}

}
