package array;

import java.util.Random;
import java.util.Scanner;

public class Test05점심메뉴추천기 {

	public static void main(String[] args) {

		// 5칸의 배열에 사용자가 입력하는 메뉴 넣기
		Scanner sc = new Scanner(System.in);
		String[] menuList = new String[5];

		// 입력
		for (int i = 0; i < menuList.length; i++) {
			System.out.print("메뉴 입력 : ");
			menuList[i] = sc.next();
		}

		// 출력
		Random r = new Random();
		//int position = r.nextInt(5); 5라고 적기보단, 메뉴 갯수가 달라질 수 있으므로 length를 적는 것
		int position = r.nextInt(menuList.length); // 0부터 5개
		System.out.println("추천 메뉴는 [" + menuList[position] + "] 입니다");
	}

}
