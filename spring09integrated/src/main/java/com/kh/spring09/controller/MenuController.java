package com.kh.spring09.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring09.dao.MenuDao;
import com.kh.spring09.dto.MenuDto;

@Controller
@RequestMapping("/menu")
public class MenuController {

	@Autowired
	private MenuDao menuDao;
	
	@GetMapping("/add")
	public String add() {
		return "/WEB-INF/views/menu/add.jsp";
	}
	
	@PostMapping("/add")
	public String add2(@ModelAttribute MenuDto menuDto) {
		menuDao.insert(menuDto);
		return "redirect:addFinish";
	}
	
	@RequestMapping("/addFinish")
	public String add3() {
		return "/WEB-INF/views/menu/addFinish.jsp";
	}
}
