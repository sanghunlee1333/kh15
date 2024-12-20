package api.util.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//카드덱
public class CardDeck {
	//필드 : 카드 여러장 -> List<Card>
	private List<Card> cards;
	//생성자 : 카드들을 전달받아 설정
	public CardDeck() {
		this.cards = new ArrayList<>();
	}
	public CardDeck(List<Card> cards) {
		this.cards = cards;
	}
	
	//메소드 : 셔플 / 한장씩 주기 / 남은 장수 확인하기
	public void add(Card card) {
		cards.add(card);
	}
	public void shuffle() {
		if(cards == null) return;
		Collections.shuffle(cards);
	}
	
	public Card draw() throws Exception { //반환형이 Card
		if(cards == null) 
			throw new Exception("카드가 없어요");
		return cards.remove(0);
	}
	
	public int getCount() {
		if(cards == null) return 0;
		return cards.size();
	}
	
}
