package com.kh.spring12.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class BuyDetailDto {
	private long buyDetailNo;
	private long buyDetailOrigin;
	private long buyDetailItem;
	private String buyDetailName;
	private int buyDetailPrice;
	private int buyDetailQty;
	private String buyDetailStatus;
}
