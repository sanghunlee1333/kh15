package com.kh.spring08.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jsp")
public class JspViewController {

	@RequestMapping("/test01")
	public String test01() {
		return "/WEB-INF/views/test01.jsp";
	}
	
}
