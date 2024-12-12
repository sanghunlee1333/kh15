package oop.keyword3;

public class Test01일회용메소드 {

	public static void main(String[] args) {
		
		int result1 = Robot.multiple(2, 3);
		System.out.println("두 수의 곱 = " + result1);
		
		int result2 = Robot.square(11);
		System.out.println("제곱 = " + result2);
		
		double result3 = Robot.triangle(5, 7);
		System.out.println("삼각형의 넓이 = " + result3);
		
		float result4 = Robot.circle(5);
		System.out.println("원의 넓이 = " + result4);
		
		double result5 = Robot.bmi(180, 80);
		System.out.println("체질량 지수 = " + result5);
		
		int result6 = Robot.subway(1995);
		System.out.println("지하철 요금 = " + result6 + "원");
		
	}

}
