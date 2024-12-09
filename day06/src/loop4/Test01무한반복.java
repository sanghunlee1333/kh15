package loop4;

import java.util.Random;

public class Test01무한반복 {

	public static void main(String[] args) {

		// while 반복문
		// - for 처럼 같은 코드를 여러번 실행할 수 있는 구문
		// - while(조건) {코드}
		// - 횟수나 구간이 주어진 경우는 for가 더 사용이 편하다

		// 1부터 10까지 while로 출력
		
		/*
		int n = 1;
		while (n <= 10) {
			System.out.println("n = " + n);
			n++;
		}
		*/
		// 위처럼 할 것이면 while문 보다는 for문을 쓰는 게 낫다
		
		//while(true)를 사요아면 무한대로 실행하는 반복문이 만들어짐
		// - 하지만 프로그램은 언젠가 끝나야 하므로 해당 시점을 찾아 break
		
		//(ex) 주사위를 6이 나올때까지 던지는 프로그램 -> for문과 달리 언제 끝날지 범위를 모를 때 사용
		Random r = new Random();
		while(true) {
			int dice = r.nextInt(6) + 1;
			System.out.println("dice = " + dice);
			
			//탈출 조건 - while문에 꼭 들어가야 한다. 안그럼 악성코드처럼 무한 반복됨
			if (dice==6) {
				break;
			}
		}
	}

}
