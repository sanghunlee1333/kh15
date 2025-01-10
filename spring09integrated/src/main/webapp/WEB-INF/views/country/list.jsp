<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page = "/WEB-INF/views/template/header.jsp"></jsp:include>    

<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- if는 단독으로 쓸때! -->
<c:if test = "${search == true}">
	<h1>나라 검색</h1>
</c:if>
<c:if test = "${search == false}">
	<h1>나라 목록</h1>
</c:if>

<h2><a href = "add">신규 등록</a></h2>

<!-- 검색창 - /country/list?column=국가명&keyword=한국-->
<form action = "list" method = "get"> <!-- get은 주소창으로 처리하는 방식 -->
	<select name = "column">
		<option ${column == '국가명' ? 'selected' : ''}>국가명</option>
		<option ${column == '수도명' ? 'selected' : ''}>수도명</option> <!-- equals로도 가능 -->
	</select>
	<input type = "text" name = "keyword" value = "${keyword}" required>
	<button>검색</button>
</form>

<!-- choose로 다른 when(if) - otherwise(else)와 겹치지 않게 범위를 지정해준다. -->
<c:choose>
	<c:when test = "${list.isEmpty()}">
		<h2>데이터가 존재하지 않습니다</h2>
	</c:when>
	<c:otherwise>
		<c:forEach var = "countryDto" items = "${list}">
			<h2>
				번호 : ${countryDto.countryNo},
				나라명 : ${countryDto.countryName},
				수도명 : ${countryDto.countryCapital},
				인구수 : ${countryDto.countryPopulation}명
			</h2>
		</c:forEach>
	</c:otherwise>
</c:choose>

<h1 align = "center">나라 테이블</h1>
<hr width = "400" align = "center">

<br>

<table border = "1" width = "400" align = "center">
	<thead>
		<tr>
			<th>번호</th>
			<th>나라명</th>
			<th>수도명</th>
			<th>인구수</th>
		</tr>
	</thead>
	<tbody align = "center">
		<c:choose>
			<c:when test="${list.isEmpty()}">
				<tr>
					<td colspan="4">데이터가 존재하지 않습니다</td> <!-- rowspan은 세로로 합치기 -->
				</tr>
			</c:when>
			<c:otherwise>
			<c:forEach var = "countryDto" items = "${list}">
				<tr>
					<td>${countryDto.countryNo}</td>
					<td>
						<a href = "detail?countryNo=${countryDto.countryNo}">
							${countryDto.countryName}
						</a>
					</td>
					<td>${countryDto.countryCapital}</td>
					<td align = "right">
						<fmt:formatNumber pattern="#,##0" 
							value = "${countryDto.countryPopulation}"></fmt:formatNumber>
					</td>
				</tr>
			</c:forEach>
			</c:otherwise>
		</c:choose>
	</tbody>
</table>

<jsp:include page = "/WEB-INF/views/template/footer.jsp"></jsp:include>    