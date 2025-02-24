<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<h1>인증번호 입력</h1>

<form action = "test1-3" method = "post">
	<input type = "hidden" name = "certEmail" value = "${param.email}">
	<input type = "text" inputmode = "numeric" name = "certNumber">
	<button type = "submit">인증번호 확인</button>
</form>