<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<!-- Chart JS cdn -->
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script type="text/javascript">
	$(function () {
      loadChart("pokemon", ".pokemon-chart", "포켓몬 개체 수", "bar");
      loadChart("game-user", ".game-user-chart", "이용자 수", "bar");
      loadChart("board-write", ".board-write-chart", "게시글 수", "line");
      loadChart("member", ".member-chart", "회원 수");
      loadChart("member-join", ".member-join-chart", "가입자 수");

      //차트데이터를 불러오는 함수
      function loadChart(url, selector, name, type = "doughnut") {
        //페이지가 로딩되면 ajax 통신으로 포켓몬 통계정보를 불러와야한다
        $.ajax({
          url: "http://localhost:8080/rest/status/" + url,
          method: "get",
          //data: {},
          success: function (response) {
            //response는 key-value 세트 형태이므로 key와 value를 각각 분리
            var keys = [], values = [];
            for (var i = 0; i < response.length; i++) {
              keys.push(response[i].key);
              values.push(response[i].value);
            }

            //차트 생성
            createChart(selector, name, keys, values, type);
          },
        });
      }

      //차트를 그리는 함수
      //- selector : 차트를 그려야하는 canvas의 선택자
      //- type : 차트의 유형
      //- name : 차트 데이터 이름(범례)
      //- keys : 차트의 x축 항목명
      //- values : 차트에 표시될 데이터
      function createChart(selector, name, keys, values, type = "doughnut") { //type="doughnut" -> 디폴트 값(데이터가 없으면 이거다) 맨 뒤에 적어야함
        //차트 생성 코드
        var canvas = document.querySelector(selector);

        new Chart(canvas, {
          type: type, //bar, pie, doughnut, line 등 api 확인
          data: { //차트의 데이터
            //차트에 표시할 항목 이름(x축)
            labels: keys,

            //실제로 차트에 표시될 값 (여러개 설정 가능)
            datasets: [
              {
                label: name, //범례
                data: values, //수치
                borderWidth: 1 //테두리 두께(디자인 속성)
              },
            ]
          },
          options: { //차트의 옵션
            scales: {
              y: {
                beginAtZero: true
              }
            }
          }
        });
      }
    });
</script>

<div class="container w-800">
	<div class="cell center">
		<h1>홈페이지 데이터 현황</h1>
	</div>
	
	<div class = "cell">
		<h2>일반 데이터 현황</h2>
	</div>
	<div class="cell flex-box" style="flex-wrap: wrap;">
		<div class="w-33">
			<div class = "cell"><h3>포켓몬 현황</h3></div> <!-- 제목 -->
			<div class = "cell"><canvas class="pokemon-chart"></canvas></div> <!-- 차트 -->
			<div class = "cell"> <!-- 테이블 -->
				<table class = "table table-border table-stripe">
					<thead>
						<tr>
							<th>속성</th>
							<th>개체수</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var = "statusVO" items="${pokemonList}">
						<tr>
							<td>${statusVO.key}</td>
							<td>${statusVO.value}</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div class="w-33">
			<div class = "cell"><h3>게임유저 현황</h3></div> <!-- 제목 -->
			<div class = "cell"><canvas class="game-user-chart"></canvas></div> <!-- 차트 -->
			<div class = "cell"> <!-- 테이블 -->
				<table class = "table table-border table-stripe">
					<thead>
						<tr>
							<th>직업</th>
							<th>이용자수</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var = "statusVO" items="${gameUserList}">
						<tr>
							<td>${statusVO.key}</td>
							<td>${statusVO.value}</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	
	<div class = "cell">
		<h2>회원 현황</h2>
	</div>
	<div class="cell flex-box" style="flex-wrap: wrap;">
		<div class="w-33">
			<div class = "cell"><h3>등급별 유저수</h3></div> <!-- 제목 -->
			<div class = "cell"><canvas class="member-chart"></canvas></div> <!-- 차트 -->
			<div class = "cell"> <!-- 테이블 -->
				<table class = "table table-border table-stripe">
					<thead>
						<tr>
							<th>등급</th>
							<th>회원수</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var = "statusVO" items="${memberList}">
						<tr>
							<td>${statusVO.key}</td>
							<td>${statusVO.value}</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div> 
		</div>
		<div class="w-33">
			<div class = "cell"><h3>가입자 수</h3></div> <!-- 제목 -->
			<div class = "cell"><canvas class="member-join-chart"></canvas></div> <!-- 차트 -->
			<div class = "cell"> <!-- 테이블 -->
				<table class = "table table-border table-stripe">
					<thead>
						<tr>
							<th>기간</th>
							<th>가입자수</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var = "statusVO" items="${memberJoinList}">
						<tr>
							<td>${statusVO.key}</td>
							<td>${statusVO.value}</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	
	<div class = "cell">
		<h2>게시글 현황</h2>
	</div>
	<div class="cell flex-box" style="flex-wrap: wrap;">
		<div class="w-33">
			<div class = "cell"><h3>글 작성 수</h3></div> <!-- 제목 -->
			<div class = "cell"><canvas class="board-write-chart"></canvas></div> <!-- 차트 -->
			<div class = "cell"> <!-- 테이블 -->
				<table class = "table table-border table-stripe">
					<thead>
						<tr>
							<th>기간</th>
							<th>작성글 수</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var = "statusVO" items="${boardWriteList}">
						<tr>
							<td>${statusVO.key}</td>
							<td>${statusVO.value}</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div> 
		</div>
	</div>
		
</div>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>