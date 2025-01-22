<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page = "/WEB-INF/views/template/header.jsp"></jsp:include>    

<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    
<h1>[${gameUserDto.gameUserId}] 유저 정보</h1>

<img src = "profile?gameUserNo=${gameUserDto.gameUserNo}" width = "300">

<table border="1" width="300">
	<tr>
		<th width="30%">번호</th>
		<td>${gameUserDto.gameUserNo}</td>
	</tr>
	<tr>
		<th>아이디</th>
		<td>${gameUserDto.gameUserId}</td>
	</tr>
	<tr>
		<th>직업</th>
		<td>${gameUserDto.gameUserJob}</td>
	</tr>
	<tr>
		<th>레벨</th>
		<td>${gameUserDto.gameUserLevel}</td>
	</tr>
	<tr>
		<th>소지금</th>
		<td>
			<fmt:formatNumber value = "${gameUserDto.gameUserMoney}" pattern = "#,##0">
			</fmt:formatNumber>	
		</td>
	</tr>
</table>

<h2>
	<a href="add">신규등록</a> 
	<a href="list">목록보기</a> 
	<a href="edit?gameUserNo=${gameUserDto.gameUserNo}">수정하기</a> 
	<a href="delete?gameUserNo=${gameUserDto.gameUserNo}">삭제하기</a>
</h2>
<h2>
	<a href="levelup?gameUserNo=${gameUserDto.gameUserNo}">레벨업</a>
</h2>

<jsp:include page = "/WEB-INF/views/template/footer.jsp"></jsp:include>    