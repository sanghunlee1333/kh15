package array;

public class Test08배열뒤집기 {

	public static void main(String[] args) {

		// 입력
		int[] numbers = new int[] { 30, 50, 20, 10, 40 };

		// 처리
		// - 오늘만 사는 코드
//		int backup1 = numbers[4];
//		numbers[4] = numbers[0];
//		numbers[0] = backup1;
//		
//		backup1 = numbers[3];
//		numbers[3] = numbers[1];
//		numbers[1] = backup1;

		// - 확장성 있는 코드
		// - length/2회 만큼 데이터 교체를 하면 배열이 뒤집힌다
		for (int i = 0; i < numbers.length / 2; i++) {
			//System.out.println("[" + i + "] vs [" + (numbers.length-1-i) + "]");
			//numers[i]와 numbers[numbers.length-1-i]를 바꿔야 한다
			int backup = numbers[i];
			numbers[i] = numbers[numbers.length-1-i]; //식이 복잡하다
			numbers[numbers.length-1-i] = backup;
		}

		// 출력
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + " ");
		}

	}

}
