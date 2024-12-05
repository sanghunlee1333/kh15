package condition;

public class Test01조건 {

	public static void main(String[] args) {
		// 조건
		// - 상황에 따라 실행이 될 수도 있는 구문
		//- if(조건식) { 코드 }
		//- 만약 둘 중 하나가 반드시 선택되는 경우라면 else를 사용

		int number = 5;

		if (number % 2 == 1){ 
			System.out.println("홀수");
		}
		// if (number % 2 == 0){
		else {
		System.out.println("짝수");
		}

	}

}
