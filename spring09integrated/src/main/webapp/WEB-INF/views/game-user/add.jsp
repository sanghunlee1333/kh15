<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<script type="text/javascript">
	function checkGameUserLevelInput() {
		var target = document.querySelector("[name=gameUserLevel]");
		var convert = target.value.replace(/[^0-9]+/g, ""); //0~9가 아닌 것들은 제거
		convert = parseInt(convert); //안 바뀌어지면 NaN

		//if(convert == NaN) //불가능한 조건 -> 무한대 == 무한대(NaN == NaN)
		if (isNaN(convert) || convert < 1) { //NaN검사
			convert = 1;
		}
		target.value = convert;
	}

	function checkGameUserMoneyInput() {
		var target = document.querySelector("[name=gameUserMoney]");
		target.value = target.value.replace(/[^0-9]+/g, ""); //0~9가 아닌 것들은 제거
	}

	function checkGameUserIdInput() {
		var target = document.querySelector("[name=gameUserId]");
		var regex = /[^A-Za-z0-9가-힣ㄱ-ㅎㅏ-ㅣ]/g;
		target.value = target.value.replace(regex, "");
	}

	function checkGameUserId() {
		var target = document.querySelector("[name=gameUserId]");
		var regex = /^[A-Za-z0-9가-힣]{1,8}$/
		var isValid = regex.test(target.value)

		target.classList.remove("success", "fail");
		target.classList.add(isValid ? "success" : "fail");

		return isValid;
	}

	function checkGameUserJob() {
		var target = document.querySelector("[name=gameUserJob]");
		var isValid = target.value.length > 0;

		target.classList.remove("success", "fail");
		target.classList.add(isValid ? "success" : "fail");

		return isValid;
	}

	function checkGameUserLevel() {
		var target = document.querySelector("[name=gameUserLevel]");
		var number = parseInt(target.value);
		var isValid = !isNaN(number) && number >= 1 && number <= 100;

		target.classList.remove("success", "fail");
		target.classList.add(isValid ? "success" : "fail");

		return isValid;
	}

	function checkGameUserMoney() {
		var target = document.querySelector("[name=gameUserMoney]");
		var number = parseInt(target.value);
		var isValid = !isNaN(number) && number >= 0;

		target.classList.remove("success", "fail");
		target.classList.add(isValid ? "success" : "fail");

		return isValid;
	}

	function checkForm() {

		var valid1 = checkGameUserId();
		var valid2 = checkGameUserJob();
		var valid3 = checkGameUserLevel();
		var valid4 = checkGameUserMoney();
		return valid1 && valid2 && valid3 && valid4;

	}
</script>

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

<form action="add" method="post" autocomplete="off"
	enctype="multipart/form-data" onsubmit="return checkForm();">
	<div class="container w-400">
		<div class="cell center">
			<h1>게임 유저 등록</h1>
		</div>
		<div class="cell">
			<label>ID <span class="red">*</span></label>
			<!-- label은 input과 세트로 쓰고, span은 아무때나 쓸 수 있다 -->
			<input type="text" name="gameUserId" class="field w-100"
				oninput="checkGameUserIdInput();" onblur="checkGameUserId();">
			<div class="success-feedback">올바른 아이디입니다</div>
			<div class="fail-feedback">아이디 한글, 영어, 숫자 8글자 이내로 작성하세요</div>
		</div>
		<div class="cell">
			<label>직업 <span class="red">*</span></label> <select
				name="gameUserJob" class="field w-100" oninput="checkGameUserJob();">
				<option value="">선택</option>
				<option>전사</option>
				<option>성직자</option>
				<option value="도적">도적</option>
				<div class="success-feedback">직업 설정 완료</div>
				<div class="fail-feedback">직업은 반드시 선택해야 합니다</div>
			</select>
		</div>

		<c:if test="${sessionScope.userLevel == '관리자'}">
			<div class="cell">
				<label>레벨</label> <input type="text" inputmode="numeric"
					name="gameUserLevel" value="1" class="field w-100"
					oninput="checkGameUserLevelInput();" onblur="checkGameUserLevel();">
				<!-- numeric을 쓰면 소수 불가, 그리고 type이 text이기 때문에 min과 step? 속성을 못씀 -->
				<div class="success-feedback">레벨 설정 완료</div>
				<div class="fail-feedback">레벨은 1~100으로 설정하세요</div>
			</div>
			<div class="cell">
				<label>돈</label> <input type="text" inputmode="numeric"
					name="gameUserMoney" class="field w-100" value="0"
					oninput="checkGameUserMoneyInput();" onblur="checkGameUserMoney();">
				<div class="success-feedback">소지골드 설정 완료</div>
				<div class="fail-feedback">소지골드는 0이상 숫자로 설정하세요</div>
			</div>
		</c:if>

		<div class="cell">
			<label>프로필 이미지</label> <input type="file" name="attach"
				class="field w-100" accept=".png, .jpg">
		</div>
		<div class="cell">
			<button type="submit" class="btn btn-positive w-100">
				<i class="fa-solid fa-plus"></i> 등록하기
			</button>
		</div>
	</div>
</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>