<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page = "/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>상품권 등록</h1>

<form action = "add" method = "post" enctype = "multipart/form-data">
	* 상품권명 <input name = "giftcardName" type = "text" required> <br><br>
	* 상품권 내용 <input name = "giftcardContent" type = "text" required> <br><br>
	* 충전 금액 <input name = "giftcardCharge" type = "number" required> <br><br>
	* 상품권 가격 <input name = "giftcardPrice" type = "number" required> <br><br>
	* 상품권 이미지 <input type = "file" name = "attach" accept = ".png, .jpg"> <br><br>
	<button>상품권 등록</button>
</form>

<jsp:include page = "/WEB-INF/views/template/footer.jsp"></jsp:include>