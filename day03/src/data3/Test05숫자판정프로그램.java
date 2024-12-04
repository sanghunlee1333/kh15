package data3;

public class Test05숫자판정프로그램 {

	public static void main(String[] args) {
		
		//입력
		int number = 71;
		int ten = number / 10;
		int one = number % 10;
		
		//처리
		boolean a = number % 2 == 0;
		boolean b = number % 3 == 0;
		boolean c = (ten == 7) || (one == 7);
				
		//출력
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
	}

}
