package api.util.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test08포커게임 {

	public static void main(String[] args) {
		
		//카드 덱 준비
		List<String> shapes = List.of("하트", "스페이드", "클로버", "다이아");
		List<String> numbers = List.of("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K");

		List<String> cardDeck = new ArrayList<>();
		
		for(String shape : shapes) {
			for(String number : numbers) {
				//System.out.println("share = " + shapes + ", number = " + number);
				cardDeck.add(shape + " " + number);
			}
		}
		//카드 덱 섞기
		Collections.shuffle(cardDeck);
		
//		System.out.println("덱 크기 : " + cardDeck.size());
//		System.out.println(cardDeck);
		
		List<String> player1 = new ArrayList<>();
		List<String> player2 = new ArrayList<>();
		List<String> player3 = new ArrayList<>();
		List<String> player4 = new ArrayList<>();
		
		for(int turn = 1; turn <= 6; turn++) {//6턴 동안
			player1.add(cardDeck.remove(0)); //카드덱에서 꺼내 플레이어1에게전달 //remove가 API를 보면 반환하면서 지운다고 되어있음
			player2.add(cardDeck.remove(0)); //지울 때마다 그 바로 다음 장이 0번이 된다
			player3.add(cardDeck.remove(0));
			player4.add(cardDeck.remove(0));
		}
		
		System.out.println("player1 = " + player1);
		System.out.println("player2 = " + player2);
		System.out.println("player3 = " + player3);
		System.out.println("player4 = " + player4);
		//System.out.println("남은 카드 개수 = " + cardDeck.size());
		
	}

}
