<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page = "/WEB-INF/views/template/header.jsp"></jsp:include>    
    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<h1>[${countryDto.countryName}] 국가 상세 정보</h1>

<table border="1" width="300">
	<tr>
		<th width="30%">번호</th>
		<td>${countryDto.countryNo}</td>
	</tr>
	<tr>
		<th>나라명</th>
		<td>${countryDto.countryName}</td>
	</tr>
	<tr>
		<th>수도명</th>
		<td>${countryDto.countryCapital}</td>
	</tr>
	<tr>
		<th>인구수</th>
		<td>
			<fmt:formatNumber value = "${countryDto.countryPopulation}" pattern = "#,##0">
			</fmt:formatNumber> 명
		</td>
	</tr>
</table>

<h2>
	<a href="add">신규등록</a> 
	<a href="list">목록보기</a> 
	<a href="edit?countryNo=${countryDto.countryNo}">수정하기</a> 
	<a href="delete?countryNo=${countryDto.countryNo}">삭제하기</a>
</h2>

<jsp:include page = "/WEB-INF/views/template/footer.jsp"></jsp:include>    