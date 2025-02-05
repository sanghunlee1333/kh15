<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page = "/WEB-INF/views/template/header.jsp"></jsp:include>    

<!-- <form action = "add" method="post"> -->
<!-- <form action = "add" method = "post" enctype = "multipart/form-data">
	* 나라명 <input name = "countryName" type = "text" required> <br><br>
	* 수도명 <input name = "countryCapital" type = "text" required> <br><br>
	* 인구수 <input name = "countryPopulation" type = "number" required min = "1"> <br><br>
	국기 이미지 <input type = "file" name = "attach" accept = ".png, .jpg"> <br><br>
	<button>나라 등록</button>
</form> -->

<form action = "add" method = "post" autocomplete = "off" enctype = "multipart/form-data">
        <div class = "container w-400">
            <div class = "cell center">
                <h1>국가 등록</h1>
            </div>
            <div class = "cell">
                <label>국가명</label>
                <input type = "text" name = "countryName" class = "field w-100" required>
            </div>
            <div class = "cell">
                <label>수도명</label>
                <input type = "text" name = "countryCapital" class = "field w-100" required>
            </div>
            <div class = "cell">
                <label>인구수</label>
                <input type = "number" name = "countryPopulation" class = "field w-100" required min = "1">
            </div>
            <div class = "cell">
                <label>국기 이미지</label>
                <input type = "file" name = "attach" class = "field w-100" accept = ".png, .jpg">
            </div>
            <div class = "cell mt-30">
                <button type = "submit" class = "btn btn-positive w-100">등록하기</button>
            </div>
        </div>
    </form>

<jsp:include page = "/WEB-INF/views/template/footer.jsp"></jsp:include>