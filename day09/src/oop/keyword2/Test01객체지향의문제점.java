package oop.keyword2;

public class Test01객체지향의문제점 {

	public static void main(String[] args) {
		// 1. (ex) 10 + 20을 객체지향으로 풀이
//		Calculator c = new Calculator(10, 20);
//		int result = c.getPlus();
//		System.out.println("result = " + result);
		
		// 2. static을 활용한 메소드로 풀이
		int result = Calculator.plus(10, 20); //static 메소드는 이태리체로 변하고, 마우스를 올리면 's'자가 나옴.
		System.out.println("result = " + result);
		
		

	}

}
