<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>최종 테스트</h1>

<form action = "upload4" method = "post" 
						 enctype = "multipart/form-data"> 
	<input type = "text" name = "uploader"> <br><br>
	<input type = "file" name = "attach" accept = "image/*"> <br><br>
	<button>업로드</button> 
</form>