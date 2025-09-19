package com.kh.spring03.controller;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//스프링의 제 1특징
//- 제어 반전(IoC, Inversion Of Control)
//- 직접 생성하지 않고(new) 생성해달라고 부탁해라

@RestController //요청 처리 도구로 등록
public class ParameterQuizController {
	
	//처리 가능한 주소 생성
	@RequestMapping("/cinema")
	public String cinema(@RequestParam int adult, @RequestParam int teen) {
		int adultPrice = 15000, teenPrice = 10000;
		int total = adult * adultPrice + teen * teenPrice;
		return "총 요금 : " + total;
	}
	
	//(추가) 만약에 adult나 teen 하나만 있다면?
	@RequestMapping("/cinema2") //주소는 오버로딩이 불가해서 새로 만들어야 함
	public String cinema2(
			@RequestParam(required = false, defaultValue = "0") int adult, //adult라는 변수로 값을 받을 것인데, 값이 없다면 0으로 설정할게
			@RequestParam(required = false, defaultValue = "0") int teen) {
		int adultPrice = 15000, teenPrice = 10000;
		int total = adult * adultPrice + teen * teenPrice;
		return "총 요금 : " + total;		
		
	}
		
	@RequestMapping("/coffee")
	public String coffee(
			@RequestParam(required = false, defaultValue = "0") int americano,
			@RequestParam(required = false, defaultValue = "0") int latte) {
		int amePrice = 2500, lattePrice = 3000;
		int total = americano * amePrice + latte * lattePrice;
		return "총 커피값 : " + total;
	}
	
	@RequestMapping("/score")
	public String score(
			@RequestParam String name, 
			@RequestParam int kor, 
			@RequestParam int eng, 
			@RequestParam int mat) {
		int total = kor + eng + mat;
		double average = total / 3.0d;
		
		//return "이름 : " + name + "\n총점 : " + total + "\n평균 : " + average; //줄 바꿈 불가 -> 브라우저 형식으로 인식함
		
		//(방식1) 브라우저에게 전달하면 html형식으로 인식. 그래서 html형식으로 보내줄 수 있음
		//return "이름 : " + name + "<br>총점 : " + total + "<br>평균 : " + average; 
		
		//(방식2) StringBuffer 이용
		StringBuffer buffer = new StringBuffer(); 
		buffer.append("이름 : " + name);
		buffer.append("<br>");
		buffer.append("총점 : " + total);
		buffer.append("<br>");
		buffer.append("평균 : " + average);
		return buffer.toString();		
	}
	
	@RequestMapping("/subway")
	public String subway(@RequestParam(required = false) String birth) {
		
		int birthValue = Integer.parseInt(birth);	
		int year = LocalDate.now().getYear();
		int age = year - birthValue + 1;
		
		int price;
		int free = 0, child = 500, teen = 800, adult = 1400;
				
		if(birth == null) {
			price = adult;
			return "나이 : 비공개, 총 요금 : " + price;
		}
		else if(age < 8 || age >= 65) {//영유아 or 어르신
			price = free;
		}
		else if (age <= 13) {//어린이
			price = child;
		}
		else if (age <= 19) {//청소년
			price = teen;
		}
		else {//성인
			price = adult;
		}
		return "나이 : " + age + "세, 총 요금 : " + price;
	}
	
	@RequestMapping("/sum")
	public String sum(
			@RequestParam int begin, 
			@RequestParam int end) {
		int total = 0;
		for(int i = begin; i <= end; i++) {
			total += i;
		}
		return Integer.toString(begin) + "부터 " + end + "까지의 합 : " + total;
	}
	
	//내 풀이
//	@RequestMapping("/pcroom")
//	public String pcroom (
//			@RequestParam String start, 
//			@RequestParam String finish){
//		int startTotal = Integer.parseInt(start.substring(0, 2)) * 60 +  Integer.parseInt(start.substring(3, 5));
//		int finishTotal = Integer.parseInt(finish.substring(0, 2)) * 60 +  Integer.parseInt(finish.substring(3, 5));
//		int total = finishTotal - startTotal;
//		int hour = total / 60;
//		int minute = total % 60;
//		int price = total / 60 * 1000;
//		return "총 이용 시간 : " + hour + "시간 " + minute + "분" + ", 총 요금 : " + price;
//	}
	
	//강사님 풀이
	@RequestMapping("/pcroom")
	public String pcroom (
			@RequestParam String start, 
			@RequestParam String finish){
		LocalDate today = LocalDate.now(); //LocalDate -> 연/월/일(날짜)
		LocalTime startTime = LocalTime.parse(start); //LocalTime -> 시/분/초/나노초(시간)
		LocalTime finishTime = LocalTime.parse(finish);
		
		LocalDateTime begin, end;
		if(startTime.isBefore(finishTime)) { //시작시각이 종료시각보다 이전이라면(당일)
			begin = LocalDateTime.of(today, startTime); //LocalDateTime -> 연/월/일/시/분/초/나노초(날짜+시간)
			end = LocalDateTime.of(today, finishTime);
		}
		else { //시작시각이 종료시각 이후라면(날 샜다면)
			begin = LocalDateTime.of(today.minusDays(1), startTime); //시작일이 어제
			end = LocalDateTime.of(today, finishTime);			
		}
		
		Duration duration = Duration.between(begin, end);
		
		long minutes = duration.toMinutes();
		int price = (int) (minutes * 1000 / 60d);
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("이용시간 : ");
		buffer.append(duration.toHoursPart());
		buffer.append("시간 ");
		buffer.append(duration.toMinutesPart());
		buffer.append("분");
		buffer.append("<br>");
		buffer.append("이용 요금 : ");
		buffer.append(price);
		buffer.append("원");
		return buffer.toString();
		
	
	}

}
