package data2;

// 강의실이 패키지. 영향을 받지 않도록 분리하는 역할

public class Test04PC방계산기 {

	public static void main(String[] args) {
		/*
		int price = 1000;
		int hour1 = 12, minute1 = 20;
		int hour2 = 15, minute2 = 30;
		
		int time1 = hour1 * 60;
		int time2 = hour2 * 60;
		
		int totalTime1 = time1 + minute1;
		int totalTime2 = time2 + minute2;
		
		int total = totalTime2 - totalTime1;
		
		int minutePrice = price / 60;
		int totalPrice = total * minutePrice;
		float trans = totalPrice / 100 * 100;
		int totalTransInt = (int)trans;
		
		System.out.println(totalTransInt);
		*/
		
		//입력
		int h1 = 12, m1 = 20;
		int h2 = 15, m2 = 30;
		int price = 1000;
		
		//처리
		//1. 이용시간(분)을 계산
		//2. 1분당 요금을 계산
		//3. 결제금액을 계산
		
		int t1 = h1 * 60 + m1;
		int t2 = h2 * 60 + m2;
		int t3 = t2 - t1; //1
		
		//int ppm = price / 60; //2(오류)
		double ppm = price / 60.0; //2(정상) 
		// (중요) float와 double을 혼용해서 쓰면 안된다.
		// (참고) 나누기를 이용하면 숫자 자르기 가능.1220 -> 1220/100 & 1220%100
		
		//int result = (int)(ppm * t3); //3
		int result = (int)(ppm * t3) / 100 * 100; //3(100원 미만 안받음)
				
		//출력
		System.out.println(result);
		
	}

}
