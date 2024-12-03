package data2;

public class Test01실수특징 {

	public static void main(String[] args) {
		//실수
		//- 소수점이 있는 숫자
		//- float / double 이라는 형태가 존재 (소수점 표현 크기)
		//- 부정확하다
		//- (중요)실수가 포함된 계산의 결과는 실수이다 ex) 1 + 1.5 = 2.5
		
		double a = 1.5;
		System.out.println(a);
		
		float b = 1.5f;
		System.out.println(b);
		
		float c = 100;
		System.out.println(c);
		
		System.out.println(10 / 3);
		System.out.println(10 / 3.0); //끝에 5가 나오는 거는 부정확하니까. 끝자리는 내 생각과 달라도 신경X
		System.out.println(10 / 3f); //자리수가 짧은 것
		
	}

}
