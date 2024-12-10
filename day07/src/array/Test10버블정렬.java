package array;

public class Test10버블정렬 {

	public static void main(String[] args) {
		// 입력
		int[] numbers = new int[] { 30, 50, 20, 10, 40 };

		// 처리
		// 버블정렬 1회차
		// - [0] vs [1] , [1] vs [2], [2] vs [3] , [3] vs [4]
		// - 큰데이터가 뒤에 있도록 교체하며 진행 -> 30 20 10 40 50
		for (int i = 0; i <= 3; i++) {
			if (numbers[i] > numbers[i + 1]) {
				int backup = numbers[i];
				numbers[i] = numbers[i + 1];
				numbers[i + 1] = backup;
			}
		}
		
		// 버블정렬 2회차
		// - [0] vs [1] , [1] vs [2], [2] vs [3]
		// 20 10 30 40 50
		for (int i = 0; i <= 2; i++) {
			if (numbers[i] > numbers[i + 1]) {
				int backup = numbers[i];
				numbers[i] = numbers[i + 1];
				numbers[i + 1] = backup;
			}
		}
		
		// 버블정렬 3회차
		// - [0] vs [1] , [1] vs [2]
		// 10 20 30 40 50
		for (int i = 0; i <= 1; i++) {
			if (numbers[i] > numbers[i + 1]) {
				int backup = numbers[i];
				numbers[i] = numbers[i + 1];
				numbers[i + 1] = backup;
			}
		}
				
		// 버블정렬 4회차
		// - [0] vs [1]
		// 10 20 30 40 50
		for (int i = 0; i <= 0; i++) {
			if (numbers[i] > numbers[i + 1]) {
				int backup = numbers[i];
				numbers[i] = numbers[i + 1];
				numbers[i + 1] = backup;
			}
		}

		// 출력
		for (int i = 0; i < numbers.length; i++) {
			System.out.println(numbers[i]);
		}

	}

}
