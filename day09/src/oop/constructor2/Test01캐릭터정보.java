package oop.constructor2;

import java.util.Scanner;

public class Test01캐릭터정보 {

	public static void main(String[] args) {
		
		Character c1 = new Character("장발장", "도둑", 15, 100);
		Character c2 = new Character("허준", "성직자", 10, 10);
		Character c3 = new Character("나폴레옹", "전사", 20, 500);
		
		c1.show();
		c2.show();
		c3.show();
	}

}
