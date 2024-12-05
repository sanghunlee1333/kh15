package condition;

import java.util.Scanner;

public class Test06여행사프로모션 {

	public static void main(String[] args) {
		
		/*
		//입력
		Scanner sc = new Scanner(System.in);
		
		System.out.print("여행 인원수는 : ");
		int person = sc.nextInt();
		
		System.out.print("여행 일수는 : ");
		int day = sc.nextInt();
		
		System.out.print("여행갈 달은 : ");
		int month = sc.nextInt();
		
		//처리
		int discountPercent;
				
		if (month == 3 || month == 4 || month == 5) {
			discountPercent = 25;
		}
		else if (month == 6 || month == 7 || month == 8) {
			discountPercent = 5;
		}
		else if (month == 9 || month == 10 || month == 11) {
			discountPercent = 10;
		}
		else {
			discountPercent = 30;
		}
		
		int fee = person * day * 100000; //총 경비
		double payPercent = (100 - discountPercent) / 100; //할인율 계산
		fee = fee * payPercent; //최종 금액 계산
		
		//출력
		System.out.println("예상경비 : " + (int)fee);
		
		*/
		
		//입력
		Scanner sc = new Scanner(System.in);
		System.out.print("인원 수 : ");
		int people = sc.nextInt();
		System.out.print("여행갈 기간(일) : ");
		int days = sc.nextInt();
		System.out.print("몇 월에 가시나요 : ");
		int month = sc.nextInt();
		
		//처리
		int price = people * days * 100000;
		int spring = 25, summer = 5, autumn = 10, winter = 30;
		
		//int rate = 30 or 25 or 10 or 5;
		int rate; //위 주석처럼 뭔지 모르니 선언만!
		if(month == 3 || month == 4 || month == 5) {//봄
			rate = spring; //이렇게 해두면 할인율이 변경될때 if문에서가 아닌 입력 단에서만 수정하면 된다!
		}
		else if(month == 6 || month == 7 || month == 8) {//여름
			rate = summer;
		}
		else if(month == 9 || month == 10 || month == 11) {//가을
			rate = autumn;
		}
		else {//겨울
			rate = winter;
		}
		
		int discount = price * rate / 100;
		int result = price - discount;
		
		//출력
		System.out.println("예상경비 : " + price + "원");
		System.out.println("할인율 : " + rate + "%");
		System.out.println("할인 금액 : " + discount + "원");
		System.out.println("최종 경비 : " + result + "원");
	}

}
