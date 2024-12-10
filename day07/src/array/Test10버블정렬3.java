package array;

public class Test10버블정렬3 {

	public static void main(String[] args) {
		// 입력
		int[] numbers = new int[] { 30, 50, 20, 10, 40 };

		// 처리
		for (int k = numbers.length-2; k >= 0; k--) {
			for (int i = 0; i <= k; i++) {
				//System.out.println("[" + i + "] vs [} + (i + 1) + "]");
				if (numbers[i] > numbers[i + 1]) {
					int backup = numbers[i];
					numbers[i] = numbers[i + 1];
					numbers[i + 1] = backup;
				}
			}
		}

		// 출력
		for (int i = 0; i < numbers.length; i++) {
			System.out.println(numbers[i]);
		}

	}

}
