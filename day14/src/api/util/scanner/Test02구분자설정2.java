package api.util.scanner;

import java.util.Scanner;

public class Test02구분자설정2 {

	public static void main(String[] args) {
		
		//String rainbow = "빨강+주황+노랑+초록+파랑+남색+보라";
		String rainbow = "빨강,주황+노랑*초록$파랑#남색=보라";
		
		Scanner sc = new Scanner(rainbow);
		
		while(sc.hasNextLine()) {
			//System.out.println(sc.nextLine());
			System.out.println(sc.findInLine("[가-힣]+")); //(강의)다시 들어보기
		}
		sc.close();
	}

}
