<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page = "/WEB-INF/views/template/header.jsp"></jsp:include>  

<h1>회원가입</h1>

<form action = "join" method="post"> <!-- 메소드=포스트를 안써주면 뺑뻉 돈다  -->
	아이디 <input name = "memberId"> <br><br>
	비밀번호 <input name = "memberPw"> <br><br>
	닉네임 <input name = "memberNickname"> <br><br>
	이메일 <input name = "memberEmail"> <br><br>
	<button>회원 가입</button>
</form>

<jsp:include page = "/WEB-INF/views/template/footer.jsp"></jsp:include>