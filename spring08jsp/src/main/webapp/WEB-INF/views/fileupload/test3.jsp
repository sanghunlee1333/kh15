<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>파일 업로드 테스트</h1>
<h2>(Q) Multipart 방식으로 파일 전송하는 예제</h2>

<form action = "upload3" method = "post" 
						 enctype = "multipart/form-data"> 
	<input type = "text" name = "uploader"> <br><br>
	<input type = "file" name = "attach"> <br><br>
	<button>업로드</button>
</form>