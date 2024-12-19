package api.util.scanner;

import java.util.Scanner;

public class Test03형태별입력 {

	public static void main(String[] args) {
		
		String str = "100\nhello\n3.14\n"; 
		//String str = "100 hello 3.14 goodbye"; //입력 데이터가 1개가 더 있다하더라도 문제 없음 //정적인 데이터
		
		Scanner sc = new Scanner(str);
		
		System.out.println(sc.nextInt());
		System.out.println(sc.next());
		System.out.println(sc.nextDouble());
		
		sc.close();
	}

}
