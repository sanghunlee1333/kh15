	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page = "/WEB-INF/views/template/header.jsp"></jsp:include>

<script type = "text/javascript">
	$(function(){
		$(".form-delete").submit(function(){
			var checkItems = $(".check-item:checked"); 
			if(checkItems.length == 0) {//만약에 체크된것이 없다면
				window.alert("항목을 먼저 선택해야 합니다");
				return false;
			}
			
			return window.confirm("정말 삭제하시겠습니까?");
		});
	});
</script>

<%-- 
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
<!-- 		<h2>데이터가 존재하지 않습니다</h2> -->
	</c:when>
	<c:otherwise>
		<c:forEach var = "countryDto" items = "${list}">
<!-- 			<h2> -->
				번호 : ${countryDto.countryNo},
				나라명 : ${countryDto.countryName},
				수도명 : ${countryDto.countryCapital},
				인구수 : ${countryDto.countryPopulation}명
<!-- 			</h2> -->
		</c:forEach>
	</c:otherwise>
</c:choose>

<h1>나라 테이블</h1>
<hr width = "400" align = "left">

<br>

<table border = "1" width = "400">
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
					<td align = "left">
						<img src = "flag?countryNo=${countryDto.countryNo}" width = "50" height = "50">
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
--%> 


<!--  -->


<!-- if는 단독으로 쓸때! -->
<div class = "container w-400">
	<c:if test = "${search == true}">
		<div class = "cell"><h1>나라 검색</h1></div>
	</c:if>
	<c:if test = "${search == false}">
		<div class = "cell center"><h1>나라 목록</h1></div>
	</c:if>

	<div class = "cell right">
		<a href = "add" class = "btn btn-neutral">신규 등록</a>
	</div>
	
	<!-- 검색창 - /country/list?column=국가명&keyword=한국-->
	<form action = "list" method = "get"> <!-- get은 주소창으로 처리하는 방식 -->
		<div class = "cell">
			<select name = "column" class = "field w-25">
				<option ${column == '국가명' ? 'selected' : ''}>국가명</option>
				<option ${column == '수도명' ? 'selected' : ''}>수도명</option> <!-- equals로도 가능 -->
			</select>
			<input type = "text" name = "keyword" value = "${keyword}" required class = "field w-50">
			<button class = "btn btn-neutral">검색</button>
		</div>
	</form>

<!-- 전체 삭제를 위해 테이블 전체를 감싸는 form 생성 -->
<form class = "form-delete" action = "deleteAll" method = "post">
	<div class = "cell">
		<div class = "cell center mb-30">
			<h1>나라 테이블</h1>
		</div>
		<div class = "cell right">
			<button type = "submit" class = "btn btn-negative">체크항목 삭제</button>
		</div>
		<table class = "table table-border table-stripe table-hover table-ellipsis">
			<thead>
				<tr>
					<th>
						<input type = "checkbox" class = "check-all">
					</th>
					<th>번호</th>
					<th>나라명</th>
					<th>수도명</th>
					<th>인구수</th>
				</tr>
			</thead>
			<tbody class = "center">
				<c:choose>
					<c:when test="${list.isEmpty()}">
						<tr>
							<td colspan="4">데이터가 존재하지 않습니다</td> <!-- rowspan은 세로로 합치기 -->
						</tr>
					</c:when>
					<c:otherwise>
					<c:forEach var = "countryDto" items = "${list}">
						<tr>
							<td>
								<input type = "checkbox" class = "check-item" name = "countryNo" value = "${countryDto.countryNo}">
							</td>
							<td>${countryDto.countryNo}</td>
							<td class = "left">
								<img src = "flag?countryNo=${countryDto.countryNo}" width = "50" height = "50">
								<a href = "detail?countryNo=${countryDto.countryNo}" class = "center">
									${countryDto.countryName}
								</a>
							</td>
							<td>${countryDto.countryCapital}</td>
							<td class = "right">
								<fmt:formatNumber pattern="#,##0" 
									value = "${countryDto.countryPopulation}">
								</fmt:formatNumber>
							</td>
						</tr>
					</c:forEach>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
	</div>
</form>
</div>


<jsp:include page = "/WEB-INF/views/template/footer.jsp"></jsp:include>    