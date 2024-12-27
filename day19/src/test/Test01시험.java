package test;

import java.util.Scanner;

public class Test01시험 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("성을 입력하세요 : ");
		String lastName = sc.next();
		
		System.out.print("이름을 입력하세요 : ");
		String firstName = sc.next();
		
		System.out.print("나이을 입력하세요 : ");
		int age = sc.nextInt();
		
		System.out.print("직업을 입력하세요 : ");
		String job = sc.next();
		
		Person p1 = new Person(lastName, firstName, age);
		
		p1.show();
		
	}

}
