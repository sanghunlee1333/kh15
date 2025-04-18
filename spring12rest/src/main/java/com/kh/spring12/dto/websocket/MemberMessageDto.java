package com.kh.spring12.dto.websocket;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class MemberMessageDto {
	private Long memberMessageNo;
	private String memberMessageType;
	private String memberMessageContent;
	private Timestamp memberMessageTime;
	private String memberMessageSender;
	private String memberMessageReceiver;
}
