<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page = "/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>회원 목록 및 검색</h1>

<c:if test="${search == true}">
	<h1>회원 검색</h1>
</c:if>
<c:if test="${search == false}">
	<h1>회원 목록</h1>
</c:if>

<!-- 테이블 -->
<table border="1" width="300">
	<thead>
		<tr>
			<th>아이디</th>
			<th>닉네임</th>
		</tr>
	</thead>
	<tbody align = "center">	
		<!-- choose로 다른 when(if) - otherwise(else)와 겹치지 않게 범위를 지정해준다. -->
		<c:choose>
			<c:when test="${list.isEmpty()}">				
				<tr height = "150">
					<td colspan="2">등록된 회원이 없습니다</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach var="memberDto" items="${list}">
					<tr>
						<td>${memberDto.memberId}</td>
						<td align = "left">
							<a href="detail?memberId=${memberDto.memberId}">
								${memberDto.memberNickname} 
							</a>
						</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</tbody>
</table>

<!-- 검색창 - /country/list?column=국가명&keyword=한국-->
<form action="list" method="get">
	<!-- get은 주소창으로 처리하는 방식 -->
	<select name="column">
		<option value = "member_id" ${param.column == 'member_no' ? 'selected' : ''}>아이디</option>
		<option value = "member_nickname" ${param.column == 'member_id' ? 'selected' : ''}>닉네임</option>
		<!-- equals로도 가능 -->
	</select> <input type="text" name="keyword" value="${param.keyword}">
	<button>검색</button>
</form>



<jsp:include page = "/WEB-INF/views/template/footer.jsp"></jsp:include>   