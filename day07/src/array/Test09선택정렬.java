package array;

public class Test09선택정렬 {

	public static void main(String[] args) {

		// 배열 준비
		int[] numbers = new int[] { 30, 50, 20, 10, 40 };

		// 처리
		//- 선택정렬(1회차) : 0부터 4지점 사이의 최소값(min)을 0지점과 교체
		int min = 0;
		for (int i = 1; i < numbers.length; i++) {
			if(numbers[min] > numbers[i]) {
				min = i;
			}
		}
		int backup = numbers[0];
		numbers[0] = numbers[min];
		numbers[min] = backup;
		
//		//- 선택정렬(2회차) : 1부터 4지점 사이의 최소값(min)을 1지점과 교체
//		min = 1;
//		for (int i = 2; i < numbers.length; i++) {
//			if(numbers[min] > numbers[i]) {
//				min = i;
//			}
//		}
//		backup = numbers[1];
//		numbers[1] = numbers[min];
//		numbers[min] = backup;
		
		// 출력
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + " ");
		}

	}

}
