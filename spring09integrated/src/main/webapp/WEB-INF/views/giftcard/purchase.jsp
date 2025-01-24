<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page = "/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>상품권 상세정보</h1>

<img src = "image?giftcardNo=${giftcardDto.giftcardNo}" width = "300">

<h2>${giftcardDto.giftcardName}</h2>

<p>${giftcardDto.giftcardCharge} 포인트 
(
	${giftcardDto.giftcardPrice} 원, 
	${giftcardDto.discountRate}% 할인
)
</p>

<!-- 구매를 진행하기 위한 Form -->
<form action = "purchase" method = "post">
	<input type = "hidden" name = "giftcardPurchaseTarget" value = "${giftcardDto.giftcardNo}">
	수량 <input type = "number" name = "giftcardPurchaseQty" value = "1" size = "5" min = "1" required>
	<button>구매하기</button>
</form>

<pre>${giftcardDto.giftcardContent}</pre>

<jsp:include page = "/WEB-INF/views/template/footer.jsp"></jsp:include>
    