<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page = "/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>상품권 등록</h1>

<form action = "add" method = "post" enctype = "multipart/form-data">
	* 상품권명 <input name = "giftcardName" type = "text" required> <br><br>
	* 상세설명 <br>
	<textarea name = "giftcardContent" required rows = "4" cols = "50"></textarea> <br><br>
	* 충전포인트 <input name = "giftcardCharge" type = "number" required> <br><br>
	* 판매금액 <input name = "giftcardPrice" type = "number" required> <br><br>
	* 상품권 이미지 <input type = "file" name = "attach" accept = ".png, .jpg" required> <br><br>
	<button>상품권 등록</button>
</form>

<c:if test = "${param.error != null}">
	<h2>첨부파일을 반드시 보내야 합니다</h2>
</c:if>

<jsp:include page = "/WEB-INF/views/template/footer.jsp"></jsp:include>