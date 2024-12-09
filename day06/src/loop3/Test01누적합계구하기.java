package loop3;

public class Test01누적합계구하기 {
	public static void main(String[] args) {
		// (ex) 1부터 10까지 더하세요

		int total = 0;

		for (int i = 1; i <= 10; i++) {
			total += i;
		}

		System.out.println("total = " + total);
	}
}
