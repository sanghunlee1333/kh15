package com.kh.spring12.aop;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.kh.spring12.error.TargetNotFoundException;

@RestControllerAdvice(annotations = {RestController.class})
public class ExceptionControllerAdvice {
	
	//앞으로 발생하는 TargetNotFoundException은 404로 변환하여 전송
	@ExceptionHandler(TargetNotFoundException.class)
	public ResponseEntity<String> notFound() {
		return ResponseEntity.notFound().build();
		//return ResponseEntity.status(404).build();
	}
	
	//나머지 예외는 간단한 메세지만 전송
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> error(Exception e) {
		e.printStackTrace(); //나에게
		return ResponseEntity.internalServerError().build(); //프론트엔드에게 
		//return ResponseEntity.status(500).build();
	}
}
