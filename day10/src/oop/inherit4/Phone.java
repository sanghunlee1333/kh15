package oop.inherit4;

//상속 시 주의사항
//- 필드 : 접근제한 설정 (private vs protected -> 모르겠으면 private쓰고 세터 게터 사용)
//- 생성자 : 생성자를 만들면 상속받는 하위 클래스가 무조건 따라서 만들어야 함
//- 메소드 : 원한다면 재정의(override)가 가능하다

//private
//x -> package
//protected
//public

public /* final */ class Phone { // final을 붙이면 상속 불가

	// 상속과 무관하게 모두 제한(반드시 지켜야되는 설정방식)
	// ex)한국 휴대폰 번호만 저장해야한다.
	// 세터, 게터로 ...(?)
	// private String number;

	// 상속받은 클래스가 자유롭게 접근 가능(설정방식을 하위클래스가 결정할 수 있음)
	// 전 국가의 휴대폰 번호 저장
	protected String number;

	// 세터, 게터메소드 생략

	// 생성자
	public Phone(String number) {
		this.number = number;
	}

	// 메소드
	public /* final */ void call() { // final을 붙이면 오버라이딩 불가.
		System.out.println("전화 기능 실행");
	}

}
