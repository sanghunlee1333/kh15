<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page = "/WEB-INF/views/template/header.jsp"></jsp:include>    

<h1>유저 정보 수정</h1>

<form action = "edit" method = "post">
	<input type = "hidden" name = "gameUserNo" value = "${gameUserDto.gameUserNo}">
	아이디 <input type = "text" name = "gameUserId" value = "${gameUserDto.gameUserId}"> <br><br>
	직업 
	<select name = "gameUserJob">
		<option ${gameUserDto.gameUserJob == '전사' ? 'selected' : ''}>전사</option>
		<option ${gameUserDto.gameUserJob == '성직자' ? 'selected' : ''}>성직자</option>
		<option ${gameUserDto.gameUserJob == '도적' ? 'selected' : ''}>도적</option>
	</select>
	레벨 <input type = "number" name = "gameUserLevel" value = "${gameUserDto.gameUserLevel}"> <br><br>
	소지금 <input type = "number" name = "gameUserMoney" value = "${gameUserDto.gameUserMoney}"> <br><br>
	<button>정보수정</button>
</form>

<jsp:include page = "/WEB-INF/views/template/footer.jsp"></jsp:include>    