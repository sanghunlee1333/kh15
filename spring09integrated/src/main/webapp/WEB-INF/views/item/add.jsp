<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h1>아이템 등록</h1>

<form action = "add" method="post">
	아이템 이름 <input name = "itemName" type="text" required> <br><br>
	유형 
	<select name = "itemType" required>
		<option value ="">선택하세요</option>
		<option value = "식품">식품</option>
		<option value = "잡화">잡화</option>
		<option value = "의류">의류</option>
		<option value = "장난감">장난감</option>
		<option value = "생필품">생필품</option>
		<option value = "스포츠">스포츠</option>
		<option value = "주방">주방</option>
		<option value = "전자제품">전자제품</option>
	</select> <br><br>
	가격 <input name = "itemPrice" type="number" required min = "0" values = "1000"> <br><br>
	할인율 <input name = "itemDiscountRate" type="number" min = "0.0" step = "0.1" max = "1.0" values = "0.0"> <br><br>
	수량 <input name = "itemQty" type="number" required min = "0" step = "1" values = "1"> <br><br>
	새벽배송 가능여부 
	<select name = "itemEarly" required>
		<option value ="">선택하세요</option>
		<option value = "Y">Y</option>
		<option value = "N">N</option>
	</select> <br><br>
	<button>아이템 등록</button>
</form>