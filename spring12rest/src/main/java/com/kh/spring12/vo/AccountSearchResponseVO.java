package com.kh.spring12.vo;

import java.util.List;

import com.kh.spring12.dto.AccountDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//복합검색에 대한 응답데이터
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class AccountSearchResponseVO {
	
	private List<AccountDto> list;
	private boolean last;

}
