package condition;

import java.time.LocalDate;
import java.util.Scanner;

public class Test05지하철요금계산기 {

	public static void main(String[] args) {
		
		//입력
		Scanner sc = new Scanner(System.in);
		System.out.print("출생년도 : ");
		int birth = sc.nextInt(); 
		
		int card = 500;
		int free = 0, child = 500, teen = 800, adult = 1400;
		
		//처리
		int year = LocalDate.now().getYear();
		int age = year - birth + 1;
		
		/*
		if (20 <= age && age <= 64) {
			System.out.println("요금은 " + (1400 + card) + "원입니다(카드보증금 500원 포함)");
		}
		else if (14 <= age && age <= 19) {
			System.out.println("요금은 " + (800 + card) + "원입니다(카드보증금 500원 포함)");
		}
		else if (8 <= age && age <= 13) {
			System.out.println("요금은 " + (500 + card) + "원입니다(카드보증금 500원 포함)");
		}
		else {
			System.out.println("요금은 " + card + "원입니다(카드보증금 500원 포함)");
		}
		*/
		
		//출력
		int price; //자리만 잡고
		if(age < 8 || age >= 65) {//영유아 or 어르신
			price = free;
		}
		else if (age <= 13) {//어린이
			price = child;
		}
		else if (age <= 19) {//청소년
			price = teen;
		}
		else {//성인
			price = adult;
		}
		
		//price = price + card; //카드보증금 추가
		price += card; //줄여서 표현
		
		//출력
		System.out.println("요금 : " + price + "원(카드보증금 " + card + "원 포함)");
	}

}
