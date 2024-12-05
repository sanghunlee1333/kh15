package condition;

import java.util.Scanner;

public class Test08과속단속카메라 {

	public static void main(String[] args) {
		
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

	}

}
