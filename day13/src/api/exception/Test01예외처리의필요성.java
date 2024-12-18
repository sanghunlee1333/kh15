package api.exception;

import java.util.Scanner;

public class Test01예외처리의필요성 {

	public static void main(String[] args) {
		
		//에러(Error) - 프로그램이 실행되지 않는 상황
		//예외(Exception) - 프로그램 실행 중에 발생하는 돌발 상황
		//에러는 개발자가 처리할 수 없음
		
		//예외가 발생하는 상황 - 1/n 계산기
		Scanner sc = new Scanner(System.in);
		
		System.out.print("금액 : ");
		int money = sc.nextInt();
		
		System.out.print("인원수 : ");
		int people = sc.nextInt();
		
		int div = money / people;
		int mod = money % people;
		
		System.out.println("1인당 금액 = " + div + "원");
		System.out.println("자투리 금액 = " + mod + "원");
	}

}
