<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"%>


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

<!-- 데이터 표시 영역 -->
<c:forEach var = "gameUserDto" items = "${list}">
	<h2>
		아이디 : ${gameUserDto.gameUserId},
		직업 : ${gameUserDto.gameUserJob},
		레벨 : ${gameUserDto.gameUserLevel},
		소지금 : ${gameUserDto.gameUserMoney}
	</h2>
</c:forEach>

<h1 align = "center">유저 테이블</h1>
<hr width = "400" align = "center">

<br>

<table border = "1" width = "400" align = "center">
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
			</tr>
		</c:forEach>
	</tbody>
</table>