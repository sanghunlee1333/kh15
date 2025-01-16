<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page = "/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>글을 정말로 삭제하시겠습니까?</h1>

<form action = "delete" method="post">
	<input type = "hidden" name="boardNo" value="${boardNo}" required>
	<button >삭제</button>
</form>

<a href="detail?boardNo=${boardNo}">취소</a>

<jsp:include page = "/WEB-INF/views/template/footer.jsp"></jsp:include>