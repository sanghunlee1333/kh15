package oop.method1;

//학생 클래스
public class Student {
	//멤버 필드
	String name;
	int korean, english, math;
	
	//어차피 인스턴스가 생기면 "초기화"와 "출력" 기능이 필요하다
	//당연한 기능이라면 미리 준비해줄 수는 없을까/
	//-> 멤버 메소드
	
	//void 이름(준비물) {
	//	코드
	//}
	
	//초기화 메소드
	//이 메소드는 데이터 4개를 줘야 실행된다
	//외부에서 데이터를 가져와서 저장
	void init(String name, int korean, int english, int math ) {//매개 변수 *외부에서 가져오는 것은 인자 라고 함
		this.name = name;
		this.korean = korean;
		this.english = english;
		this.math = math;
	}
	
	void show () {
		//this == 주인공
		System.out.println("이름 = " + this.name); //저장된 값을 출력하는 기능으로, 매개변수(준비물)이 필요없다.
		System.out.println("국어 = " + this.korean);
		System.out.println("영어 = " + this.english);
		System.out.println("수학 = " + this.math);
		int total = this.korean + this.english + this.math;
		System.out.println("총점 = " + total);
	}
}
