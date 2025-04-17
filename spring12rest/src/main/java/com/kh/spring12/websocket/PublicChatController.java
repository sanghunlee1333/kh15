package com.kh.spring12.websocket;

import java.time.LocalDateTime;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Controller;

import com.kh.spring12.vo.websocket.ChatResponseVO;
import com.kh.spring12.vo.websocket.ChatVO;

import lombok.extern.slf4j.Slf4j;

/**
 	웹소켓에서 메세지 수신 이후의 작업을 처리하기 위한 컨트롤러
 	원래 웹소켓은 HTTP와 구조가 완전히 다르지만 브로커의 도움으로 비슷한 구조로 구현
 */
@Slf4j
@Controller
//@RequestMapping("/app") -> 필요없음
public class PublicChatController {

	//원래대로라면...
	//@RequestMapping("/chat") 처럼 작성해야 하지만 웹소켓은 다르다
//	@MessageMapping("/chat") //이렇게 사용
//	@SendTo("/public/chat") //자동으로 반환된 내용이 전달되도록 처리
//	public String chat(String message) {
//		log.debug("메세지 도착 = {}", message);
//		return message;
//	}

	//조금 더 복잡한 처리를 하고 싶다면 수동으로 메세지를 전송하도록 해야한다
	//하지만 수동으로 하려면 도구가 필요하다(SimpMessagingTemplate)
	@Autowired
	private SimpMessagingTemplate messagingTemplate;
	
	//메세지 수신을 좀 더 체계적인 형태인 Message<?>로 수신
	//(장점) STOMP의 헤더와 바디를 각각 읽어서 처리할 수 있다면(인증 등에 유리)
	//(단점) 새롭다 어렵다
	@MessageMapping("/chat") //사용자가 /app/chat으로 보내면~
	public void chat(Message<ChatVO> message) {
		//정보 분석(header)
		StompHeaderAccessor accessor = StompHeaderAccessor.wrap(message);
		String uuid = accessor.getFirstNativeHeader("uuid");
		
		//메세지 해석(body)
		ChatVO body = message.getPayload();
		log.debug("body = {}", body);
		
		//ChatVO => ChatResponseVO 변환
		//(+조건 추가)욕설이 포함되어 있다면 보낸사람에게 경고메세지 발송
		String regex = "(수박|신발끈|개나리|시베리아)";
		String content = body.getContent();
		//if(content.matches(regex)) { //matches는 일치해야하므로 정상작동(X)
		if(Pattern.compile(regex).matcher(content).find()) { //포함되어도 작동
			content = content.replaceAll(regex, "****");
			//추가로 보낸사람에게 경고메세지 발송
			messagingTemplate.convertAndSend("/private/chat/"+uuid, 
					ChatResponseVO.builder()
							.content("욕 하지마라!")
							.time(LocalDateTime.now())
						.build()
			);
		}
		
		ChatResponseVO response = ChatResponseVO.builder()
				.content(content) //수신한 내용
				.time(LocalDateTime.now()) //현재 시각
			.build();
		
		//수동으로 메세지를 전송하는 코드
		//messagingTemplate.convertAndSend("채널명", 데이터);
		messagingTemplate.convertAndSend("/public/chat", response);
	}
	
}
