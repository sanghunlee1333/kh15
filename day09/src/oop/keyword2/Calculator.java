package oop.keyword2;

public class Calculator {
	private int left;
	private int right;
	
// 1. 객체 지향 방식
	// 더하기 하나만 하더라도 많은 과정을 거쳐야 함
//	public int getLeft() {
//		return left;
//	}
//	public void setLeft(int left) {
//		this.left = left;
//	}
//	public int getRight() {
//		return right;
//	}
//	public void setRight(int right) {
//		this.right = right;
//	}
//	
//	public int getPlus() { //가상의 getter메소드
//		return this.left + this.right;
//	}
//	
//	//생성자도 자동 생성 가능 Source 탭 - Generate Constructor using fields
//	public Calculator(int left, int right) {
//		this.setLeft(left);
//		this.setRight(right);
//	}
	
//	2. static 메소드만 활용하는 방식
	// 더하기만 하는데 객체 지향까지는 필요 없다. 인스턴스 필요 없다
	// static은 반 객체지향 키워드
	// - 인스턴스까지 만들어서 관리할 필요가 없는 일회용 변수, 메소드에 작성
	// - 클래스 이름과 대상의 이름으로 접근이 가능(아무데서나 가능)
	// - 메모리를 계속 점유하고 있으므로 많을수록 부하가 심해짐
	public static int plus(int left, int right) {
		return left + right;
	}
	public static int minus(int left, int right) {
		return left - right;
	}
	
	
	
	
}
