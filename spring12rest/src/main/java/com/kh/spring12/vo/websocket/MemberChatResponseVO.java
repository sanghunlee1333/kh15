package com.kh.spring12.vo.websocket;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class MemberChatResponseVO {
	private String accountId;
	private String accountNickname;
	private String accountLevel;
	private String content;
	private LocalDateTime time;
}
