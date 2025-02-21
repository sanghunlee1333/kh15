<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<jsp:include page = "/WEB-INF/views/template/header.jsp"></jsp:include>

<!-- summernote cdn -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.9.0/dist/summernote-lite.min.css" rel="stylesheet">
 <style>
 	.note-editor {
 		border: 1px solid #636e72 !important;
 	}
    .note-editable {
    	background-color: white !important;
    }
</style>
<script src="https://cdn.jsdelivr.net/npm/summernote@0.9.0/dist/summernote-lite.min.js"></script>
<script src="/js/summernote-custom.js"></script>

<h1>글 수정</h1>

<form action = "edit" method = "post">
	<input type="hidden" name="boardNo" value="${boardDto.boardNo}">
	제목 <input type = "text" name = "boardTitle" size = "55" value = "${boardDto.boardTitle}" required> <br><br>
	내용 <br>
	<!--  textared는 value가 없고 태그 사이에 입력값을 적는다(여러줄이라서) -->
	<textarea name = "boardContent" required rows = "10" cols = "60">${boardDto.boardContent}</textarea> <!-- 띄어쓰기 들어가면 안됨 -->
	<br><br>
	<button>수정하기</button>
</form>

<jsp:include page = "/WEB-INF/views/template/footer.jsp"></jsp:include>