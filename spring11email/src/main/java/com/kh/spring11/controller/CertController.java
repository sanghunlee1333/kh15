package com.kh.spring11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring11.service.CertService;

@Controller
@RequestMapping("/cert")
public class CertController {
	
	@Autowired
	private CertService certService;
	
	@RequestMapping("/home")
	public String home() {
		return "/WEB-INF/views/home.jsp";
	}
	
	@PostMapping("/test1")
	public String test1(@RequestParam String email) {
		certService.sendCertEmail(email);
		return "redirect:test1-2?email=" + email;
	}
	
	@GetMapping("/test1-2")
	public String test1_2() {
		return "/WEB-INF/views/test1-2.jsp";
	}
	
}
