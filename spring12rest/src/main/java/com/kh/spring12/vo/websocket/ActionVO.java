package com.kh.spring12.vo.websocket;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class ActionVO {
	private String type; //ENTER or LEAVE
	private String accountId;
}
