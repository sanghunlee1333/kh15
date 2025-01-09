<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h1>강의 등록</h1>

<form action = "add" method = "post">
		강의명 <input name = "lectureName" type="text" required><br></br>
		카테고리 <input name = "lectureCategory" type="text" required><br></br>
		수업시간 <input name = "lecturePeriod" type="number" required min = "30" step = "30" value = "30"><br></br>
		수강료 <input name = "lecturePrice" type="number" required min = "0" step = "1000"><br></br>
		수업유형 
		<select name = "lectureType" required>
			<option value ="">선택하세요</option>
			<option value = "온라인">온라인</option>
			<option value = "오프라인">오프라인</option>
			<option value = "혼합">혼합</option>
		</select>
		<br><br>
		<button>강의 등록</button>
</form>