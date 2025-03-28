package com.kh.spring12.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class GiftcardDto {

	private int giftcardNo;
	private String giftcardName;
	private String giftcardContent;
	private int giftcardCharge;
	private int giftcardPrice;
	
	public int getDiscountRate() {
		return (giftcardCharge - giftcardPrice) * 100 / giftcardCharge;
	}
	
}
