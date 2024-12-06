package condition2;

import java.util.Scanner;

public class Test02일수구하기2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("월 입력 : ");
		int month = sc.nextInt();
		
		switch (month) {//month를 살펴보고 적절한 위치로 이동시키세요! 변수는 불가
		case 2 : 
			System.out.println("28일");
			break;
		case 4, 6, 9, 11 : //콤마는 자바13부터 가능! 백준은 불가
			System.out.println("30일");
			break;
		default : 
			System.out.println("31일");
			break;
		}
		
	}

}
