package api.util.scanner;

import java.util.Scanner;

public class Test04키보드입력 {

	public static void main(String[] args) {
		
		//next(), nextInt()와 같은 명령들은 공백(스페이스, 탭, 개행 등)으로 구분
		//---> 구분기호가 많으니까 구분기호까지 정리해주지는 않음
		//nextLine()은 개행문자(\n)만 구분
		//---> 구분기호를 읽고나서 정리해줌(제거)
		//next()유형과 nextLine() 사이에 nextLine()를 한 번 더 써줘서 남아있는 개행문자(next()가 남긴 설거지)를 지워준다.
		
		Scanner sc = new Scanner(System.in); //동적인 데이터 - 키보드 입력
		
//		System.out.println(sc.nextInt());
//		System.out.println(sc.next());
//		System.out.println(sc.nextDouble());
		
		System.out.print("이름 : ");
		String name = sc.next();
		
		System.out.print("나이 : ");
		int age = sc.nextInt();
		
		//next() 유형의 명령이 남긴 \n을 제거하는 코드
		sc.nextLine();
		
		System.out.print("주소 : ");
		String address = sc.nextLine();
		
		System.out.println("name = " + name);
		System.out.println("age = " + age);
		System.out.println("address = " + address);
		
		sc.close();
	}

}
