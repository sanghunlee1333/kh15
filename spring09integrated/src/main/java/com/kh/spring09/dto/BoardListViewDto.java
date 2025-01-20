package com.kh.spring09.dto;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.Data;

//oracle의 board_list_view와 연결될 DTO
@Data
public class BoardListViewDto { //자바 입장에서는 view가 실제로 테이블이 아니더라도, 테이블처럼 받아들여지므로 DTO 필요
	
	//BoardDto의 내용
	private int boardNo;
	private String boardTitle;
	//private String boardContent;
	private String boardWriter;
	private Timestamp boardWtime;
	private Timestamp boardEtime;
	private int boardLike;
	private int boardRead;
	private int boardReply;	
	//답변형 게시판을 위해 추가한 데이터
	private int boardGroup;
	private Integer boardTarget; //null이 가능한 데이터 항목이므로 Integer
	private int boardDepth;
	
	//상위글 정보
	private int targetNo;
	private String targetTitle;
	
	//MemberDto의 내용
	private String memberId;//아이디
	private String memberPw;//비밀번호
	private String memberNickname;//닉네임
	private String memberBirth;//생년월일
	private String memberContact;//연락처
	private String memberEmail;//이메일
	private String memberLevel;//회원등급
	private int memberPoint;//보유포인트
	private String memberPost;//우편번호
	private String memberAddress1;//기본주소
	private String memberAddress2;//상세주소
	private Timestamp memberJoin;//가입일시 //LocalDateTime도 가능
	private Timestamp memberLogin;//최종로그인일시
	private Timestamp memberChange;//최종비밀번호변경일시
	
	public String getBoardWtimeString() {
		LocalDate today = LocalDate.now();
		LocalDateTime wtime = boardWtime.toLocalDateTime();
		boardWtime.toLocalDateTime();
		//wtime의 날짜와 today를 비교하여 어떤 값을 내보낼지 결정
		LocalDate wdate = wtime.toLocalDate();
		
		//if(today.isAfter(wdate)) {
		if(wdate.isBefore(today)){ //wdate가 이전 날짜라면
		 	return wdate.toString();
		}
		else {
			return wtime.toLocalTime().format(DateTimeFormatter.ofPattern("HH:mm"));
		}
	}
	
}
