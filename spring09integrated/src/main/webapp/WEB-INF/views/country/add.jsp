<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h1>나라 등록</h1>

<form action = "add" method="post">
	나라명 <input name = "countryName" type = "text" required> <br><br>
	수도명 <input name = "countryCapital" type = "text" required> <br><br>
	인구수 <input name = "countryPopulation" type = "number" required min = "1"> <br><br>
	<button>나라 등록</button>
</form>