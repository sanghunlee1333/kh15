package com.kh.spring12.vo.websocket;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//서버에서 사용자에게 시스템 메세지를 보낼 때 사용할 형태
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class SystemMessageVO {
	private String content;
	private LocalDateTime time;
}
