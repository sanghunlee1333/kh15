package oop.basic2;

public class Test01국가정보 {

	public static void main(String[] args) {
		
		// 인스턴스 생성
		Nation a = new Nation();
		Nation b = new Nation();
		Nation c = new Nation();
		Nation d = new Nation();
		
		// 초기화
		a.country = "한국";
		a.capital = "서울";
		a.population = 50000000;
		
		b.country = "일본";
		b.capital = "도쿄";
		b.population = 120000000;
		
		c.country = "중국";
		c.capital = "베이징";
		c.population = 1400000000;
		
		d.country = "미국";
		d.capital = "워싱턴";
		d.population = 250000000;
		
		// 출력
		System.out.println("이름 = " + a.country);
		System.out.println("수도 = " + a.capital);
		System.out.println("인구 = " + a.population);
	
		System.out.println("이름 = " + b.country);
		System.out.println("수도 = " + b.capital);
		System.out.println("인구 = " + b.population);

		System.out.println("이름 = " + c.country);
		System.out.println("수도 = " + c.capital);
		System.out.println("인구 = " + c.population);
		
		System.out.println("이름 = " + d.country);
		System.out.println("수도 = " + d.capital);
		System.out.println("인구 = " + d.population);
	}

}
