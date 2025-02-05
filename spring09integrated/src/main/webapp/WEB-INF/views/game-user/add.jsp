<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<!-- <form action = "add" method="post"> -->
<!-- <form action = "add" method = "post" enctype = "multipart/form-data">
	ID <input name = "gameUserId" type = "text" required> <br><br>
	직업 <select name = "gameUserJob" required>
			<option value = "">선택하세요</option>
			<option >전사</option> value 안쓰면 option 안에 글자가 value역할을 한다!
			<option >성직자</option>
			<option value = "도적">도적</option>
		</select> 
	<br><br>
	레벨 <input name = "gameUserLevel" type = "number" required min = "1" step = "1" value = "1"> <br><br>
	돈 <input name = "gameUserMoney" type = "number" required min = "0"> <br><br>
	프로필 이미지 <input type = "file" name = "attach"> <br><br>
	<button>유저 등록</button>
</form>

<hr>

<h1>게임 유저 등록(사용자)</h1>

<form action = "add" method = "post" enctype = "multipart/form-data">
	ID <input name = "gameUserId" type = "text" required> <br><br>
	직업 <select name = "gameUserJob" required>
			<option value = "">선택하세요</option>
			<option >전사</option> value 안쓰면 option 안에 글자가 value역할을 한다!
			<option >성직자</option>
			<option value = "도적">도적</option>
		</select> 
	<br><br>
	프로필 이미지 <input type = "file" name = "attach"> <br><br>
	<button>유저 등록</button>
</form> -->

<form action="add" method="post" enctype="multipart/form-data" autocomplete="off">
	<div class="container w-400">
		<div class="cell center">
			<h1>게임 유저 등록</h1>
		</div>
		<div class="cell">
			<label>ID <span class = "red">*</span></label> <!-- label은 input과 세트로 쓰고, span은 아무때나 쓸 수 있다 -->
			<input type="text" name="gameUserId" class="field w-100" required>
		</div>
		<div class="cell">
			<label>직업 <span class = "red">*</span></label> 
			<select name="gameUserJob" required class="field w-100" required>
				<option value="">선택하세요</option>
				<option>전사</option>
				<option>성직자</option>
				<option value="도적">도적</option>
			</select>
		</div>
		
		<c:if test="${sessionScope.userLevel == '관리자'}">
		<div class="cell">
			<label>레벨</label> 
			<input type="number" name="gameUserLevel" class="field w-100" required min="1" step="1" value="1">
		</div>
		<div class="cell">
			<label>돈</label> 
			<input type="number" name="gameUserMoney" class="field w-100" required min="0">
		</div>
		</c:if>
		
		<div class="cell">
			<label>프로필 이미지</label> 
			<input type="file" name="attach" class="field w-100" accept=".png">
		</div>
		<div class="cell">
			<button type="submit" class="btn btn-positive w-100">등록하기</button>
		</div>
	</div>
</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>