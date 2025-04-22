package com.kh.spring12.websocket;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Controller;

import com.kh.spring12.dao.AccountDao;
import com.kh.spring12.dto.AccountDto;
import com.kh.spring12.service.TokenService;
import com.kh.spring12.vo.ClaimVO;
import com.kh.spring12.vo.websocket.MemberChatResponseVO;
import com.kh.spring12.vo.websocket.MemberChatVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class GroupChatController {
	
	@Autowired
	private SimpMessagingTemplate messagingTemplate;
	@Autowired
	private TokenService tokenService;
	@Autowired
	private AccountDao accountDao;
	
	//WebSocket에서도 STOMP 환경이라면 경로변수를 사용할 수 있따
	//하지만 PathVariable이 아니라 DestinationVariable이라고 부름
	@MessageMapping("/group/{roomNo}")
	public void chat(@DestinationVariable long roomNo, Message<MemberChatVO> message) {
		//헤더 분석
		StompHeaderAccessor accessor = StompHeaderAccessor.wrap(message);
		String accessToken = accessor.getFirstNativeHeader("accessToken");
		if(accessToken == null || accessToken.startsWith("Bearer ") == false) return;
		
		//회원정보 조회
		ClaimVO claimVO = tokenService.parseBearerToken(accessToken);
		AccountDto accountDto = accountDao.selectOne(claimVO.getUserId());
		if(accountDto == null) return;
		
		//메세지 변환 (MemberChatVO -> MemberChatResponseVO)
		MemberChatVO vo = message.getPayload();
		
		MemberChatResponseVO response = MemberChatResponseVO.builder()
											.type("CHAT")
											.accountId(accountDto.getAccountId())
											.accountNickname(accountDto.getAccountNickname())
											.accountLevel(accountDto.getAccountLevel())
											.content(vo.getContent())
											.time(LocalDateTime.now())
										.build();
		
		//최종 전송
		messagingTemplate.convertAndSend("/private/group/chat/" + roomNo, response);
	}
	
}
