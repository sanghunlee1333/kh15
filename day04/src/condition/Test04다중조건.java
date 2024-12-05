package condition;

public class Test04다중조건 {

	public static void main(String[] args) {
		// 다중 조건(조건 그룹)
		// 따져야 되는 경우가 많은 상황

		// (ex) 월에 따른 계절 출력
		int month = 5;

		if (month == 3 || month == 4 || month == 5) {
			System.out.println("봄");
		} else if (month == 6 || month == 7 || month == 8) {
			System.out.println("여름");
		} else if (month == 9 || month == 10 || month == 11) {
			System.out.println("가을");
		} else {
			System.out.println("겨울");
		}
	}

}
