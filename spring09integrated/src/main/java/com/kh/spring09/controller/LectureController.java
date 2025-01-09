package com.kh.spring09.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring09.dao.LectureDao;
import com.kh.spring09.dto.LectureDto;

@Controller
@RequestMapping("/lecture")
public class LectureController {

	@Autowired
	private LectureDao lectureDao;
	
	@GetMapping("/add")
	public String add() {
		return "/WEB-INF/views/lecture/add.jsp";
	}
	
	@PostMapping("/add")
	public String add2(@ModelAttribute LectureDto lectureDto) {
		lectureDao.insert(lectureDto);
		return "redirect:addFinish";
	}
	
	@RequestMapping("/addFinish")
	public String add3() {
		return "/WEB-INF/views/lecture/addFinish.jsp";
	}
	
	@RequestMapping("/table")
	public String table() {
		return "/WEB-INF/views/lecture/table.jsp";
	}
	
}
