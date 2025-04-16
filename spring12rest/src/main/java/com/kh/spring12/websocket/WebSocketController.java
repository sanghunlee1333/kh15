package com.kh.spring12.websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import lombok.extern.slf4j.Slf4j;

/**
 	웹소켓에서 메세지 수신 이후의 작업을 처리하기 위한 컨트롤러
 	원래 웹소켓은 HTTP와 구조가 완전히 다르지만 브로커의 도움으로 비슷한 구조로 구현
 */
@Slf4j
@Controller
//@RequestMapping("/app") -> 필요없음
public class WebSocketController {

	//원래대로라면...
	//@RequestMapping("/chat") 처럼 작성해야 하지만 웹소켓은 다르다
	@MessageMapping("/chat") //이렇게 사용
	@SendTo("/public/chat") //자동으로 반환된 내용이 전달되도록 처리
	public String chat(String message) {
		log.debug("메세지 도착 = {}", message);
		return message;
	}
	
}
