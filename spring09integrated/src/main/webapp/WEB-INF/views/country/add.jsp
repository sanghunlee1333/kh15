<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<script type="text/javascript">
	function checkCountryName() {
		var tag = document.querySelector("[name=countryName]");
		var regex = /^[가-힣]{1,15}$/
		var isValid = regex.test(tag.value)

		tag.classList.remove("success", "fail");
		tag.classList.add(isValid ? "success" : "fail");

		return isValid;

	}

	function checkCountryCapital() {
		var tag = document.querySelector("[name=countryCapital]");
		var isValid = tag.value.length > 0;

		tag.classList.remove("success", "fail");
		tag.classList.add(isValid ? "success" : "fail");

		return isValid;
	}

	function checkCountryPopulation() {
		var tag = document.querySelector("[name=countryPopulation]");
		var isValid = parseInt(tag.value) > 0;

		tag.classList.remove("success", "fail");
		tag.classList.add(isValid ? "success" : "fail");

		return isValid;
	}

	function checkForm() {

		var countryNameValid = checkCountryName();
		var countryCapitalValid = checkCountryCapital();
		var countryPopulationValid = checkCountryPopulation();
		return countryNameValid && countryCapitalValid && countryPopulationValid;

	}
	
	//(+추가) 입력창을 text로 두는 대신 숫자만 입력 가능하도록 구현
    function checkNumberInput() {
        var target = document.querySelector("[name=countryPopulation]");
        target.value = target.value.replace(/[^0-9]+/g, "");
    }
</script>

<!-- <form action = "add" method="post"> -->
<!-- <form action = "add" method = "post" enctype = "multipart/form-data">
	* 나라명 <input name = "countryName" type = "text" required> <br><br>
	* 수도명 <input name = "countryCapital" type = "text" required> <br><br>
	* 인구수 <input name = "countryPopulation" type = "number" required min = "1"> <br><br>
	국기 이미지 <input type = "file" name = "attach" accept = ".png, .jpg"> <br><br>
	<button>나라 등록</button>
</form> -->

<form action = "add" method = "post" autocomplete = "off" enctype = "multipart/form-data" onsubmit = "return checkForm();">
	<div class="container w-400">
		<div class="cell center">
			<h1>국가 등록</h1>
		</div>
		<div class="cell">
			<label>국가명</label>
			<input type="text" name="countryName" class="field w-100" onblur = "checkCountryName();">
			<div class = "success-feedback">올바른 형식입니다</div>
            <div class = "fail-feedback">한글 1 ~ 15자 내로 작성하세요</div>
		</div>
		<div class="cell">
			<label>수도명</label>
			<input type="text" name="countryCapital" class="field w-100" onblur = "checkCountryCapital();">
            <div class = "success-feedback"></div>
            <div class = "fail-feedback"></div>
		</div>
		<div class="cell">
			<label>인구수</label>
			<input type="text" inputmode="numeric" name="countryPopulation" class="field w-100" min = "1" 
				oninput = "checkNumberInput();"
				onblur = "checkCountryPopulation();">
            <div class = "success-feedback">올바른 형식입니다</div>
            <div class = "fail-feedback">인구수는 1보다 작을 수 없습니다</div>
		</div>
		<div class="cell">
			<label>국기 이미지</label> <input type="file" name="attach" class="field w-100" accept=".png, .jpg">
		</div>
		<div class="cell mt-30">
			<button type="submit" class="btn btn-positive w-100">
				<i class="fa-solid fa-plus"></i> 등록하기
            </button>
		</div>
	</div>
</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>