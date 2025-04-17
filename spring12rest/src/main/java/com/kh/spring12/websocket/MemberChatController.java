package com.kh.spring12.websocket;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
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
public class MemberChatController {
	
	@Autowired
	private SimpMessagingTemplate messagingTemplate; //전송 도구
	@Autowired
	private TokenService tokenService;
	@Autowired
	private AccountDao accountDao;
	
	@MessageMapping("/member/chat")//앞에 /app이 있다고 생각해야함
	public void memberChat(Message<MemberChatVO> message) {
		//헤더 분석
		StompHeaderAccessor accessor = StompHeaderAccessor.wrap(message);
		String accessToken = accessor.getFirstNativeHeader("accessToken");
		//log.debug("accessToken = {}", accessToken);
		
		//(+추가) 토큰을 해석해서 유효하지 않으면 차단
		if(accessToken == null || accessToken.startsWith("Bearer ") == false) return;
		ClaimVO claimVO = tokenService.parseBearerToken(accessToken);
		
		//(+추가) 회원 정보를 조회
		AccountDto accountDto = accountDao.selectOne(claimVO.getUserId());
		
		//바디 분석
		MemberChatVO vo = message.getPayload();
		log.debug("content = {}", vo.getContent());
		
		//MemberChatVO -> MemberChatResponseVO 변환
		MemberChatResponseVO response = MemberChatResponseVO.builder()
					.accountId(accountDto.getAccountId())
					.accountNickname(accountDto.getAccountNickname())
					.accountLevel(accountDto.getAccountLevel())
					.content(vo.getContent())
					.time(LocalDateTime.now())
				.build();
		
		//전송
		messagingTemplate.convertAndSend("/public/member/chat", response);
	}
	
}
