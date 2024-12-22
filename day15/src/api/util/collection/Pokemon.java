package api.util.collection;

import java.util.Objects;

//포켓몬
public class Pokemon {
	//필드 : 번호, 이름, 속성(변경 불가)
	private final int number; //setter 못 만듬
	private final String name;
	private final String type;
	
	public int getNumber() {
		return number;
	}
	
	public String getName() {
		return name;
	}
	
	public String getType() {
		return type;
	}
	
	//생성자 : 번호, 이름, 속성을 필수로 설정
	public Pokemon(int number, String name, String type) {
		this.number = number;
		this.name = name;
		this.type = type;
	}
	
	//요약정보
	@Override
	public String toString() {
		return "번호 : " + this.number + ", 이름 : " + this.name + ", 속성 :" + this.type;
	}

	// 번호, 이름, 속성이 같으면 같다고 판단
	@Override
	public int hashCode() {
		return Objects.hash(name, number, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pokemon other = (Pokemon) obj;
		return Objects.equals(name, other.name) && number == other.number && Objects.equals(type, other.type);
	}
	
	
	

}
