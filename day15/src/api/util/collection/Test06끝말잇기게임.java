package api.util.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test06끝말잇기게임 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		List<String> history = new ArrayList<>();
		history.add("자바");

		while (true) {
			String given = history.get(history.size() - 1); //history.getLast(); -> 자바 21부터 사용 가능.. 못 쓴다고 봐야 함
			System.out.print("제시어 : " + given + " -> ");
			String input = sc.nextLine().trim(); // next()는 안됨. 띄어쓰기까지 입력이 안되므로
			//trim으로 사용자가 입력한 띄어쓰기 먼저 제거

			//1. 입력값 형식 검사
			if(input.matches("^[가-힣]{2,6}$") == false) break; //한글 2 ~ 6글자가 아니면 나가세요
			
			//2. 연결 검사
			if(given.charAt(given.length()-1) != input.charAt(0)) break; //charAt은 원시형 반환 //방식1
//			if(given.endsWith(input.substring(0, 1)) == false) break; //substring은 문자열 반환 //방식2
//			if(input.startsWith(given.substring(given.length()-1)) == false) break;					//방식3
			
			//3. 저장소 중복 검사
			if(history.contains(input)) break;
			
			history.add(input);
		}
		
		sc.close();
		
		System.out.println("게임 오버");
		System.out.println("<게임 오버>");
//		for(int i = 0; i < history.size(); i++) {
//			String word = history.get(i);
//			System.out.println("-> " + word);
//		}
		for(String word : history) {//확장 Foreach
			//히스토리에 있는 것들을 word에 순차적으로 더한다. 다만 조건없이 끝까지 진행함!
			System.out.println("-> " + word);
		}
	}

}
