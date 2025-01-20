<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>파일 업로드 테스트</h1>
<h2>(Q) POST방식으로 파일 전송이 가능할까?</h2>
<h2>(A) POST방식도 기본적으로는 파일 이름만 전송된다!</h2>

<form action = "upload2" method = "post">
	<input type = "file" name = "attach">
	<button>업로드</button>
</form>