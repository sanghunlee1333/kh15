<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<div class = "container w-1000">
	<c:if test="${search == true}">
		<div class = "cell"><h1>글 검색</h1></div>
	</c:if>
	<c:if test="${search == false}">
		<div class = "cell"><h1>자유 게시판</h1></div>
	</c:if>

	<div class = "cell">
		<a href="write"><button class = "btn btn-neutral">글 쓰기</button></a>
	</div>
	
	<!-- 테이블 -->
	<div class = "cell">
		<table class = "table table-border table-stripe table-hover">
			<thead>
				<tr>
					<th>번호</th>
					<th class = "w-30">제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>조회수</th>
					<th>좋아요</th>
<!-- 					<th>그룹</th> -->
<!-- 					<th>상위글</th> -->
<!-- 					<th>차수</th> -->
				</tr>
			</thead>
			<tbody class = "center">	
				<!-- choose로 다른 when(if) - otherwise(else)와 겹치지 않게 범위를 지정해준다. -->
				<c:choose>
					<c:when test="${list.isEmpty()}">				
						<tr height = "150">
							<td colspan="6">등록된 게시글이 없습니다</td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach var="boardListViewDto" items="${list}">
							<tr>
								<td>${boardListViewDto.boardNo}</td>
								<td class = "left">
						
									<!--[멘션버전] 답글이라면 상위글 제목을 표시 -->
									<c:if test = "${boardListViewDto.targetNo > 0}">
										<a href = "detail?boardNo=${boardListViewDto.targetNo}">
											${boardListViewDto.targetTitle}
										</a>
									</c:if>
						
									<!-- 글의 차수(board_depth)에 따라 띄어쓰기 부여 -->
									<c:if test = "${boardListViewDto.boardDepth > 0}">
										<c:forEach var = "i" begin = "1" end = "${boardListViewDto.boardDepth}" step = "1">
											&nbsp;&nbsp;
										</c:forEach>
										<!-- → -->

										<img src="/images/reply.png" alt="Reply arrow" style="width: 15px; height: 15px;">
									</c:if>
							
									<!-- 게시글 제목 -->
									<a href="detail?boardNo=${boardListViewDto.boardNo}">
										${boardListViewDto.boardTitle} 
									</a>
							
									<!-- 댓글 표시 -->
									<c:if test="${boardListViewDto.boardReply > 0}">
										[${boardListViewDto.boardReply}]
									</c:if>
								</td>
								<td>
								<c:choose>
									<c:when test="${boardListViewDto.memberNickname == null}">
										(탈퇴한 사용자)
									</c:when>
									<c:otherwise>
										${boardListViewDto.memberNickname}
									</c:otherwise>
								</c:choose>
								</td>
								<td>${boardListViewDto.boardWtimeString}
					  		<%-- ${boardListViewDto.getBoardWtimeString()}  --%>
								</td>
								<td>${boardListViewDto.boardRead}</td>
								<td>${boardListViewDto.boardLike}</td>
<%-- 								<td>${boardListViewDto.boardGroup}</td> --%>
<%-- 								<td>${boardListViewDto.boardTarget}</td> --%>
<%-- 								<td>${boardListViewDto.boardDepth}</td> --%>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
	</div>


	<!-- 검색창 - /country/list?column=국가명&keyword=한국-->
	<form action="list" method="get">
		<!-- get은 주소창으로 처리하는 방식 -->
		<div class = "cell">
			<select name="column" class = "field">
				<option value = "board_title" ${param.column == 'board_title' ? 'selected' : ''}>제목</option>
				<option value = "board_writer" ${param.column == 'board_writer' ? 'selected' : ''}>작성자</option>
				<!-- equals로도 가능 -->
			</select> 
			<input type="text" name="keyword" value="${param.keyword}" class = "field w-25">
			<button class = "btn btn-neutral">검색</button>
		</div>
	</form>
</div>

<!--  페이지 네비게이터 -->
<jsp:include page = "/WEB-INF/views/template/pagination.jsp"></jsp:include>


<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>