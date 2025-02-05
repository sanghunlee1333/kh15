<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<!-- <h1>가입 정보 입력</h1>

<form action = "join" method="post"> 메소드=포스트를 안써주면 뺑뻉 돈다 
	* 아이디 <input type = "text" name = "memberId" required> <br><br>
	* 비밀번호 <input type = "password" name = "memberPw" required> <br><br>
	* 닉네임 <input type = "text" name = "memberNickname" required> <br><br>
	* 이메일 <input type = "email" name = "memberEmail" required> <br><br> text로도 가능 
	생년월일 <input type = "date" name = "memberBirth"> <br><br>
	연락처 <input type = "tel" name = "memberContact"> <br><br>
	주소 <br>
	<input type = "text" name = "memberPost" size = "6" placeholder = "우편번호"> <br>
	<input type = "text" name = "memberAddress1" size = "60" placeholder = "기본주소"> <br> 기본 입력창 사이즈가 20
	<input type = "text" name = "memberAddress2" size = "60" placeholder = "상세주소"> <br><br>
	<button>회원가입</button>
</form> -->

<form action="" method="post" autocomplete="off">
	<div class="container w-500">
		<div class="cell center">
			<h1>가입 정보 입력</h1>
		</div>
		<div class="cell">
			<label>아이디 *</label> <input type="text" name="memberId" required class="field w-100">
		</div>
		<div class="cell">
			<label>비밀번호 *</label> <input type="password" name="memberPw" required class="field w-100">
		</div>
		<div class="cell">
			<label>닉네임 *</label> <input type="text" name="memberNickname" required class="field w-100">
		</div>
		<div class="cell">
			<label>이메일 *</label> <input type="email" name="memberEmail" required class="field w-100">
		</div>
		<div class="cell">
			<label>생년월일</label> <input type="date" name="memberBirth"	class="field w-100">
		</div>
		<div class="cell">
			<label>연락처</label> <input type="tel" name="memberContact" class="field w-100">
		</div>
		<div class="cell">
			<label>주소</label>
		</div>
		<div class="cell">
			<input type="text" name="memberPost" size="6" maxlength="6"	class="field" placeholder="우편번호">
			<button type="button" class="btn btn-neutral">검색</button>
		</div>
		<div class="cell">
			<input type="text" name="memberAddress1" class="field w-100" placeholder="기본주소">
		</div>
		<div class="cell">
			<input type="text" name="memberAddress2" class="field w-100" placeholder="상세주소">
		</div>
		<div class="cell mt-30">
			<button type="submit" class="btn btn-positive w-100">회원가입</button>
		</div>
	</div>
</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>