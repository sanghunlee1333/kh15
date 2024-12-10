package array;

public class Test09선택정렬2 {

	public static void main(String[] args) {

		// 배열 준비
		int[] numbers = new int[] { 30, 50, 20, 10, 40 };

		// 처리

		for (int k = 0; k < numbers.length - 1; k++) {
			// - 선택정렬(1회차) : k부터 마지막 지점 사이의 최소값(min)을 k지점과 교체
			int min = k; // 0,1,2,3
			for (int i = k + 1; i < numbers.length; i++) {
				if (numbers[min] > numbers[i]) {
					min = i;
				}
			}
			int backup = numbers[k];
			numbers[k] = numbers[min];
			numbers[min] = backup;
		}

		// 출력
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + " ");
		}

	}

}
