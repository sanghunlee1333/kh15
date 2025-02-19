package com.kh.spring10.restcontroller;

import java.time.LocalDate;
import java.util.Random;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin //비동기 통신 제한 해제 //아무나 다 들어올 수 있는 상태 
@CrossOrigin(origins = {"http://127.0.0.1:5500"})
@RestController
@RequestMapping("/test")
public class TestRestController {
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello Spring Boot!";
	}
	
	@GetMapping("/dice")
	public int dice() {
		Random r = new Random();
		return r.nextInt(6) + 1;
	}
	
	@GetMapping("/subway")
	public int subway(@RequestParam int birth) {
			
		int card = 500;
		int free = 0, child = 500, teen = 800, adult = 1400;
		
		int year = LocalDate.now().getYear();
		int age = year - birth + 1;
		
		int price; 
		if(age < 8 || age >= 65) {//영유아 or 어르신
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
		price += card;
		
		return price;
	}
}
