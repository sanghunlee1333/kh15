<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h1>포켓몬 등록</h1>

<form action = "add" method="post"> <!-- 메소드=포스트를 안써주면 뺑뻉 돈다  -->
	몬스터 이름 <input name = "pokemonName"> <br><br>
	몬스터 속성 <input name = "pokemonType"> <br><br>
	<button>몬스터 등록</button>
</form>