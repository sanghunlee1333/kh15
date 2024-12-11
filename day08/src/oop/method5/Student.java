package oop.method5;

public class Student {
	String name;
	int korean, english, math;
	
	//setter 메소드
	// - 필드 한 개를 변경할 수 있는 메소드 (+조건으로 필터링 가능)
	// - 이름은 set + 필드명으로 작성
	// - 이상한 데이터를 차단하는데 목적
	
	//getter 메소드 
	// - 필드 한 개를 반환할 수 있는 메소드 (+가상의 메소드 생성 가능)
	// - 이름은 get + 필드명으로 작성
	// - 계산하는 데 목적
	
	//필드 하나당 setter메소드와 getter메소드가 한 개씩 있어야 한다!
	
	void setName(String name) {
		this.name = name;
	}
	
//	void setKorean(int korean) {
//		if(korean >= 0 && korean <100) { //코드가 오른쪽으로 증가될 가능성. 해당하는 것들만 변경하겠다
//			this.korean = korean;
//		}
//	}
	
	// 위와 동일한 표현! 아래 표현이 더 좋다. 차단하는 조건이 늘어나는 가능성이 크므로, if문으로 아래로 코드를 증가시킬 수 있음	
	void setKorean(int korean) {
		if(korean < 0 || korean > 100) {
			return; //메소드 중지 명령 *break은 구문을 나가라는 명령 *return은 중지와 반환의 의미를 가지고 있음
		}
		this.korean = korean;
	}
	
	void setEnglish(int english) {
		if (english < 0 || english > 100) return;
		this.english = english;
	}
	
	void setMath(int math) {
		if (math < 0 || math > 100) return;
		this.math = math;
	}
	
	//반환할 데이터가 있는 경우에는 반환 자료형을 void가 아니라 다른 형태로 변경
	//void는 반환할 데이터가 없다는 의미의 표시이다
	String getName() { //반환(return)을 도와주는 메소드
		return this.name; //주인공의 필드 name을 외부에서 가져가도록 반환
	}					// if문 같은 조건을 걸지않는다. setter메소드에서 들어올 때 이미 검사를 했기 때문에, 나갈 때는 하지 않는다.
	
	int getKorean() {
		return this.korean;
	}
	int getEnglish() {
		return this.english;
	}
	int getMath() {
		return this.math;
	}
	int getTotal() {
		return this.getKorean() + this.getEnglish() + this.getMath();
	}
	float getAverage() {
		return this.getTotal() / 3f;
	}
	
	void init(String name, int korean, int english, int math) {
		this.setName(name); //this.name = korean; //이런 식으로 만들면 setName을 만든 의미가 없음.
		this.setKorean(korean);
		this.setEnglish(english);
		this.setMath(math);
	}
	
	void show() { //반환이랑 출력은 다르다.
		System.out.println("이름 : " + this.getName());
		System.out.println("국어 : " + this.getKorean());
		System.out.println("영어 : " + this.getEnglish());
		System.out.println("수학 : " + this.getMath());
		System.out.println("수학 : " + this.getTotal()); //계산을 아래처럼 복잡하게 적지 않고 getter메소드 한방에 할 수 있다!
		System.out.println("수학 : " + this.getAverage());
	}
	
//	void show() {
//		System.out.println("이름 : " + this.name());
//		System.out.println("국어 : " + this.korean());
//		System.out.println("영어 : " + this.english());
//		System.out.println("수학 : " + this.math());
//		System.out.println("수학 : " + this.korean + this.english + this.math);
//		System.out.println("수학 : " + this.korean + this.english + this.math / 3f);
//	}
}
