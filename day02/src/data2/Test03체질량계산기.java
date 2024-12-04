package data2;

public class Test03체질량계산기 {

	public static void main(String[] args) {
		/*
		int weight = 80;
		int height = 180;
		double heightSquare = height * height * 0.0001;

		double bmi = weight / heightSquare;

		System.out.println(bmi);
		*/
		
		//입력
		int cm = 180;
		int kg = 80;
		//float cm = 180;
		//float kg = 80;
				
		//처리
		float m = cm / 100f; //100;
		float bmi = kg / (m * m);
		//float bmi = kg / m / m;
		
		//float와 double을 혼용해서 쓰면 안된다. 소수점끼리 계산이 복잡해짐. 한 가지만 쓰자.
		
		//출력
		System.out.println(bmi);
	}

}
