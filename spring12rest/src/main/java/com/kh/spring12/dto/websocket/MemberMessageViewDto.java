package com.kh.spring12.dto.websocket;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class MemberMessageViewDto {
	private Long memberMessageNo;
	private String memberMessageType;
	private String memberMessageContent;
	private Timestamp memberMessageTime;
	private String memberMessageSender;
	private String memberMessageReceiver;
	private String messageSenderNickname;
	private String messageSenderLevel;
	private String messageReceiverNickname;
	private String messageReceiverLevel;
}
