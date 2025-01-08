package com.kh.spring09.dto;

import lombok.Data;

@Data
public class ItemDto {
	
	private int itemNo;
	private String itemName;
	private String itemType;
	private int itemPrice;
	private Float itemDiscountRate;
	private int itmQty;
	private String itemEarly;

}
