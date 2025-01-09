<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>전달된 포켓몬 정보</h1>

<h2>번호 : ${pokemonDto.pokemonNo}</h2> <!-- pokemonDto.getPokemonNo() -->
<h2>이름 : ${pokemonDto.pokemonName}</h2> <!-- pokemonDto.getPokemonName() -->
<h2>속성 : ${pokemonDto.pokemonType}</h2> <!-- pokemonDto.getPokemonType() -->