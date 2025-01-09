<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h1>유저 등록</h1>

<form action = "add" method="post">
	ID <input name = "gameUserId" type = "text" required> <br><br>
	직업 <select name = "gameUserJob" required>
			<option value = "">선택하세요</option>
			<option >전사</option> <!-- value 안쓰면 option 안에 글자가 value역할을 한다! -->
			<option >성직자</option>
			<option value = "도적">도적</option>
		</select> 
	<br><br>
	레벨 <input name = "gameUserLevel" type = "number" required min = "1" step = "1" value = "1"> <br><br>
	돈 <input name = "gameUserMoney" type = "number" required min = "0"> <br><br>
	<button>유저 등록</button>
</form>