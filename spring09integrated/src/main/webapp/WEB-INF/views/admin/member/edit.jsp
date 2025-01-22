<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>  

<jsp:include page = "/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>회원 정보 수정</h1>

<form action = "edit" method = "post">
	* 닉네임 <input type = "text" name = "memberNickname" value = "${memberDto.memberNickname}" required> <br><br>
	* 이메일 <input type = "email" name = "memberEmail" value = "${memberDto.memberEmail}" required> <br><br>
	생년월일 <input type = "date" name = "memberBirth" value = "${memberDto.memberBirth}"> <br><br>
	연락처 <input type = "tel" name = "memberContact" value = "${memberDto.memberContact}"> <br><br>
	주소 <br>
	<input type = "text" name = "memberPost" size = "6" value = "${memberDto.memberPost}"> <br>
	<input type = "text" name = "memberAddress1" size = "60" value = "${memberDto.memberAddress1}"> <br>
	<input type = "text" name = "memberAddress2" size = "60" value = "${memberDto.memberAddress2}"> <br><br>
	<button>정보 수정</button>
</form>

<jsp:include page = "/WEB-INF/views/template/footer.jsp"></jsp:include>
    