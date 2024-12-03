package data;

public class Test07주차요금계산기2 {

	public static void main(String[] args) {
				
		//입력
		int h1 = 12, m1 = 40;
		int h2 = 16, m2 = 15;
		int period = 30; //단위기간
		int price = 3000; //단위요금
		
		//처리
		int t1 = h1 * 60 + m1; //분으로 변환
		int t2 = h2 * 60 + m2; //분으로 변환
		int t3 = t2 - t1;
		
		int h3 = t3 / 60;
		int m3 = t3 % 60;
		
		int total = t3 / period * price;
		
		//출력
		System.out.println(h3 + "시간" + " " + m3 + "분");
		System.out.println(total);
			
	}

}
