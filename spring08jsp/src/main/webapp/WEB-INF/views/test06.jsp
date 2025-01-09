<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>선수 등록 화면</h1>
<form action = "/player/add">
	선수명 <input name = "playerName" type="text"><br></br>
	종목 <input name = "playerEvent" type="text"><br></br>
	구분	
	<!-- 
		참고 : 이름이랑 값이 같은 경우는 값을 생략할 수 있다
		checked / selected / required / readonly / disabled, ...
	 -->

<!-- 방법1 -->
<!-- 	<input name = "playerType" type = "radio" value = "하계" checked> 하계 -->
<!-- 	<input name = "playerType" type = "radio" value = "동계"> 동계 -->

<!-- 방법2 -->
	<select name = "playerType">
		<option value = "하계">하계</option>
		<option value = "동계">동계</option>
	</select>

	<br></br>
	
	금메달 <input name = "playerGoldMedal" type="number"><br></br>
	은메달 <input name = "playerSilverMedal" type="number"><br></br>
	동메달 <input name = "playerBronzeMedal" type="number"><br></br>
	<button>선수 등록</button>
</form>
		
	<br><br>

<h1>강의 등록 화면</h1>	
	<form action = "/lecture/add">
		강의명 <input name = "lectureName" type="text" required><br></br>
		카테고리 <input name = "lectureCategory" type="text" required><br></br>
		수업시간 <input name = "lecturePeriod" type="number" required min = "30" step = "30" value = "30"><br></br>
		수강료 <input name = "lecturePrice" type="number" required min = "0" step = "1000"><br></br>
		수업유형 
		<select name = "lectureType" required>
			<option value = "">선택하세요</option>
			<option value = "온라인">온라인</option>
			<option value = "오프라인">오프라인</option>
			<option value = "혼합">혼합</option>
		</select>
		<!-- select와 radio의 결정적 차이는 미입력 항목에 대한 차이 -->
		<br></br>
		<button>강의 등록</button>
	</form>
	