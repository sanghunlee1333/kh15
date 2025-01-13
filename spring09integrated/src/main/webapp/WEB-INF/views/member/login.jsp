<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page = "/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>로그인</h1>

<form action = "login" method = "post">
	아이디 <input type = "text" name = "memberId" required> <br><br>
	비밀번호 <input type = "password" name = "memberPw" required> <br><br>
	<button>로그인</button>
</form>

<!-- if(error라는 파라미터가 있으면 ){ --> 
<!-- 뒤에 파라미터에 대입되는 값이 다 달라도 주소(?의 앞부분)는 동일하기 때문에 error 파라미터가 붙었는지 여부로 판단 -->
<c:if test = "${param.error != null}">
<h2 style = "color:red">로그인 정보가 일치하지 않습니다.</h2>
</c:if>

<jsp:include page = "/WEB-INF/views/template/footer.jsp"></jsp:include>
