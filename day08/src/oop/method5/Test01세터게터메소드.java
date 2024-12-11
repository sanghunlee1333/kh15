package oop.method5;

public class Test01세터게터메소드 { // 클래스는 생성이 되는 것이지, 실행이 되는 것이 아니다. -> 코드를 작성할 수 없음. 코드는 오직 메소드에서만 작성 및 실행 가능!

	public static void main(String[] args) {
		Student s = new Student();

		s.init("피카츄", 60, 70, 80);
		// (Q)국어점수만 변경?
		// s.init("피카츄", 60, 70, 80); // init을 쓰면 다 바꿔야하고.. 다 다시 써야하니 불편함.
		// s.korean = -70; // 필드에 직접 접근하면 필터링이 안됨. 필드에 직접적으로 접근하는 것은 죄악.. 편하지만, 안전하지가 않음
		// 그래서 최대한 메소드로 접근하자
		s.setKorean(70); // 변경됨
		// s.setKorean(-70); // 차단 당함

		s.show();
	}

}
