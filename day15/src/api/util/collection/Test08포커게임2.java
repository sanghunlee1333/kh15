package api.util.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test08포커게임2 {

	public static void main(String[] args) {
		
		//카드 덱 준비
		List<String> cardDeck = createCardDeck();
		
		//카드 덱 섞기
		Collections.shuffle(cardDeck);
		
//		System.out.println("덱 크기 : " + cardDeck.size());
//		System.out.println(cardDeck);
		
		//플레이어 준비(n명)
		List<List<String>> players = new ArrayList<>(); //아래 리스트들을 또 다시 리스트화 한것
		
		players.add(new ArrayList<>());//index : 0
		players.add(new ArrayList<>());//index : 1
		players.add(new ArrayList<>());//index : 2
		players.add(new ArrayList<>());//index : 3
				
//		List<String> player1 = new ArrayList<>();
//		List<String> player2 = new ArrayList<>();
//		List<String> player3 = new ArrayList<>();
//		List<String> player4 = new ArrayList<>();
		
		for(int turn = 1; turn <= 6; turn++) {//6턴 동안
			players.get(0).add(cardDeck.remove(0)); //카드덱에서 꺼내 플레이어1에게전달 //remove가 API를 보면 반환하면서 지운다고 되어있음
			players.get(1).add(cardDeck.remove(0)); //지울 때마다 그 바로 다음 장이 0번이 된다
			players.get(2).add(cardDeck.remove(0));
			players.get(3).add(cardDeck.remove(0));
		}
		
		System.out.println("player = " + players.get(0));
		System.out.println("player = " + players.get(1));
		System.out.println("player = " + players.get(2));
		System.out.println("player = " + players.get(3));
		//System.out.println("남은 카드 개수 = " + cardDeck.size());
		
	}
	
	public static List<String> createCardDeck() { //사람 수가 많아서 카드가 모자랄 때, 새로운 카드를 준비
		List<String> shapes = List.of("하트", "스페이드", "클로버", "다이아");
		List<String> numbers = List.of("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K");

		List<String> cardDeck = new ArrayList<>();
		
		for(String shape : shapes) {
			for(String number : numbers) {
				//System.out.println("share = " + shapes + ", number = " + number);
				cardDeck.add(shape + " " + number);
			}
		}
		return cardDeck;
	}

}
