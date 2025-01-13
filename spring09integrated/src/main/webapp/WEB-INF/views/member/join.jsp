<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page = "/WEB-INF/views/template/header.jsp"></jsp:include>  

<h1>가입 정보 입력</h1>

<form action = "join" method="post"> <!-- 메소드=포스트를 안써주면 뺑뻉 돈다  -->
	* 아이디 <input type = "text" name = "memberId" required> <br><br>
	* 비밀번호 <input type = "password" name = "memberPw" required> <br><br>
	* 닉네임 <input type = "text" name = "memberNickname" required> <br><br>
	* 이메일 <input type = "email" name = "memberEmail" required> <br><br> <!-- text로도 가능  -->
	생년월일 <input type = "date" name = "memberBirth"> <br><br>
	연락처 <input type = "tel" name = "memberContact"> <br><br>
	주소 <br>
	<input type = "text" name = "memberPost" size = "6" placeholder = "우편번호"> <br>
	<input type = "text" name = "memberAddress1" size = "60" placeholder = "기본주소"> <br> <!-- 기본 입력창 사이즈가 20 -->
	<input type = "text" name = "memberAddress2" size = "60" placeholder = "상세주소"> <br><br>
	<button>회원가입</button>
</form>

<jsp:include page = "/WEB-INF/views/template/footer.jsp"></jsp:include>