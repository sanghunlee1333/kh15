package jdbc.dto;

//DTO(Data Transfer Object)
//데이터베이스 한 줄을 인스턴스화 하기 위한 클래스(상자)
//특정 테이블의 데이터를 묶음으로 보관하기 위한 클래스
public class PokemonDto {
	private int pokemonNo; //pokemon 테이블의 pokemon_no와 연동할 필드
	private String pokemonName; //pokemon 테이블의 pokemon_name와 연동할 필드
	private String pokemonType; //pokemon 테이블의 pokemon_type과 연동할 필드
	
	//세터, 게터 메소드
	public int getPokemonNo() {
		return pokemonNo;
	}
	public void setPokemonNo(int pokemonNo) {
		this.pokemonNo = pokemonNo;
	}
	public String getPokemonName() {
		return pokemonName;
	}
	public void setPokemonName(String pokemonName) {
		this.pokemonName = pokemonName;
	}
	public String getPokemonType() {
		return pokemonType;
	}
	public void setPokemonType(String pokemonType) {
		this.pokemonType = pokemonType;
	}
	
	//기본 생성자 - 1개는 무조건 만들어야 한다 (이유 - ??? 공부)
	public PokemonDto() {
		super();
	}
	
	//toString (만드는 이유 - ??? 공부)
	@Override
	public String toString() {
		return "PokemonDto [pokemonNo=" + pokemonNo + ", pokemonName=" + pokemonName + ", pokemonType=" + pokemonType
				+ "]";
	}
	
	
}
