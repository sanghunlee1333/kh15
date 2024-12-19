package api.util.etc;

import java.util.Scanner;
import java.util.StringJoiner;

public class Test01문자열합성기 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		StringJoiner sj = new StringJoiner(", ", "[", "]");

		int count = 0;
		while (true) {
			System.out.print("단어 입력 : ");
			String word = sc.next();
			
			if (word.equals("종료")) {
				
				System.out.println("입력한 단어 목록");
				System.out.println(sj.toString());
				System.out.println("총 " + count + "개 입력하셨습니다");
				break;
			}
			else {
				sj.add(word);
				count++;
			}
		}
	}

}
