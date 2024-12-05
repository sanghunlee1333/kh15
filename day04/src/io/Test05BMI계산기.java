package io;

import java.util.Scanner;

public class Test05BMI계산기 {

	public static void main(String[] args) {
		
		/*
		// 입력
		Scanner sc = new Scanner(System.in);

		System.out.println("신장을 입력하세요");
		int height = sc.nextInt();
		float meterToCm = (float) height * 1 / 100;

		System.out.println("체중을 입력하세요");
		int weight = sc.nextInt();

		// 처리
		float bmi = weight / (meterToCm * meterToCm);
		
		
		if (bmi >= 24.5) {
			System.out.println("당신의 BMI는 " + bmi + "이며 과체중입니다.");
		} else if (bmi >= 18.5) {
			System.out.println("당신의 BMI는 " + bmi + "이며 정상입니다.");
		} else {
			System.out.println("당신의 BMI는 " + bmi + "이며 저체중입니다.");
		}
		
		
		*/
		
		//입력
		Scanner sc = new Scanner(System.in);
		System.out.println("신장(cm) 입력 : ");
		float cm = sc.nextFloat(); 
		System.out.println("체중(kg) 입력 : ");
		float kg = sc.nextFloat(); //float kg = 80; 이라고 해도 float가 int가 더 큰 타입이니 상관없지만, 소수점 표시가 안된다.
		
		//처리
		float m = cm / 100;
		float bmi = kg / (m * m);
		boolean heavy = bmi >= 24.5f; // bmi는 float형이고, 24.5는 double형이므로 서로 계산하면 오차가 커짐. 그래서 f를 붙여서 기준을 맞춰준다.
		//24.5 는 변하지 않는 숫자이므로 변수화하지 않는다.
		
		//출력
		System.out.println("당신의 BMI 수치는 " + bmi);
		System.out.println("과체중인가요? " + heavy);
	}

}
