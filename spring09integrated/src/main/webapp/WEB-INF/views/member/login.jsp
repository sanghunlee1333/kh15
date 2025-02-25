<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page = "/WEB-INF/views/template/header.jsp"></jsp:include>

<form action="login" method="post">
<div class="container w-400">
	<div class="cell center">
		<h1>로그인</h1>
	</div>
	<div class="cell">
		<label>아이디</label>
		 <input type="text" name="memberId" required class="field w-100">
	</div>
	<div class="cell">
		<label>비밀번호</label>
		<input type="password" name="memberPw" required class="field w-100">
	</div>
	<div class="cell mt-20">
		<button type="submit" class="btn btn-positive w-100">로그인하기</button>
	</div>
	<div class = "cell center mt-20">
		<a href = "findPw">비밀번호가 기억나지않습니다</a>
	</div>

	<!-- if(error라는 파라미터가 있으면) { -->
	<!-- 뒤에 파라미터에 대입되는 값이 다 달라도 주소(?의 앞부분)는 동일하기 때문에 error 파라미터가 붙었는지 여부로 판단 -->
	<c:if test="${param.error != null}">
	<div class="cell center">
		<h2 class="red">로그인 정보가 일치하지 않습니다</h2>
	</div>
	</c:if>
</div>

</form>

<jsp:include page = "/WEB-INF/views/template/footer.jsp"></jsp:include>


