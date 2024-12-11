package oop.method2;

public class Medallist {

	// 멤버 필드 - 데이터
	String name; // 이름
	String game; // 종목
	String division; // 구분(동계/하계)
	int gold, silver, bronze; // 금은동메달 수

	// 멤버 메소드 - 코드
	void init(String name, String game, String division, int gold, int silver, int bronze) {

		this.name = name;
		this.game = game;
		this.division = division;
		this.gold = gold;
		this.silver = silver;
		this.bronze = bronze;

	}

	void show() {
		System.out.println("<선수 정보>");
		System.out.println("이름 : " + this.name);
		System.out.println("종목 : " + this.game);
		System.out.println("구분 : " + this.division);
		System.out.println("금 : " + this.gold + ", " + "은 : " + this.silver + ", " + "동 : " + this.bronze);
		// 추가 계산이 필요한 것들은 일회용 변수(지역변수)를 사용
		int total = this.gold * 100 + this.silver * 10 + this.bronze;
		System.out.println("랭킹 포인트 : " + total); // this.total은 불가. this는 필드만 가능!

	}
}
