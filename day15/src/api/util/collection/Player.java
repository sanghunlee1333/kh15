package api.util.collection;

import java.util.ArrayList;
import java.util.List;

public class Player {
	//필드 : 이름, 카드저장소
	private String name;
	private List<Card> cards = new ArrayList<>();
	
	//생성자 : 이름 필수
	public Player(String name) {
		this.name = name;
	}
	
	public void receive(Card card) {
		cards.add(card);
	}
	public int getCount() {
		return cards.size();
	}
	
	@Override
	public String toString() {
		return "[" + name + "] - " + cards;
	}
}
