package loop;

public class Test03반복수의활용 {

	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			System.out.println(i);
		}
		System.out.println();// 빈줄 추가

		for (int i = 1; i <= 9; i += 2) {// 반복문 5번 실행 -> 실행이 더 빠르므로 빅데이터(최소 1억번)에 활용하는 방식
			System.out.println("홀수 = " + i);
		}
		System.out.println();

		// 화면에 1부터 10까지 홀수 출력
		for (int i = 1; i <= 10; i++) {// 반복문 10번 실행
			// 실행이 더 느리지만, 성능 차가 별로 안나고 프로그래밍에서 더 많은 시도를 해볼 수 있는 방식으로 해당 방식 사용.
			if (i % 2 != 0) {// i가 홀수라면
				System.out.println("홀수 = " + i);
			}
		}
		System.out.println();// 빈줄 추가

		for (int i = 1; i <= 10; i++) {// 반복분 10번 실행
			if (i % 2 == 0) {// i가 짝수라면
				System.out.println("짝수 = " + i);
			}

		}

	}

}
