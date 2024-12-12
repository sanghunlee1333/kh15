package oop.constructor3;

public class Test01강의정보 {

	public static void main(String[] args) {
		Lecture l1 = new Lecture("자바 프로그래밍 기초", "IT", 60, 50000, "온라인");
		Lecture l2 = new Lecture("파이썬 프로그래밍 중급", "IT", 90, 100000);
		//Lecture l2 = new Lecture("파이썬 프로그래밍 중급", "IT", 90, 100000, "오프라인"); 
		//오프라인이 기준인지 온라인이 기준인지 사용자 입장에서는 파악이 어렵기 때문에 위같은 경우도 괜찮다.
		Lecture l3 = new Lecture("정보처리기사 실기", "시험", 120, 75000, "혼합");
		
		l1.show();
		l2.show();
		l3.show();
	}

}
