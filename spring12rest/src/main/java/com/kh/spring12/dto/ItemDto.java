package com.kh.spring12.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class ItemDto {
	private Long itemNo;
	private String itemName;
	private String itemType;
	private Integer itemPrice;
	private Float itemDiscountRate;
	private Integer itemQty;
	private String itemEarly;
	
	public int getRealPrice() {
		if(itemPrice == null) return 0;
		if(itemDiscountRate == null) return itemPrice;
		return (int)(itemPrice * (1 - itemDiscountRate));
	}
}

/*
 	@Builder -> 객체를 세련되고 간편하게 만들 수 있게 해주는 어노테이션!
 	1. 일반적인 객체를 만드는 방식
 	-> 값을 한 번에 "체이닝" 방식으로 넣고, 마지막에 .build()로 객체 완성!
	PokemonDto dto = new PokemonDto();
	dto.setNo(1);
	dto.setName("피카츄");
	dto.setType("전기");
	
	2. @Builder 써서 만드는 방식
	PokemonDto dto = PokemonDto.builder()
						  .no(1)
						  .name("피카츄")
						  .type("전기")
					  .build();
*/
