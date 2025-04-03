package com.kh.spring12.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
 
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class AccountDto {

	private String accountId;//아이디
	private String accountPw;//비밀번호
	private String accountNickname;//닉네임
	private String accountBirth;//생년월일
	private String accountContact;//연락처
	private String accountEmail;//이메일
	private String accountLevel;//회원등급
	private int accountPoint;//보유포인트
	private String accountPost;//우편번호
	private String accountAddress1;//기본주소
	private String accountAddress2;//상세주소
	private Timestamp accountJoin;//가입일시 //LocalDateTime도 가능
	private Timestamp accountLogin;//최종로그인일시
	private Timestamp accountChange;//최종비밀번호변경일시
}
