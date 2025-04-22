package com.kh.spring12.websocket;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;
import org.springframework.web.socket.messaging.SessionSubscribeEvent;

import com.kh.spring12.dao.AccountDao;
import com.kh.spring12.dao.websocket.MemberMessageDao;
import com.kh.spring12.dto.websocket.MemberMessageDto;
import com.kh.spring12.service.TokenService;
import com.kh.spring12.vo.ClaimVO;
import com.kh.spring12.vo.websocket.ActionVO;
import com.kh.spring12.vo.websocket.SystemMessageVO;
import com.kh.spring12.vo.websocket.UserVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class WebSocketEventHandler {
	
	@Autowired
	private SimpMessagingTemplate messagingTemplate;//전송 도구
	@Autowired
	private TokenService tokenService;
	@Autowired
	private AccountDao accountDao;
	@Autowired
	private MemberMessageDao memberMessageDao;
	
//	//접속한 사용자들을 관리하기 위한 저장소를 생성
//	private List<UserVO> users = new CopyOnWriteArrayList<>();//순서유지
//	//private Set<UserVO> users = new CopyOnWriteArraySet<>();//빠른처리
//	
//	//(+추가) 
//	//- 사용자가 퇴장할 때는 accessToken이 없어 본인확인이 불가
//	//- 입장할 때 부여된 세션번호와 UserVO를 이용하여 퇴장 시 정보 확인
//	private Map<String, UserVO> sessions = 
//							Collections.synchronizedMap(new HashMap<>());
	
	///그룹채팅에서 세션이 어느 방에 속해있는지를 알기 위한 저장소
	private Map<String, Long> roomSessions = 
							Collections.synchronizedMap(new HashMap<>());
	///해당세션의 사용자ID를 저장
	private Map<String, String> roomUsers = 
							Collections.synchronizedMap(new HashMap<>());
	
	//편리하게 만들기 위해 이름을 정해둠
	@EventListener
	public void whenUserEnter(SessionConnectEvent event) {
//		//헤더 정보를 추출
//		StompHeaderAccessor accessor = StompHeaderAccessor.wrap(event.getMessage());
//		String sessionId = accessor.getSessionId();//웹소켓 세션 ID
//		String accessToken = accessor.getFirstNativeHeader("accessToken");
//		log.debug("사용자 접속");
//		log.debug("session id = {} , accessToken = {}", sessionId, accessToken);
//		if(accessToken == null) return;//비회원 차단
//		
//		ClaimVO claimVO = tokenService.parseBearerToken(accessToken);
//		UserVO userVO = accountDao.selectOnePublicInfo(claimVO.getUserId());
//		
//		//같은 사용자가 있으면 차단하세요 (작동되려면 비교기준 설정이 필요)
//		if(users.contains(userVO)) return;
//		
//		users.add(userVO);//사용자 등록
//		sessions.put(sessionId, userVO);//세션 등록
//		log.debug("현재 사용자 수 : {}명", users.size());
//		
//		//입장알림
//		SystemMessageVO response = SystemMessageVO.builder()
//			.content(userVO.getAccountNickname()+"("+userVO.getAccountId()+") 님이 입장하셨습니다")
//			.time(LocalDateTime.now())
//		.build();
//		messagingTemplate.convertAndSend("/public/member/system",response);
//		
//		//시스템메세지 DB에 등록 (내용과 시간만 존재)
//		memberMessageDao.add(MemberMessageDto.builder()
//			.memberMessageType("SYSTEM")
//			.memberMessageContent(response.getContent())
//			.memberMessageTime(Timestamp.valueOf(response.getTime()))
//		.build());
	}
	@EventListener
	public void whenUserSubscribe(SessionSubscribeEvent event) {
		//log.debug("채널 구독 이벤트");
		
		StompHeaderAccessor accessor = StompHeaderAccessor.wrap(event.getMessage());
		//log.debug("destination = {}", accessor.getDestination());//구독채널 조회
		if(accessor.getDestination() == null) return;
		
//		if(accessor.getDestination().equals("/public/member/users")) {
//			messagingTemplate.convertAndSend("/public/member/users", users);
//		}
		///구독한 채널이 /private/group/users/xxx라면
		if(accessor.getDestination().startsWith("/private/group/users/")) {
			///방 번호(xxx)를 추출
			int poisition = "/private/group/users/".length();
			String roomStr = accessor.getDestination().substring(poisition);
			long roomNo = Long.parseLong(roomStr);
			
			///액세스토큰 추출
			String accessToken = accessor.getFirstNativeHeader("accessToken");
			log.debug("accessToken = {}", accessToken);
			ClaimVO claimVO = tokenService.parseBearerToken(accessToken);
			
			messagingTemplate.convertAndSend(
					"/private/group/users/"+roomNo,
					ActionVO.builder()
						.type("ENTER")
						.accountId(claimVO.getUserId())
					.build()
			);
			
			//세션과 방번호, 아이디를 기억
			roomSessions.put(accessor.getSessionId(), roomNo);
			roomUsers.put(accessor.getSessionId(), claimVO.getUserId());
		}
	}
	@EventListener
	public void whenUserLeave(SessionDisconnectEvent event) {
//		//헤더 정보를 추출
//		StompHeaderAccessor accessor = StompHeaderAccessor.wrap(event.getMessage());
//		String sessionId = accessor.getSessionId();//웹소켓 세션 ID
//		log.debug("사용자 접속 종료");
//		log.debug("session id = {}", sessionId);
//		
//		//세션 번호에 따른 UserVO를 찾아서 users에서 제거
//		UserVO userVO = sessions.remove(sessionId);
//		if(userVO == null) return;//에러 방지
//		
//		//세션과 연결된 UserVO를 지웠는데도 아직 연결된 세션이 있다면 중지
//		//= 여러 기기로 동시에 접속해 있었는데 하나만 나간 경우
//		if(sessions.containsValue(userVO)) return;
//		
//		users.remove(userVO);//사용자 제거
//		messagingTemplate.convertAndSend("/public/member/users", users);
//		
//		//퇴장알림
//		SystemMessageVO response = SystemMessageVO.builder()
//			.content(userVO.getAccountNickname()+"("+userVO.getAccountId()+") 님이 퇴장하셨습니다")
//			.time(LocalDateTime.now())
//		.build();
//		messagingTemplate.convertAndSend("/public/member/system",response);
//		
//		//시스템메세지 DB에 등록 (내용과 시간만 존재)
//		memberMessageDao.add(MemberMessageDto.builder()
//			.memberMessageType("SYSTEM")
//			.memberMessageContent(response.getContent())
//			.memberMessageTime(Timestamp.valueOf(response.getTime()))
//		.build());
		
		//////////////////////////////////////////////////////////////////////
		/// 그룹채팅 내보내기 처리
		/// - 현재 종료하는 세션이 소속된 방 정보를 알 수 있어야함
		/// - 기기가 여러개인 경우에는 모든 기기가 채팅방에서 나가져야함
		/// - 접속 시점에 세션과 방번호를 저장할 필요가 있음(subscribe 이벤트)
		//////////////////////////////////////////////////////////////////////

		/// 현재 종료하는 세션에 대한 방번호, 아이디 추출
		StompHeaderAccessor accessor = StompHeaderAccessor.wrap(event.getMessage());
		String sessionId = accessor.getSessionId();//웹소켓 세션 ID
		Long roomNo = roomSessions.remove(sessionId);
		String accountId = roomUsers.remove(sessionId);
		if(roomNo == null) return;
		if(accountId == null) return;
		
		messagingTemplate.convertAndSend(
			"/private/group/users/"+roomNo, 
			ActionVO.builder()
				.type("LEAVE")
				.accountId(accountId)
			.build()
		);
	}
}