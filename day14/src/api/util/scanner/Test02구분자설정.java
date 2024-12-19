package api.util.scanner;

import java.util.Scanner;

public class Test02구분자설정 {

	public static void main(String[] args) {
		
		//String rainbow = "빨강+주황+노랑+초록+파랑+남색+보라";
		String rainbow = "빨강,주황+노랑*초록$파랑#남색=보라";
		
		Scanner sc = new Scanner(rainbow);
		//구분자(delimiter) 지정
		//sc.useDelimiter("\\+"); //더하기로 끊어내세요
		sc.useDelimiter("[,+*$#=]"); //제시한 기호들로 끊어내세요
		while(sc.hasNext()) {
			System.out.println(sc.next());
		}
		sc.close();
	}

}
