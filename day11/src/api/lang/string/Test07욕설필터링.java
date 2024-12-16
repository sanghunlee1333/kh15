package api.lang.string;

import java.util.Scanner;

public class Test07욕설필터링 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String[] filter = new String[] { "개나리", "십장생", "신발끈", "수박씨", "시베리아", "조카", "주옥", "시방", "십자수" };

		String line = sc.nextLine(); //이런 시베리아 개나리 수박씨같은 십장생을 보았나
		String star = "★";

		// line에 대한 변경 처리
		for (int i = 0; i < filter.length; i++) {
			int size = filter[i].length();
			line = line.replace(filter[i], star.repeat(size)); //repeat 내가 정한 크기만큼 복사해주는 메소드
															   //repeat는 자바11부터 가능. 11 아래에서는 알아서 구현
		}
		System.out.println(line);

	}

}
