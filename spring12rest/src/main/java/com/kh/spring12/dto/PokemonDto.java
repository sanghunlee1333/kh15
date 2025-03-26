package com.kh.spring12.dto;

import lombok.Data;

//등록은 왜 하는 걸까?
//- 인스턴스를 직접 생성하지 않고 스프링에게 생성을 요청하는 것
//- 특별한 옵션이 없다면 1개만 생성(싱글톤, singleton)
//- DTO는 여러 개 존재하며 필요할 때마다 만들어야 한다
//- 등록을 하지 않고 그때그때 new로 만들어서 사용 (DTO만)

//@Setter	@Getter @NoArgsConstructor @ToString //@All -> 모든 매개변수가 있는 생성자를 추가해주는 어노테이션
@Data
public class PokemonDto {
	
	private int pokemonNo;
	private String pokemonName;
	private String pokemonType;
	private int pokemonLike;
	
	//아래는 없어도 됨
//	@Override
//	public String toString() {
//		return "PokemonDto [pokemonNo=" + pokemonNo + ", pokemonName=" + pokemonName + ", pokemonType=" + pokemonType
//				+ "]";
//	}
//	public PokemonDto() {
//		super();
//	}
//	public int getPokemonNo() {
//		return pokemonNo;
//	}
//	public void setPokemonNo(int pokemonNo) {
//		this.pokemonNo = pokemonNo;
//	}
//	public String getPokemonName() {
//		return pokemonName;
//	}
//	public void setPokemonName(String pokemonName) {
//		this.pokemonName = pokemonName;
//	}
//	public String getPokemonType() {
//		return pokemonType;
//	}
//	public void setPokemonType(String pokemonType) {
//		this.pokemonType = pokemonType;
//	}
}