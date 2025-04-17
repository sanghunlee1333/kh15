package com.kh.spring12.vo.websocket;

import lombok.Data;

@Data
public class MemberChatVO {
	private String content;
	
	public boolean isDM() {
		if(content != null && content.startsWith("/w ")) 
			return true;
		return false;
	}
}
