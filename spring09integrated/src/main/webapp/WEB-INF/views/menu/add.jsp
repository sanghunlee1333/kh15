<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h1>메뉴 등록</h1>

<form action = "add" method="post">
	메뉴명 <input name = "menuName" type = "text" required> <br><br>
	구분 
	<select name = "menuType" required>
		<option value ="">선택하세요</option>
		<option value = "음료">음료</option>
		<option value = "디저트">디저트</option>
		<option value = "아이스크림">아이스크림</option>
		<option value = "식사">식사</option>
		<option value = "케이크">케이크</option>
	</select>
	<br><br>
	가격 <input name = "menuPrice" type = "number" required min = "0"> <br><br>
	이벤트 
	<select name = "menuEvent" required>
		<option value ="">선택하세요</option>
		<option value = "Y">Y</option>
		<option value = "N">N</option>
	</select>
	<br><br>
	<button>메뉴 등록</button>
</form>