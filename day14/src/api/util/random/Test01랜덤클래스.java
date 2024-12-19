package api.util.random;

import java.util.Random;

public class Test01랜덤클래스 {

	public static void main(String[] args) {
		
		//Random 클래스
		//- 예측이 불가능해보이는 데이터를 만드는 가짜 랜덤 생성기
		//- 시드(seed)를 기반으로 어떤 연산을 거쳐 숫자를 생성
		//- 생성한 숫자는 다음 랜덤의 시드가 됨
		//- 시드를 제어할 수 있다면 랜덤을 통제할 수 있음
				
		Random r = new Random();
		r.setSeed(1L);
		System.out.println(r.nextInt());
		r.setSeed(1L);
		System.out.println(r.nextInt());
	}

}
