package loop;

public class Test04숫자찾기 {

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			int ten = i / 10, one = i % 10;
			boolean checkTen = ten == 5;
			boolean checkOne = one == 5;
			boolean hasFive = checkTen || checkOne;
			
			if (hasFive) { //최대한 if문 조건문에서 최대한 식이 안나오도록
				System.out.println(i);
			}
		}
	}

}
