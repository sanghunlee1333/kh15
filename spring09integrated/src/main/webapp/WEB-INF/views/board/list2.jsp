<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<c:if test="${search == true}">
	<h1>글 검색</h1>
</c:if>
<c:if test="${search == false}">
	<h1>자유 게시판</h1>
</c:if>

<h2><a href="write">글 쓰기</a></h2>

<!-- 테이블 -->
<table border="1" width="800">
	<thead>
		<tr>
			<th>번호</th>
			<th width = "45%">제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
			<th>좋아요</th>
		</tr>
	</thead>
	<tbody align = "center">	
		<!-- choose로 다른 when(if) - otherwise(else)와 겹치지 않게 범위를 지정해준다. -->
		<c:choose>
			<c:when test="${list.isEmpty()}">				
				<tr height = "150">
					<td colspan="6">등록된 게시글이 없습니다</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach var="boardDto" items="${list}">
					<tr>
						<td>${boardDto.boardNo}</td>
						<td align = "left">
						<!-- 게시글 제목 -->
							<a href="detail?boardNo=${boardDto.boardNo}">${boardDto.boardTitle} </a>
							<!-- 댓글 표시 -->
							<c:if test = "${boardDto.boardReply > 0}">
								[${boardDto.boardReply}]
							</c:if>
						</td>
						<td>${boardDto.boardWriter}</td>
						<td>${boardDto.boardWtimeString}
					  <%-- ${boardDto.getBoardWtimeString()}  --%>
						</td>
						<td>${boardDto.boardRead}</td>
						<td>${boardDto.boardLike}</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</tbody>
</table>

<!-- 페이지 네이게이터 -->
<!-- 이전 : startBlock > 1 일 경우 출력 -->
<h3>
<c:if test = "${startBlock > 1}">
	<c:choose>
		<c:when test = "${search == true}">
			<a href = "list?column=${column}&keyword=${keyword}&page=${startBlock-1}&size=${size}">&lt;</a>
		</c:when>
		<c:otherwise>
			<a href = "list?page=${startBlock-1}&size=${size}">&lt;</a>
		</c:otherwise>
	</c:choose>
</c:if>

<!-- 숫자 -->
<%-- for(int i = 1; i <= 10; i++) {} --%>
<c:forEach var = "i" begin = "${startBlock}" end = "${finishBlock}" step = "1">
<c:choose>
	<c:when test = "${search == true}">
		<a href = "list?column=${column}&keyword=${keyword}&page=${i}&size=${size}">${i}(검색)</a>  
	</c:when>
	<c:otherwise>
		<a href = "list?page=${i}&size=${size}">${i}(목록)</a>
	</c:otherwise>
</c:choose>
</c:forEach>

<!-- 다음 : finishBlock < pageCount 일 경우 출력 -->
<c:if test = "${finishBlock < pageCount}">
	<c:choose>
		<c:when test = "${search == true}">
			<a href = "list?column=${column}&keyword=${keyword}&page=${finishBlock+1}&size=${size}">&gt;</a>
		</c:when>
		<c:otherwise>
			<a href = "list?page=${finishBlock+1}&size=${size}">&gt;</a>
		</c:otherwise>
	</c:choose>
</c:if>

</h3> 
<!-- html특수문자 -->

<!-- 검색창 - /country/list?column=국가명&keyword=한국-->
<form action="list" method="get">
	<!-- get은 주소창으로 처리하는 방식 -->
	<select name="column">
		<option value = "board_title" ${param.column == 'board_title' ? 'selected' : ''}>제목</option>
		<option value = "board_writer" ${param.column == 'board_writer' ? 'selected' : ''}>작성자</option>
		<!-- equals로도 가능 -->
	</select> <input type="text" name="keyword" value="${param.keyword}">
	<button>검색</button>
</form>


<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>