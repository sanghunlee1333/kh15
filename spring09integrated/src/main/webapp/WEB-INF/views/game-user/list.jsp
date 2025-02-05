<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page = "/WEB-INF/views/template/header.jsp"></jsp:include>    

<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- 
<h1>유저 목록</h1>
<h2><a href = "add">신규 등록</a></h2>

<!-- 검색창 -->
<form action = "list" method = "get">
	<select name = "column">
		<option ${column == '아이디' ? 'selected' : ''}>아이디</option>
		<option ${column == '직업' ? 'selected' : ''}>직업</option>
	</select>
	<input type = "search" name = "keyword" value = "${keyword}" required> <!-- search는 검색창에 x로 검색어를 지울 수 있음 -->
	<button>검색</button>
</form>

<h1>유저 테이블</h1>
<hr width = "400" align = "left">

<br>

<table border = "1" width = "400">
	<thead>
		<tr>
			<th>아이디</th>
			<th>직업</th>
			<th>레벨</th>
			<th>소지금</th>
		</tr>
	</thead>
	<tbody align = "center">
		<c:forEach var = "gameUserDto" items = "${list}">
			<tr>
				<td>${gameUserDto.gameUserId}</td>
				<td>${gameUserDto.gameUserJob}</td>
				<td>${gameUserDto.gameUserLevel}</td>
				<td>${gameUserDto.gameUserMoney}</td>
				<td>
					<a href = "detail?gameUserNo=${gameUserDto.gameUserNo}">상세
					</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table> 
--%>

<!--  -->

<div class = "container w-500">
	<div class = "cell center">
		<h1>유저 목록</h1>
	</div>
	<div class = "cell">
		<a href = "add" class = "btn btn-neutral">신규 등록</a>
	</div>
	<!-- 검색창 -->
	<form action = "list" method = "get">
		<div class = "cell">
			<select name = "column" class = "field w-25">
				<option ${column == '아이디' ? 'selected' : ''}>아이디</option>
				<option ${column == '직업' ? 'selected' : ''}>직업</option>
			</select>
			<input type = "search" name = "keyword" value = "${keyword}" required class = "field w-50"> <!-- search는 검색창에 x로 검색어를 지울 수 있음 -->
			<button class = "btn btn-neutral">검색</button>
		</div>
	</form>

	<div class = "cell center">
		<h1>유저 테이블</h1>
	</div>
	<div class = "cell">
		<table class = "table table-border table-stripe table-hover">
			<thead>
				<tr>
					<th>아이디</th>
					<th>직업</th>
					<th>레벨</th>
					<th>소지금</th>
					<th>상세보기</th>
				</tr>
			</thead>
			<tbody class = "center">
				<c:forEach var = "gameUserDto" items = "${list}">
					<tr>
						<td>${gameUserDto.gameUserId}</td>
						<td>${gameUserDto.gameUserJob}</td>
						<td>${gameUserDto.gameUserLevel}</td>
						<td>${gameUserDto.gameUserMoney}</td>
						<td>
							<a href = "detail?gameUserNo=${gameUserDto.gameUserNo}">상세</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>

<jsp:include page = "/WEB-INF/views/template/footer.jsp"></jsp:include>    