<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page = "/WEB-INF/views/template/header.jsp"></jsp:include>    

<h1>[${pokemonDto.pokemonName}] 몬스터 정보</h1>

<!-- 동적 이미지 주소 (참고)헤더에는 정적 이미지 주소 사용했음 -->
<img src = "image?pokemonNo=${pokemonDto.pokemonNo}" width = "300">

<table border="1" width="300">
	<tr>
		<th width="30%">번호</th>
		<td>${pokemonDto.pokemonNo}</td>
	</tr>
	<tr>
		<th>이름</th>
		<td>${pokemonDto.pokemonName}</td>
	</tr>
	<tr>
		<th>속성</th>
		<td>${pokemonDto.pokemonType}</td>
	</tr>
</table>

<h2>
	<a href="add">신규등록</a> 
	<a href="list">목록보기</a> 
	<a href="edit?pokemonNo=${pokemonDto.pokemonNo}">수정하기</a> 
	<a href="delete?pokemonNo=${pokemonDto.pokemonNo}">삭제하기</a>
</h2>

<jsp:include page = "/WEB-INF/views/template/footer.jsp"></jsp:include>