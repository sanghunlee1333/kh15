package condition;

import java.util.Scanner;

public class Test08과속단속카메라 {

	public static void main(String[] args) {
		
		/*
		System.out.print("자동차의 속력을 입력하세요 : ");
		Scanner sc = new Scanner(System.in);

		int speed = sc.nextInt();
		int limit = 110;
		
		int addition = 10000;
		int penalty = (speed - limit) / 10 * addition;
		int price = 40000 + penalty;
				
		System.out.println("자동차의 속력 : " + speed + "km");
		if (speed < 110) {
			System.out.println("범칙금이 없습니다");
		}
		else if (price >= 100000) {
			price = 100000;
			System.out.println("범칙금은 " + price + "원입니다.");
		}
		else {
			System.out.println("범칙금은 " + price + "원입니다.");
		}
		*/
		
		//입력
		Scanner sc = new Scanner(System.in);
		System.out.print("자동차 속도 : ");
		int speed = sc.nextInt();
		
		//처리
		int limit = 100; //제한속도
		//int over = 110;
		int percent = 10; //여유%
		int over = limit + limit * percent / 100;
		
		int base = 40000, plus = 10000, maximum = 100000;
		
		if(speed >= over) {
			//System.out.println("과속");
			int gap = speed - over;
			//int fine = 4만원 + 10km당 1만원;
			int fine = base + gap / 10 * plus;
			System.out.println("초과한 속도 : " + gap + "km");
			if (fine < maximum) {
			System.out.println("범칙금 : " + fine);
			}
			else {
				System.out.println("범칙금 : " + maximum);
			}
		}
		else {
			System.out.println("정상 통과");
		}

	}

}
