<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>파일 업로드 테스트</h1>
<h2>(Q) Multipart 방식으로 파일 전송하는 예제</h2>

<form action = "upload3" method = "post" 
						 enctype = "multipart/form-data"> 
	<input type = "text" name = "uploader"> <br><br>
	<!-- 
		파일 선택창에 accept를 적으면 선택 가능한 유형을 정의할 수 있다 
		[1] 확장자로 유형을 알려주는 방법 (.png, .gif, .jpg)
		[2] MIME-TYPE을 지정하는 방법 (image/png 또는 image/*)
	-->
<!-- <input type = "file" name = "attach" accept = ".png, .gif, .jpg"> <br><br> -->
	<input type = "file" name = "attach" accept = "image/*"> <br><br>
	<button>업로드</button> 
</form>