<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h1>포켓몬 등록</h1>

<form action = "add" method="post">
	선수명 <input name = "playerName"> <br><br>
	종목 <input name = "playerEvent"> <br><br>
	구분 
	<select name = "playerType" required>
		<option value ="">선택하세요</option>
		<option value = "하계">하계</option>
		<option value = "동계">동계</option>
	</select>
	<br></br>
	금메달 개수 <input name = "playerGoldMedal" type = "number" required min = "0"> <br><br>
	은메달 개수 <input name = "playerSilverMedal" type = "number" required min = "0"> <br><br>
	동메달 개수 <input name = "playerBronzeMedal" type = "number" required min = "0"> <br><br>
	<button>선수 등록</button>
</form>