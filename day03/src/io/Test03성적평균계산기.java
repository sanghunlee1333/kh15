package io;

import java.util.Scanner;

public class Test03성적평균계산기 {

	public static void main(String[] args) {
		
		//입력
		Scanner sc = new Scanner(System.in);
		
		System.out.println("이름을 입력하세요");
		String name =  sc.next();
		System.out.println("국어점수를 입력하세요");
		int korean = sc.nextInt();
		System.out.println("영어점수를 입력하세요");
		int english = sc.nextInt();
		System.out.println("수학점수를 입력하세요");
		int math = sc.nextInt();
		
		//처리
		int total = korean + english + math;
		double average = total / 3.0;
				
		//출력
		System.out.println(name + "님의 총점 = " + total  + "점");
		System.out.println(name + "님의 평균 = " + average  + "점");
	}

}
