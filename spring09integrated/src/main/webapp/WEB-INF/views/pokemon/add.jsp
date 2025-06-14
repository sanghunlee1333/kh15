<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<!-- head가 없으므로 상단에 배치 -->
<script type="text/javascript">
function checkPokemonName() {
    var tag = document.querySelector("[name=pokemonName]");

    var regex = /^[가-힣]{1,10}$/;
    var isValid = regex.test(tag.value);

    tag.classList.remove("success", "fail");
    tag.classList.add(isValid ? "success" : "fail");
    
    return isValid;
}
function checkPokemonType() {
    var tag = document.querySelector("[name=pokemonType]");

    //var regex = /^.+$/;
    var isValid = tag.value.length > 0;

    tag.classList.remove("success", "fail");
    tag.classList.add(isValid ? "success" : "fail");

    return isValid;
}

//폼 검사 함수 - 기존 입력창 검사를 재활용
function checkForm() {
    var nameValid = checkPokemonName();
    var typeValid = checkPokemonType();
    return nameValid && typeValid;
}
</script>

<!-- <form action = "add" method="post"> 메소드=포스트를 안써주면 뺑뻉 돈다  -->
<!-- <form action = "add" method = "post" enctype = "multipart/form-data">
	몬스터 이름 <input name = "pokemonName"> <br><br>
	몬스터 속성 <input name = "pokemonType"> <br><br>
	몬스터 이미지 <input type = "file" name = "attach"> <br><br>
	<button>몬스터 등록</button>
</form>
 -->
 
<form action="add" method="post" autocomplete="off" enctype="multipart/form-data">
	<div class="container w-300">
		<div class="cell center">
			<h1>포켓몬 등록</h1>
		</div>
		<div class="cell">
			<label>포켓몬 이름</label> 
			<input type="text" class="field w-100" name="pokemonName" placeholder="(ex) 피카츄" onblur="checkPokemonName();">
            <div class="success-feedback">올바른 형식입니다</div>
            <div class="fail-feedback">몬스터 이름을 한글로 작성하세요</div>
		</div>
		<div class="cell">
			<label>포켓몬 속성</label> 
			<select name="pokemonType" required class="field w-100" oninput="checkPokemonType();">
                 <!-- onblur 안됨 -->
                 <option value="">선택하세요</option>
                 <option>불</option>
                 <option>물</option>
                 <option>땅</option>
                 <option>바람</option>
                 <option>전기</option>
                 <option>곤충</option>
                 <option>독</option>
                 <option>무속성</option>
             </select>
             <div class="fail-feedback">속성은 반드시 선택해야 합니다</div>
		</div>
		<div class="cell">
			<label>포켓몬 이미지</label> 
			<input type = "file" name = "attach" class = "field w-100" accept = ".png, .jpg">  	
		</div>
		<div class="cell mt-30">
                <button type="submit" class="btn btn-positive w-100">
                    <i class="fa-solid fa-plus"></i> 등록하기
                </button>
		</div>
	</div>
</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>

<!--  
JSP에서 POST와 GET은 데이터를 서버로 전송하는 두 가지 주요 방식

GET 방식
GET 방식은 주소에 데이터를 추가하여 전달하는 방식
URL의 쿼리 문자열에 데이터가 포함되어 전송
보안상 취약점이 있고 데이터 전송 길이에 제한이 있음
상대적으로 빠른 전송 방식
주로 서버에서 데이터를 가져올 때 사용

POST 방식
POST 방식은 데이터를 쿼리 문자열과는 별도로 첨부하여 전달하는 방식
요청 헤더에 데이터를 포함시켜 전송
보안성이 높고 데이터 전송 길이에 제한이 없음
GET 방식보다 상대적으로 느린 전송 방식
주로 서버의 데이터 값이나 상태를 변경할 때 사용

주요 차이점
데이터 전송 방식: GET은 URL에 데이터를 포함, POST는 HTTP body에 데이터를 포함
보안: POST가 GET보다 더 안전
캐시: GET 요청은 캐시될 수 있지만, POST는 일반적으로 캐시되지 않음
브라우저 기록: GET 요청은 브라우저 히스토리에 남지만, POST는 남지 않음
데이터 길이 제한: GET은 URL 길이 제한으로 인해 데이터 길이에 제한이 있지만, POST는 제한이 없음
-->