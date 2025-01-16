<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page = "/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>${boardDto.boardTitle}</h1>
<div>
	${boardDto.boardWriter}<br>
	${boardDto.boardWtime}
	조회 ${boardDto.boardRead}
</div>
<hr>

<div style = "min-height:200px">
	<pre>${boardDto.boardContent}</pre></div>
<hr>
<div>
	좋아요 ${boardDto.boardLike}
	댓글 ${boardDto.boardReply}
</div>

<div>
	<a href="write">글쓰기</a>
	
	<!-- 소유자일 경우에만 수정과 삭제 표시 -->
	<c:if test = "${sessionScope.userId != null}"> <!-- 탈퇴해서 작성자가 null인상태와 비로그인 상태의 null도 소유자로 판단하게 되므로 이 경우도 안되게 처럼 -->
		<c:if test = "${sessionScope.userId == boardDto.boardWriter}">
			<a href="edit?boardNo=${boardDto.boardNo}">수정</a> 
			<a href="delete?boardNo=${boardDto.boardNo}">삭제</a>
		</c:if>
	</c:if>
	
	<a href="list">목록</a>
</div>

<jsp:include page = "/WEB-INF/views/template/footer.jsp"></jsp:include>