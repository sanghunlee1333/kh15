<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page = "/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>비밀번호 변경</h1>

<form action = "password" method = "post">
	기존 비밀번호 <input type = "password" name = "currentPw" required> <br><br>
	신규 비밀번호 <input type = "password" name = "newPw" required> <br><br>
	<button>비밀번호 변경</button>
</form>

<jsp:include page = "/WEB-INF/views/template/footer.jsp"></jsp:include>