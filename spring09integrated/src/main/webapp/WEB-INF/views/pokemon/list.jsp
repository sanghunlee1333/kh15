<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page = "/WEB-INF/views/template/header.jsp"></jsp:include>    

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h1>포켓몬 목록</h1>
<h2><a href = "add">신규 등록</a></h2> <!-- 상대경로 = add / 절대경로 = /pokemon/add -->

<table border="1" width="400">
	<thead>
		<tr>
			<th>이미지</th>
			<th>번호</th>
			<th>이름</th>
			<th>속성</th>
		</tr>
	</thead>
	<tbody align="center">
		<c:forEach var="pokemonDto" items="${list}">
		<tr>
			<td>
				<img src="image?pokemonNo=${pokemonDto.pokemonNo}" width="50" height="50">
			</td>
			<td>${pokemonDto.pokemonNo}</td>
			<td>
				<a href="detail?pokemonNo=${pokemonDto.pokemonNo}">
					${pokemonDto.pokemonName}
				</a>
			</td>
			<td>${pokemonDto.pokemonType}</td>
		</tr>
		</c:forEach>
	</tbody>
</table>

<jsp:include page = "/WEB-INF/views/template/footer.jsp"></jsp:include>