package loop;

import java.util.Scanner;

public class Test02이름입력받기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name;

		for (int i = 0; i < 5; i++) {
			System.out.print("이름 입력 : ");
			name = sc.next();
			System.out.println(name + "님 환영합니다");
		}

	}

}
