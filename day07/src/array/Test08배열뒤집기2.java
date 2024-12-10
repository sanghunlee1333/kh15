package array;

public class Test08배열뒤집기2 {

	public static void main(String[] args) {

		// 입력
		int[] numbers = new int[] { 30, 50, 20, 10, 40 };

		// 처리
		// - 확장성 있는 코드
		// - length/2회 만큼 데이터 교체를 하면 배열이 뒤집힌다
		
		/*
		// 변수를 이용해서 처리
		int left = 0, right = numbers.length-1; 
		for (int i = 0; i < numbers.length / 2; i++) {
			//System.out.println("[" + left + "] vs [" + right + "]");
			//numbers[left]와 numbers[right]를 바꿔야 한다
			int backup = numbers[i];
			numbers[left] = numbers[right]; 
			numbers[right] = backup;
			
			left++;
			right--;
		}
		*/
		int backup = 0;
		int min = 0;
		for (int i = 1; i<numbers.length;i++) { //최소값 찾기
			if(numbers[min] > numbers[i]) {
				backup = numbers[min];
				numbers[min] = numbers[i];
				numbers[i] = backup;
			}		
		}
		
				
		
				

		// 출력
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + " ");
		}

	}

}
