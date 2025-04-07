package com.kh.spring12.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class AccountTokenDto {
	private Long accountTokenNo;
	private String accountTokenTarget; 
	private String accountTokenValue;
	private Timestamp accountTokenTime;
}
