package api.util.collection;

import java.util.Objects;

public class Card {
	//필드 : 모양, 숫자(변경불가)
	private final String shape; 
	private final String number;
	
	public Card(String shape, String number) {
		this.shape = shape;
		this.number = number;
	}

	//getter 메소드만 생성
	public String getShape() {
		return shape;
	}
	
	public String getNumber() {
		return number;
	}
	
	//모양과 숫자가 같으면 같다고 판정
	@Override
	public int hashCode() {
		return Objects.hash(number, shape);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		return Objects.equals(number, other.number) && Objects.equals(shape, other.shape);
	}

	//요약정보에 모양 + 띄어쓰기 + 숫자로 나오도록 구현
	@Override
	public String toString() {
		return this.shape + " " + this.number;
	}
	
	
	

}
