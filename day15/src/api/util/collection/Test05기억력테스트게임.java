package api.util.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test05기억력테스트게임 {

	public static void main(String[] args) {

		//내 풀이
//		Scanner sc = new Scanner(System.in);
//		List<String> foods = new ArrayList<>();
//						
//		//int cnt = 0;
//		while (true) {
//			System.out.print("편의점에 가면 : ");
//			String name = sc.next(); //sc.nextLine(); 도 가능
//			
//			if(foods.contains(name)) { //기존에 입력한 적이 있는 단어라면
//				//System.out.println("중복!");
//				break;
//			}
//			foods.add(name);
//			//cnt++;
//		}
//		
//		sc.close();
//		System.out.println("GAME OVER");
//		System.out.println("총 입력 개수 : " + foods.size()); //cnt
//		for(int i = 0; i < foods.size(); i++) {
//			System.out.println("-> " + foods.get(i));
//		}

		// 강사님 풀이
		List<String> history = new ArrayList<>();

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.print("편의점에가면! ");
			String input = sc.next();

			if (history.contains(input)) {// 기존에 입력한 적이 있는 단어라면
				break;// 내보내기
			} else {// 기존에 입력한 적이 없는 단어라면
				history.add(input);// 기록에 추가
			}
		}

		sc.close();
		System.out.println("게임 오버!");
		// 지금까지 입력한 내역(history에 저장된 데이터) 출력

		System.out.println("총 입력한 단어 수 : " + history.size() + "개");
		for (int i = 0; i < history.size(); i++) {
			String word = history.get(i);
			System.out.println("→" + word);
		}

	}

}
