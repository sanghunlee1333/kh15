<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>여러 개의 파일 업로드하는 경우</h1>

<form action = "upload5" method = "post" 
						 enctype = "multipart/form-data"> 
	<input type = "text" name = "uploader"> <br><br>
	<input type = "file" name = "attach" accept = "image/*" multiple> <br><br>
	<button>업로드</button> 
</form>