package com.kh.spring09.aop;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.kh.spring09.error.NoPermissionException;
import com.kh.spring09.error.TargetNotFoundException;

@ControllerAdvice(annotations = {Controller.class})
public class ErrorExceptionControllerAdvice {

	//@ExceptionHandler를 만들어서 컨트롤러처럼 구성하면
	//해당 예외 발생 시 지정한 작업이 자동으로 실행된다
	//매개변수에 예외 객체를 선언하면 해당 예외 정보가 자동으로 들어온다
	
	@ExceptionHandler(NoPermissionException.class)
	public String noPermission(NoPermissionException e, Model model) { //Exception e도 가능(업캐스팅)
		model.addAttribute("message", e.getMessage());
		return "/WEB-INF/views/error/no-permission.jsp";
	}
	
//	@ExceptionHandler(TargetNotFoundException.class)
//	public ResponseEntity<String> notFound(TargetNotFoundException e) {
//		//return ResponseEntity.notFound().build(); 
//		return ResponseEntity.status(404).build(); //위와 같은 코드
//	}
	
	@ExceptionHandler(TargetNotFoundException.class)
	public String notFound(TargetNotFoundException e, Model model) {
		model.addAttribute("message", e.getMessage());
		return "/WEB-INF/views/error/notfound.jsp";
	}
}
