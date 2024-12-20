package api.util.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test05기억력테스트게임2 {

	public static void main(String[] args) {

		List<String> history = new ArrayList<>();

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.print("편의점에가면! ");
			String input = sc.nextLine();

			//입력이 여러 단어로 될 가능성이 크므로 split으로 분할
			String[] words = input.split(" ");
			//System.out.println("단어 개수 = " + words.length);
			
			//처음엔 일치할거라고 기대하고 틀린 걸 찾으면 값을 수정(flag패턴)
			boolean correct = true;
			for(int i = 0; i < words.length-1; i++) { //마지막 것은 저장소에 있을 수 없으니 -1
				String word = words[i];
				String historyWord = history.get(i);
				if(word.equals(historyWord) == false) {
					correct = false;
					break;
				}
			}
			//correct가 false면 저장소가 일치하지 않는 것
			if(correct == false) break;
			
			String lastWord = words[words.length-1];
			if (history.contains(lastWord)) {// 기존에 입력한 적이 있는 단어라면
				break;// 내보내기
			} else {// 기존에 입력한 적이 없는 단어라면
				history.add(lastWord);// 기록에 추가
			}
		}

		sc.close();
		System.out.println("게임 오버!");
		// 지금까지 입력한 내역(history에 저장된 데이터) 출력

		System.out.println("총 입력한 단어 수 : " + history.size() + "개");
		for (int i = 0; i < history.size(); i++) {
			String word = history.get(i);
			System.out.println("→ " + word);
		}

	}

}
