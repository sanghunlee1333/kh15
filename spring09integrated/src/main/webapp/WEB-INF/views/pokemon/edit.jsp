<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page = "/WEB-INF/views/template/header.jsp"></jsp:include>    

<h1>포켓몬 정보 수정</h1>

<!-- 수정에서 primary key를 전달하기 위해 input[type=hidden] 사용 -->

<form action ="edit" method = "post" enctype = "multipart/form-data">
	<input type = "hidden" name = "pokemonNo" value = "${pokemonDto.pokemonNo}">
	포켓몬 이름 <input type = "text" name = "pokemonName" value = "${pokemonDto.pokemonName}"> <br><br>
	포켓몬 속성 <input type = "text" name = "pokemonType" value = "${pokemonDto.pokemonType}"> <br><br>
	<!-- (중요) file 선택 창에는 value 설정이 불가능하다(보안상의 이유) -->
	포켓몬 이미지 <input type = "file" name = "attach"> 
	<small>* 미설정 시 현 상태가 유지됩니다</small>
	<br><br>
	<button>정보수정</button>
</form>

<jsp:include page = "/WEB-INF/views/template/footer.jsp"></jsp:include>