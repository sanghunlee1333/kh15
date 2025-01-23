package com.kh.spring09.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring09.dao.StatusDao;

@Controller
@RequestMapping("/admin/status")
public class AdminStatusController {
	
	@Autowired
	private StatusDao statusDao;
	
	@RequestMapping("/pokemon")
	public String pokemon(Model model) {
		model.addAttribute("list", statusDao.pokemon());
		return "/WEB-INF/views/admin/status/pokemon.jsp";
	}
	
	@RequestMapping("/game-user")
	public String gameUser(Model model) {
		model.addAttribute("list", statusDao.gameUser());
		return "/WEB-INF/views/admin/status/game-user.jsp";
	}
	
	@RequestMapping("/member")
	public String member(Model model) {
		model.addAttribute("list", statusDao.member());
		return "/WEB-INF/views/admin/status/member.jsp";
	}

}
