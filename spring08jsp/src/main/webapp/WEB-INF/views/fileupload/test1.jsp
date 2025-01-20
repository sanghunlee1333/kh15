<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>파일 업로드 테스트</h1>
<h2>(Q) GET방식으로 파일 전송이 가능할까?</h2>
<h2>(A) GET방식에서는 파일의 이름만 전송된다</h2>

<form action = "upload1" method = "get">
	<input type = "file" name = "attach">
	<button>업로드</button>
</form>