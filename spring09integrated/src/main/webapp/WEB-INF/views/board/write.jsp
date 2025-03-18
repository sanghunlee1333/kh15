<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%--
	이 페이지로 올 수 있는 방법
	1. 목록에서 '글쓰기'를 누르는 방법
	2. 상세에서 '글쓰기'를 누르는 방법
	3. 상세에서 '답글쓰기'를 누르는 방법 (boardTarget 파라미터 존재)
	- 이 경우는 글 등록 처리 페이지로 boardTarget을 전송해야 한다
	- 조건부로 input[type=hidden] 사용

--%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

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
<script src="${pageContext.request.contextPath}/js/summernote-custom.js"></script>

<%-- <form action = "write" method = "post">
	<c:if test = "${param.boardTarget != null}">
		<input type = "hidden" name = "boardTarget" value = "${param.boardTarget}">
	</c:if>
	제목 <input type = "text" name = "boardTitle" size = "55" placeholder = "제목을 입력해주세요" required> <br><br>
	내용 <br>
	<input type = "text" name = "boardContent" size = "100%" style = "height : 500px" required>  
	<textarea name = "boardContent" required rows = "10" cols = "60"></textarea> <!-- 여러 줄을 입력하는 입력도구. 스페이스도 들어가니 참고! -->
	<br><br>
	<button>등록하기</button>
</form> --%>

<form action="write" method="post" autocomplete="off" class = "form-check">
	<c:if test="${param.boardTarget != null}">
		<input type="hidden" name="boardTarget" value="${param.boardTarget}" class="field w-100">
	</c:if>
	
	<div class="container w-800">
		<div class = "cell center">
            <h1>게시글 작성</h1>
        </div>
		<div class="cell">
			<label>제목 <span class = "red">*</span></label>
			<input type="text" name="boardTitle" placeholder="제목을 입력해주세요" class="field w-100">
		</div>
		<div class="cell">
			<label>내용 <span class = "red">*</span></label>
			<textarea name="boardContent" rows = "10" class="field w-100"></textarea>
		</div>
		<div class="cell right">
			<a href = "list" class = "btn btn-neutral">목록보기</a>
			<button type="submit" class="btn btn-positive">등록하기</button>
		</div>
	</div>
</form>

<jsp:include page = "/WEB-INF/views/template/footer.jsp"></jsp:include>