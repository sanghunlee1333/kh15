package api.util.collection;

import java.util.ArrayList;
import java.util.List;

public class Test09포커업그레이드 {

	public static void main(String[] args) throws Exception {
//		Card card = new Card("스페이스", "A");
//		System.out.println(card);
		List<String> shapes = List.of("하트", "다이아", "클로버", "스페이드");
		List<String> numbers = List.of("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K");

		CardDeck deck = new CardDeck(); // 비어있는 카드덱을 생성
		for (String shape : shapes) {
			for (String number : numbers) {
				Card card = new Card(shape, number);
				deck.add(card); // 카드 추가
			}
		}

		// 카드 섞기
		deck.shuffle();

		// 플레이어 생성
		List<Player> players = new ArrayList<>();
		players.add(new Player("피카츄"));
		players.add(new Player("라이츄"));
		players.add(new Player("파이리"));
		players.add(new Player("꼬부기"));

//		Player p1 = new Player("피카츄");
//		Player p2 = new Player("라이츄");
//		Player p3 = new Player("파이리");
//		Player p4 = new Player("꼬부기");

		for (int turn = 1; turn <= 6; turn++) {
			players.get(0).receive(deck.draw());
			players.get(1).receive(deck.draw());
			players.get(2).receive(deck.draw());
			players.get(3).receive(deck.draw());
//			p1.receive(deck.draw());
//			p2.receive(deck.draw());
//			p3.receive(deck.draw());
//			p4.receive(deck.draw());
		}
		for (Player player : players) {

			System.out.println(player);
//			System.out.println(p1);
//			System.out.println(p2);
//			System.out.println(p3);
//			System.out.println(p4);
		}

//		for (int i = 0; i < 10; i++) {//10장을 뽑으려면...
//			Card c = deck.draw(); // 카드 뽑기
//			System.out.println(c); // 출력
//		}

		System.out.println("남은 카드 수 : " + deck.getCount());
	}

}
