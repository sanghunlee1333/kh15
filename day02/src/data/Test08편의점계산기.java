package data;

//import java.util.Scanner;

public class Test08편의점계산기 {

	public static void main(String[] args) {
		
		/*
		int kimbap = 1400;
				
		int num = 0;
		int freeCount = 0;
		int payCount = 0;
		int price = 0;
			
		Scanner sc = new Scanner(System.in);
		System.out.println("구매하고자 하는 삼각김밥 수를 입력하세요.");
		num = sc.nextInt();
		
		freeCount = num / 2;
		payCount = num - freeCount;
		
		price = kimbap * payCount;
		
		System.out.println("삼각김밥의 구매 가격은" + " " + price + "원입니다.");
		*/
		
		//입력
		int count = 5; 
		int price = 1400;
		
		//처리
		int free = count / 2; //무료 처리되는 개수
		int pay = count - free; //유료 처리되는 개수
		//System.out.println(pay);
		
		int total = pay * price; //금액
		
		//출력
		System.out.println(total);
		
		}

}
