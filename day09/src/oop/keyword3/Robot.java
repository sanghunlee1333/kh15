package oop.keyword3;

import java.time.LocalDate;

public class Robot {
	
	// 일회용 메소드만 보관할 것이라면 생성을 못하게 생성자를 잠금 처리. 특이한 경우
	private Robot() {}
	
	// [1] multiple이라는 이름으로 두 수의 곱을 구하는 메소드를 구현
	// 파라미터 개수가 같아도 형태가 다른 경우이므로 오버로딩 가능!! 
	public static int multiple (int left, int right) {
		return left * right;
	}
	// 소수끼리 곱할지 모르는 상황이므로 double로 만듬. ex) 1.2 * 3 = 3.59999999....6
	// 다만 double끼리 곱은 정확하지 않음. 
	public static double multiple (double left, double right) {
		return left * right;
	}
	
	// [2] square라는 이름으로 어떤 수의 제곱을 구하는 메소드를 구현
    // (ex) Robot.square(11) -> 121
	public static int square (int num) {
		//return num * num;
		//return Robot.multiple(n,n); static메소드끼리 서로 호출할 수 있다!
		return multiple(num ,num); // this는 인스턴스가 있어야만 사용할 수 있다. 같은 클래스 안의 메소드 이므로, 클래스명 생략 가능
	}
	public static double square (double num) {
		//return num * num;
		//return Robot.multiple(n,n); 
		return multiple(num,num);
	}
	
	// [3] triangle이라는 이름으로 밑변과 높이를 이용해 삼각형의 넓이를 구해주는 메소드를 구현
    // (ex) Robot.triangle(5, 7) -> 17.5
	public static double triangle (int bottom, int height) {
		return bottom * height / 2d; //double도 리터럴이 있다..!
	}
	
	// [4] circle이라는 이름으로 반지름이 주어졌을 때 원의 넓이를 구해주는 메소드를 구현
	public static float circle (int radius) {
		// return radius * radius * 3.14f;
		return 3.14f * square(radius);
		// return multiple(3.14, square(radius));
	}
	
	// [5] bmi라는 이름으로 신장(cm)과 키(kg)가 주어졌을 때 체질량지수를 구해주는 메소드를 구현(기존문제 참고)
	public static double bmi (int cm, int kg) { //double bmi (float cm... -> double과 float 혼용은 안됨. 오차가 커짐
		double m = cm / 100;
		return kg / square(m);
	}
	
	// [6] subway라는 이름으로 출생년도 4자리가 주어졌을 때 지하철요금을 구해주는 메소드를 구현(기존문제 참고)
	public static int subway (int birth) {
		
		int age = LocalDate.now().getYear() - birth + 1; //LocalDate라는 클래스의 now라는 static 메소드!
				
		if (age < 8 || age >= 65) return 0;
		else if (age <= 13) 	  return 500;
		else if (age <= 19) 	  return 800;
		else 					  return 1400;
				
	}
	
	// 메소드는 여러 기능을 이것 저것 넣을 필요 없이 하나의 기능만 구현하면 됨. 
	// 범용성이 좋음(언제 어디서든 인스턴스 생성 없이 가져다 쓸 수 있음) -> 신촌에서만 파는 쌀떡볶이 vs 냉동으로 전국에서 밀키트로 팔리는 쌀떡볶이
	// this와 static은 인스턴스가 필요하냐 안 필요하냐의 차이로 반대되는 키워드
}
