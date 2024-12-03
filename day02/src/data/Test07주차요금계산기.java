package data;

public class Test07주차요금계산기 {

	public static void main(String[] args) {
		
		/*
		int h1 = 12, m1 = 40;
		int h2 = 16, m2 = 15;
		
		int t1 = h1 * 60 + m1;
		int t2 = h2 * 60 + m2;
		
		int t3 = t2 - t1;
				
		int h3 = t3 / 60;
		int m3 = t3 % 60;
			
		int parkingFee = (t3 / 60) * 3000;
			
		System.out.println(h3 + "시간" + " " + m3 + "분");
		System.out.println(parkingFee + "원");
		
		*/
		
		//입력
		int h1 = 12, m1 = 40;
		int h2 = 16, m2 = 15;
		int price = 3000;
		
		//처리
		int t1 = h1 * 60 + m1; //분으로 변환
		int t2 = h2 * 60 + m2; //분으로 변환
		int t3 = t2 - t1;
		
		int h3 = t3 / 60;
		int m3 = t3 % 60;
		
		int total = h3 * price; //오늘만 사는 코드(확장성이 떨어지는 코드)
		
		//출력
		System.out.println(h3 + "시간" + " " + m3 + "분");
		System.out.println(total + "원");
		
		
		
	}

}
