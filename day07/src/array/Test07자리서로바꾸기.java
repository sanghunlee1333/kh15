package array;

public class Test07자리서로바꾸기 {

	public static void main(String[] args) {
		//배열 준비
		int[] numbers = new int[] {30, 50, 20, 10, 40};
	
		//(Q) 0번 지점과 3번 지점의 값을 서로 바꾸세요
		
		//(중요) 자바는 공간의 맞교환이 불가능하다
//		numbers[3] = numbers[0];
//		numbers[0] = numbers[3];
		
		//추가 공간을 만들어서 우회전으로 교체
		int backup = numbers[3];
		numbers[3] = numbers[0];
		numbers[0] = backup;
		
		//출력
		for(int i = 0; i < numbers.length; i++) {
			System.out.println(numbers[i]);
		}
	}

}
