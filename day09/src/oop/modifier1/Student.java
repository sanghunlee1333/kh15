package oop.modifier1;

public class Student {
	//필드 - 외부의 접근을 차단 (private : 클래스 외부의 접근을 차단)
	//필드에 왠만해서는 전부 private을 붙인다고 생각! 안 붙이는 경우는 굉장히 특수 케이스
	private String name;
	private int score;
	
	// Source 탭 -> Generate getters and setters -> 필드 선택 및 package 설정
	//setter 2개 + getter 2r개 + init + show
	//메소드 - 적극적으로 이용할 수 있도록 공개(public : 모든 접근 허용)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		if(score < 0 || score > 100) return;
 		this.score = score;
	}
	
	public void init(String name, int score) {
		this.setName(name);
		this.setScore(score);
	}
	
	public void show() {
		//System.out.println("이름  : " + this.name); //같은 클래스 안에서는 필드로 접근해도 됨!
		System.out.println("이름  : " + this.getName());
		System.out.println("점수 : " + this.getScore());
	}
	
}
