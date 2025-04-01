package com.kh.spring12.vo;

import lombok.Data;

@Data
public class AccountInsertVO {
	
	private String accountId;//아이디
	private String accountPw;//비밀번호
	private String accountNickname;//닉네임
	private String accountBirth;//생년월일
	private String accountContact;//연락처
	private String accountEmail;//이메일
	private String accountPost;//우편번호
	private String accountAddress1;//기본주소
	private String accountAddress2;//상세주소

}
