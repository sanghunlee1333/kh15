<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- form배우기
- 입력 양식을 의미
- 입력창(input, select, textarea)과 전송버튼(button)으로 구성
- form을 전송하면 입력창에 작성된 값을 이용해서 주소를 생성
- 폼에 action을 쓰면 전송할 목적지를 지정할 수 있음
 -->

<h1>폼(form) 배우기</h1>

<form action = "/pokemon/insert"> 
	포켓몬 이름 : <input name = "pokemonName"><br><br>
	포켓몬 속성 : <input name = "pokemonType"><br><br>
	<button>전송</button>
</form>
	
<!-- country 등록화면 구현 -->

<form action = "/country/add">
	<input name = "countryName" placeholder="국가명" type="text"><br></br>
	<input name = "countryCapital" placeholder="수도명" type="text"><br></br>
	<input name = "countryPopulation" placeholder="인구수" type="number"><br></br>
	<button>전송</button>
</form>