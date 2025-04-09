package com.kh.spring12.vo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//복합 검색에 필요한 데이터를 설정하는 클래스
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class AccountSearchVO {
	private String accountId;
	private String accountNickname;
	private String accountContact;
	private Integer minAccountPoint;
	private Integer maxAccountPoint;
	private String beginAccountJoin;
	private String endAccountJoin;
	private List<String> accountLevels;
	private String accountAddress;
	private Integer beginRow;
	private Integer endRow;
}
