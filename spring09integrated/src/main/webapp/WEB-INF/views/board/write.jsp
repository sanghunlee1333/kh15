<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page = "/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>게시글 등록</h1>

<form action = "write" method = "post">
	제목 <input type = "text" name = "boardTitle" size = "55" placeholder = "제목을 입력해주세요" required> <br><br>
	내용 <br>
	<%-- <input type = "text" name = "boardContent" size = "100%" style = "height : 500px" required>  --%> 
	<textarea name = "boardContent" required rows = "10" cols = "60"></textarea> <!-- 여러 줄을 입력하는 입력도구. 스페이스도 들어가니 참고! -->
	<br><br>
	<button>등록하기</button>
</form>