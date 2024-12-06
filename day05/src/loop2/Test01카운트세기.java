package loop2;

public class Test01카운트세기 {

	public static void main(String[] args) {

		// ex : 1부터 100 사이의 짝수 개수 구하기

		int count = 0; //카운트를 세기 위한 변수를 0으로 준비

		for (int i = 1; i <= 100; i++) {
			if (i % 2 == 0) {
				count++; //카운트 증가
			}
		}
		System.out.println(count); //카운트 출력
	}

}
