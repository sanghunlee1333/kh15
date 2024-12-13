package oop.poly2;

import java.util.Scanner;

public class Test01노트북정보 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("노트북을 먼저 선택하세요");
		System.out.print("1. 맥북 2. 갤럭시북 : ");
		int notebook = sc.nextInt();
		System.out.println();
		
		System.out.println("테스트할 기능을 선택하세요");
		System.out.print("1. 전원 2. 동영상재생 : 3. 타이핑 : ");
		int feature = sc.nextInt();
		
		Macbook m1 = new Macbook();
		Notebook m2 = m1;
		
		Galaxybook g1 = new Galaxybook();
		Notebook g2 = g1;
		
		if (notebook == 1 && feature == 1) {
			m2.power();
		}
		else if (notebook == 1 && feature == 2) {
			m2.video();
		}
		else if (notebook == 1 && feature == 3) {
			m2.typing();
		}
		else if (notebook == 2 && feature == 1) {
			g2.power();
		}
		else if (notebook == 2 && feature == 2) {
			g2.video();
		}
		else {
			g2.typing();
		}
	}

}
