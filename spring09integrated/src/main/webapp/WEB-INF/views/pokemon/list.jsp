<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h1>포켓몬 목록</h1>
<h2><a href = "add">신규 등록</a></h2> <!-- 상대경로 = add / 절대경로 = /pokemon/add -->

<c:forEach var = "pokemonDto" items = "${list}">
	<h2>
		번호 : ${pokemonDto.pokemonNo} ,
		이름 : ${pokemonDto.pokemonName} ,
		속성 : ${pokemonDto.pokemonType} 
	</h2>
</c:forEach>