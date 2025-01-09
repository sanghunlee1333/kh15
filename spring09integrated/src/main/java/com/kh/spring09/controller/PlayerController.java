package com.kh.spring09.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring09.dao.PlayerDao;
import com.kh.spring09.dto.PlayerDto;

@Controller
@RequestMapping("/player")
public class PlayerController {

	@Autowired
	private PlayerDao playerDao;
	
	@GetMapping("/add")
	public String add() {
		return "/WEB-INF/views/player/add.jsp";
	}
	
	@PostMapping("/add")
	public String add2(@ModelAttribute PlayerDto playerDto) {
		playerDao.insert(playerDto);
		return "redirect:addFinish";
	}
	
	@RequestMapping("/addFinish")
	public String add3() {
		return "/WEB-INF/views/player/addFinish.jsp";
	}
}
