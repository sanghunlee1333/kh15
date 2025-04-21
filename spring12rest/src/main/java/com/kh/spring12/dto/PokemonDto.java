package com.kh.spring12.dto;

import lombok.Data;

//등록은 왜 하는 걸까?
//- 인스턴스를 직접 생성하지 않고 스프링에게 생성을 요청하는 것 -> Spring을 사용하면 객체를 직접 new 키워드로 생성하는 대신, Spring이 객체를 대신 만들어주고 관리해줌. 이렇게 하면 코드가 더 깔끔해지고, 객체 생성 방식에 대해 신경 쓸 필요가 없어짐
//- 특별한 옵션이 없다면 1개만 생성(싱글톤, singleton) -> Spring에서는 기본적으로 싱글톤 패턴을 사용하여 객체를 하나만 생성하고 그 객체를 여러 곳에서 공유하도록 관리. 즉, 하나의 인스턴스만 생성하고, 이를 여러 곳에서 사용하는 방식
//- DTO는 여러 개 존재하며 필요할 때마다 만들어야 한다 -> DTO(Data Transfer Object)는 어떤 데이터를 다른 시스템이나 레이어로 "전달"하기 위해 사용하는 객체. 
//- 이 객체는 하나의 인스턴스를 공유하지 않고, 필요할 때마다 새로운 객체로 생성해야 함. 그래서 new를 사용해서 직접 생성
//- 등록을 하지 않고 그때그때 new로 만들어서 사용 (DTO만) -> DTO는 데이터를 주고받을 때마다 새로운 객체를 만들어야 하므로, Spring에 등록할 필요 없이 new로 직접 생성
//- 예를 들어, 당신이 웹 애플리케이션을 개발하고 있고, 사용자 정보를 데이터베이스에서 가져와서 프론트엔드로 전달하려고 한다면, 그 사용자 정보는 DTO로 전달될 수 있음. 이때 DTO는 사용자 정보를 포함한 데이터를 전송하는 역할을 함
//- 왜 필요할까요? 데이터베이스에서 데이터를 직접 가져와서 프론트엔드에 보내면, 데이터베이스의 내부 구조와 프론트엔드에서 필요한 데이터 구조가 다를 수 있습니다. DTO는 이 구조 차이를 해결하고, 필요한 데이터만 전송하는 역할
//- 예를 들어, 데이터베이스에서 사용자의 이름, 이메일, 생일 등 여러 가지 정보가 있을 때, 프론트엔드에서는 그중 일부만 필요할 수 있음. 이때 DTO를 사용하여 필요한 데이터만 뽑아서 전송
//- 하나의 인스턴스만 생성 (싱글톤): Spring에서 관리하는 서비스 클래스나 DAO 같은 객체는 싱글톤 패턴을 사용하여 하나의 인스턴스만 생성하고, 이를 여러 곳에서 재사용. 즉, Spring은 이 객체들을 한 번만 만들어서 공유하고, 필요한 곳에서 사용하도록 함
//- UserService라는 서비스 클래스가 있을 때, 이 클래스는 하나의 인스턴스만 만들어서 여러 컨트롤러나 다른 클래스에서 공유. 이런 방식은 성능을 좋게 하고 메모리 사용을 줄여줌.
//- 새로운 객체가 필요하다 (DTO): 하지만 DTO는 데이터를 전송할 때마다 새로운 객체로 만들어야 함. 왜냐하면 데이터가 매번 달라지기 때문.
//- 예를 들어, 사용자의 정보를 전송할 때마다 그 내용이 달라지므로 각각 다른 DTO 객체가 필요. 
//- ex) 사용자 정보를 전달할 때, A 사용자의 정보는 name, email이 필요하고, B 사용자의 정보는 name, address만 필요할 수 있음. 이때마다 새로운 DTO 객체를 만들어서 해당 데이터만 담아서 전송
//- 즉, DTO는 데이터가 변할 때마다 새로운 객체로 생성되지만, 다른 클래스들은 Spring이 하나의 객체만 만들어서 여러 곳에서 재사용하게 됨

//@Setter @Getter @NoArgsConstructor @ToString //@All -> 모든 매개변수가 있는 생성자를 추가해주는 어노테이션
//- @Setter = 클래스의 필드(변수)에 대해 set 메서드를 자동으로 생성해줌. 이를 통해 외부에서 객체의 값을 설정할 수 있음
//- @Getter = 클래스의 필드에 대해 get 메서드를 자동으로 생성해줌. 이 메서드를 통해 필드 값을 읽을 수 있음
//- @NoArgsConstructor = 매개변수가 없는 기본 생성자를 자동으로 만들어줍니다. 객체를 생성할 때 인자를 전달하지 않아도 됨
//- @AllArgsConstructor = 모든 필드를 인자로 받는 생성자를 자동으로 만들어줌. 이 생성자를 사용하면 객체를 만들 때 필드 값을 바로 설정할 수 있음
//- @ToString = 클래스의 내용을 출력할 때 필드 값을 문자열로 변환하여 출력해주는 toString() 메서드를 자동으로 생성해줌. 객체를 출력할 때 유용
//- @Data = 위 5가지를 모두 한 번에 사용할 수 있게 해주는 복합 어노테이션. 이 어노테이션을 사용하면 DTO 클래스에서 필요한 모든 메서드가 자동으로 생성
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