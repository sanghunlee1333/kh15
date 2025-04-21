package com.kh.spring12.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.kh.spring12.dto.websocket.MemberMessageDto;
import com.kh.spring12.dto.websocket.MemberMessageViewDto;
import com.kh.spring12.vo.websocket.MemberChatResponseVO;
import com.kh.spring12.vo.websocket.MessageVO;
import com.kh.spring12.vo.websocket.SystemMessageVO;

@Component
public class MemberMessageConverter {
	
//	public List<SystemMessageVO> convertMessageFormat(List<MemberMessageDto> list) {
//	public List<MemberChatResponseVO> convertMessageFormat(List<MemberMessageDto> list) {
	
//	비회원용 메세지 변환 메소드 (SystemMessageVO , MemberChatResponseVO)
	public List<MessageVO> convertMessageFormat(List<MemberMessageViewDto> list) {
		List<MessageVO> convertList = new ArrayList<>();
		
		//모든 메세지를 반복하며 형태에 맞는 메세지로 바꿔서 저장
		for(MemberMessageViewDto memberMessageViewDto : list) {
			switch(memberMessageViewDto.getMemberMessageType()) {
			case "CHAT":
				convertList.add(MemberChatResponseVO.builder()
					.messageNo(memberMessageViewDto.getMemberMessageNo())
					.accountId(memberMessageViewDto.getMemberMessageSender())
					.accountNickname(memberMessageViewDto.getMessageSenderNickname())
					.accountLevel(memberMessageViewDto.getMessageSenderLevel())
					.type("CHAT")
					.content(memberMessageViewDto.getMemberMessageContent())
					.time(memberMessageViewDto.getMemberMessageTime().toLocalDateTime())
				.build());
				break;
			case "SYSTEM":
				convertList.add(SystemMessageVO.builder()
					.messageNo(memberMessageViewDto.getMemberMessageNo())
					.type("SYSTEM")
					.content(memberMessageViewDto.getMemberMessageContent())
					.time(memberMessageViewDto.getMemberMessageTime().toLocalDateTime())
				.build());
				break;
			}
		}
		
		return convertList;
	}
	
//	회원용 메세지 변환 (DM-SEND / DM-RECEIVE / CHAT / SYSTEM)
	public List<MessageVO> convertMessageFormat(List<MemberMessageViewDto> list, String userId) {	
		List<MessageVO> convertList = new ArrayList<>();
		
		//모든 메세지를 반복하며 형태에 맞는 메세지로 바꿔서 저장
		for(MemberMessageViewDto memberMessageViewDto : list) {
			switch(memberMessageViewDto.getMemberMessageType()) {
			case "DM"://DM-SEND, DM-RECEIVE
				//내 아이디가 작성자와 같다면 = 내가 보낸 DM이라면
				if(userId.equals(memberMessageViewDto.getMemberMessageSender())) {
					convertList.add(MemberChatResponseVO.builder()
						.messageNo(memberMessageViewDto.getMemberMessageNo())
						.type("DM-SEND")
						.accountId(memberMessageViewDto.getMemberMessageReceiver())
						.accountNickname(memberMessageViewDto.getMessageReceiverNickname())
						.accountLevel(memberMessageViewDto.getMessageReceiverLevel())
						.content(memberMessageViewDto.getMemberMessageContent())
						.time(memberMessageViewDto.getMemberMessageTime().toLocalDateTime())
					.build());
				}
				//내 아이디가 수신자와 같다면 = 내가 받은 DM이라면
				else if(userId.equals(memberMessageViewDto.getMemberMessageReceiver())){
					convertList.add(MemberChatResponseVO.builder()
						.messageNo(memberMessageViewDto.getMemberMessageNo())
						.type("DM-RECEIVE")
						.accountId(memberMessageViewDto.getMemberMessageSender())
						.accountNickname(memberMessageViewDto.getMessageSenderNickname())
						.accountLevel(memberMessageViewDto.getMessageSenderLevel())
						.content(memberMessageViewDto.getMemberMessageContent())
						.time(memberMessageViewDto.getMemberMessageTime().toLocalDateTime())
					.build());
				}
				break;
			case "CHAT":
				convertList.add(MemberChatResponseVO.builder()
					.messageNo(memberMessageViewDto.getMemberMessageNo())
					.accountId(memberMessageViewDto.getMemberMessageSender())
					.accountNickname(memberMessageViewDto.getMessageSenderNickname())
					.accountLevel(memberMessageViewDto.getMessageSenderLevel())
					.type("CHAT")
					.content(memberMessageViewDto.getMemberMessageContent())
					.time(memberMessageViewDto.getMemberMessageTime().toLocalDateTime())
				.build());
				break;
			case "SYSTEM":
				convertList.add(SystemMessageVO.builder()
					.messageNo(memberMessageViewDto.getMemberMessageNo())
					.type("SYSTEM")
					.content(memberMessageViewDto.getMemberMessageContent())
					.time(memberMessageViewDto.getMemberMessageTime().toLocalDateTime())
				.build());
				break;
			}
		}
		
		return convertList;
	}
}