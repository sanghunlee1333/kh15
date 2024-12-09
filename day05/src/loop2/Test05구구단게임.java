package loop2;

import java.util.Random;
import java.util.Scanner;

public class Test05구구단게임 {

	public static void main(String[] args) {

		/*
		1. 데이터와 변수
		숫자 o - 정수, 실수, (문자)
		숫자 x - 논리, 문자열, (클래스)
		2. 입출력
		System.out, System.in
		Scanner
		3. 조건
		if
		switch-case
		break
		4. 반복
		for
		while
		do-while
		5. 배열
		---- 프로그래밍 공용 기초파트 끝 ----
		---- 객체 지향 프로그래밍 파트 시작 ----
		---- 라이브러리 프로그래밍 파트 ----
		*/
		
		/*
		
		Random r = new Random();
		Scanner sc = new Scanner(System.in);

		int correct = 0;
		int wrong = 0;
		int sumScore = 0;
		int basicScore = 10, hardScore = 20;
		int combo = 0;
		int total = 0;

		for (int i = 0; i < 10; i++) {
			int left = r.nextInt(8) + 2;
			int right = r.nextInt(9) + 1;
			System.out.print(left + " x " + right + " = ");
			int answer = sc.nextInt();

			if (answer == left * right) {
				correct++;
				combo++;
				if (left >= 6) {
					sumScore = combo * hardScore;
				} else {
					sumScore = combo * basicScore;
				}
				total += sumScore;
			} else {
				wrong++;
				combo = 0;
				sumScore = 0;
			}
		}
		System.out.println("정답 " + correct + "개");
		System.out.println("오답 " + wrong + "개");
		System.out.println("총 점수는 " + total + "점");

		*/
		
		// 10턴의 구구단 게임을 구현
		// -> 1턴의 구구단게임을 구현
		// -> 1턴의 구구단 문제 생성
		// -> 1턴의 구구단 문제에 대한 정답 입력
		
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		
		int correctCount = 0, incorrectCount = 0;
		
		int score = 0;
		int combo = 0;
		
		for (int i = 0; i < 10; i++) {

			int left = r.nextInt(8) + 2;// 단
			int right = r.nextInt(9) + 1;// 수
			System.out.print(left + " x " + right + " = ");

			int user = sc.nextInt();

			boolean correct = left * right == user;
			if (correct) {
				//System.out.println("정답");
				correctCount++;
				combo++;//콤보 증가
				score += 10 * combo; //점수 부여(콤보 반영)
			} else {
				//System.out.println("오답");
				incorrectCount++;
				combo = 0;//콤보초기화
			}
		}
		
		System.out.println("<게임 종료>");
		System.out.println("점수 = " + score);
		System.out.println("정답 개수 = " + correctCount);
		System.out.println("오답 개수 = " + incorrectCount);
		
	}

}
