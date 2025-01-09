<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h1>휴대폰 등록</h1>

<form action = "add" method="post">
	휴대폰명 <input name = "phoneName" type = "text" required> <br><br>
	통신사 <input name = "phoneTelecom" type = "text" required> <br><br>
	가격 <input name = "phonePrice" type = "number" required min = "0"> <br><br>
	계약 
	<select name = "phoneContract" required>
		<option value ="">선택하세요</option>
		<option value = "24">24</option>
		<option value = "30">30</option>
		<option value = "36">36</option>
	</select>
	<br></br>
	<button>휴대폰 등록</button>
</form>