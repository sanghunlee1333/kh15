package com.kh.spring12.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/** 
  웹소켓 설정 파일
  - FE에서 웹소켓으로 서버에 연결하기 위한 환경을 제공하는 것이 목표
  	1. 접속 가능한 주소를 설정
  	2. STOMP 방식의 구조가 작동할 수 있도록 도우미(=브로커)를 설정
  - 웹소켓 자체가 서버에 많은 무리가 가는 방식이므로 추가 허용 설정 필요
*/

//@EnableWebSocket //순수 웹소켓 활성화
@EnableWebSocketMessageBroker //STOMP 도우미 활성화
@Configuration //설정 파일임을 명시
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer { //역할 명시 : 웹소켓 도우미 설정 파일
	//[1] 사용자가 접속하거나 메세지를 보낼 수 있는 "채널"을 개설
	//- 사용자는 구독(subscribe)을 통해 특정 채널의 메세지를 수신할 수 있다
	//- 게시(publish)를 통해 특정 채널에 메세지를 전달할 수 있다 (구독 채널과 다름)
	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		//구독 가능한 채널의 접두사를 설정
		// - /public을 포함한 어떤 채널도 사용 가능(공개적인 대화 시 사용)
		// - /private을 포함한 어떤 채널도 사용 가능(개인적인 대화 시 사용) 
		registry.enableSimpleBroker("/public", "/private");
		
		//사용자가 메세지를 보낼 수 있는 채널을 설정
		// - /app으로 시작하는 채널로 메세지를 보내면 수신하겠다!
		registry.setApplicationDestinationPrefixes("/app");
	}
	
	//[2] 웹소켓 연결방식에 대한 설정
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/ws") //웹소켓 연결 생성 주소(접속 주소)
				.setAllowedOriginPatterns("*") //허용 가능한 클라이언트 주소패턴(CORS와 비슷)
				.withSockJS(); //ws를 http처럼 쓸 수 있게 하며 유용한 기능을 제공
	}
}
