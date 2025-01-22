<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>${memberDto.memberId}회원 정보</h1>
<div>
	닉네임 ${memberDto.memberNickname} <br>
	이메일 ${memberDto.memberEmail} <br>
	회원 등급 ${memberDto.memberLevel} <br>
	생년월일 ${memberDto.memberBirth} <br>
	연락처 ${memberDto.memberContact} <br>
	주소 <br>
	우편번호 ${memberDto.memberPost} <br>
	기본주소 ${memberDto.memberAddress1} <br>
	상세주소 ${memberDto.memberAddress2} <br>
</div>

<div>
	<a href="edit?memberId=${memberDto.memberId}">회원 정보 수정</a> 
	<a href="delete?memberId=${memberDto.memberId}">회원 정보 삭제</a> 
	<a href="list">목록</a>
</div>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>