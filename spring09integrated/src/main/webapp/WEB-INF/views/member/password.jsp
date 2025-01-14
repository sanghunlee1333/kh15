<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page = "/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>비밀번호 변경</h1>

<form action = "password" method = "post">
	기존 비밀번호 <input type = "password" name = "currentPw" required> <br><br>
	신규 비밀번호 <input type = "password" name = "newPw" required> <br><br>
	<button>비밀번호 변경</button>
</form>

<c:if test = "${param.error == '1'}">
	<h2 style = "color:red">비밀번호가 일치하지 않습니다</h2>
</c:if>
<c:if test = "${param.error == '2'}">
	<h2 style = "color:red">같은 비밀번호로는 변경할 수 없습니다</h2>
</c:if>

<jsp:include page = "/WEB-INF/views/template/footer.jsp"></jsp:include>