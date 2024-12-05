package io;

import java.time.LocalDate;
import java.util.Scanner;

public class Test04나이계산기 {

	public static void main(String[] args) {

		/*
		 
		// 입력
		Scanner sc = new Scanner(System.in);
		
		// 처리
		System.out.print("생년월일 8자리 입력 : ");
		int birth = sc.nextInt();
		
		int userYear = birth / 10000;
		int userMonth = birth % 10000 / 100;

		int currentYear = LocalDate.now().getYear();
		int currentMonth = LocalDate.now().getMonthValue();

		int koreanAge = currentYear - userYear + 1;

		int totalMonth = currentYear * 12 + currentMonth;
		int userTotalMonth = userYear * 12 + userMonth;
		int subMonth = (totalMonth - userTotalMonth);

		int age = subMonth / 12;
		int month = subMonth % 12;

		// 출력
		System.out.println("당신의 한국나이 = " + koreanAge + "세");
		System.out.println("당신의 만나이 = " + age + "세 " + "(" + age + "년 " + month + "개월)");
		
		*/
		
		//입력
		Scanner sc = new Scanner(System.in);
		System.out.println("출생년도 8자리를 입력하세요");
		int birth = sc.nextInt();
		
		//처리
		int year = birth / 10000;
		int month = birth % 10000 / 100;
		
		int koreanAge = LocalDate.now().getYear() - year + 1;
		
		int current = LocalDate.now().getYear() * 12 
								+ LocalDate.now().getMonthValue();
		int born = year * 12 + month;
		int diff = current - born; //개월수
		
		int americanAge = diff / 12;
				
		//출력
		System.out.println("당신의 한국나이는 " + koreanAge + "세");
		System.out.print("당신의 만나이는 " + americanAge + "세");
		System.out.println(" (" + americanAge + "년 " + diff%12 + "개월)");
		
	}

}
