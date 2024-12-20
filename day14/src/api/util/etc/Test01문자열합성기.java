package api.util.etc;

import java.util.Scanner;
import java.util.StringJoiner;

public class Test01문자열합성기 {

	public static void main(String[] args) {

//		String a = "바나나";
//		String b = "바나나";
//		String c = "바나나";
		
//		// System.out.println("[" + String.join("," , a, b, c) + "]");
//
//		Scanner sc = new Scanner(System.in);
//		StringJoiner sj = new StringJoiner(", ", "[", "]"); // prefix - 접두사, suffix - 접미사
//
//		int count = 0;
//		while (true) {
//			System.out.print("단어 입력 : ");
//			String word = sc.next();
//			if (word.equals("종료")) { // 문자열은 인스턴스이므로 비교연산 불가. 인스턴스인데 비교연산 쓰는 경우는 null 말고는 없다!
//				System.out.println("입력한 단어 목록");
//				System.out.println(sj.toString());
//				System.out.println("총 " + count + "개 입력하셨습니다");
//				break;
//			} else {
//				sj.add(word);
//				count++;
//			}
//		}
//		sc.close(); // 한번 종료하면 다시는 못 부름.
		
		Scanner sc = new Scanner(System.in);
		StringJoiner joiner = new StringJoiner(",", "[", "]"); 
		int count = 0;
		
		while(true) {
			System.out.print("입력 : ");
			String word = sc.next();
			if(word.equals("종료")) break;
			
			count++;
			joiner.add(word);
		}
		
		sc.close();
		
		System.out.println("입력한 단어 목록");
		System.out.println(joiner.toString());
		System.out.println("총 " + count+"번 입력했습니다");
	}

}
