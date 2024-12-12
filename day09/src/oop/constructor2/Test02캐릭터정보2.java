package oop.constructor2;

import java.util.Scanner;

public class Test02캐릭터정보2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("아이디를 입력하세요 : ");
		String id = sc.next();
		System.out.print("직업을 입력하세요(전사/성직자/도둑) : ");
		String job = sc.next();
				
		Character c1 = new Character("장발장", "도둑", 15, 100);
		Character c2 = new Character("허준", "성직자", 10, 10);
		Character c3 = new Character("나폴레옹", "전사", 20, 500);
		Character c4 = new Character(id, job);
		
		c1.show();
		c2.show();
		c3.show();
		c4.show();
	}

}
