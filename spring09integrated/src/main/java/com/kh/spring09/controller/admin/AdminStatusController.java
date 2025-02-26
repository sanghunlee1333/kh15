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
	
	@RequestMapping("/all")
	public String all(Model model) {
		model.addAttribute("pokemonList", statusDao.pokemon());
		model.addAttribute("gameUserList", statusDao.gameUser());
		model.addAttribute("memberList", statusDao.member());
		model.addAttribute("memberJoinList", statusDao.memberJoin());
		model.addAttribute("boardWriteList", statusDao.boardWrite());
		return "/WEB-INF/views/admin/status/all.jsp";
	}
	
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
	
	@RequestMapping("/member-join")
	public String memberJoin(Model model) {
		model.addAttribute("list", statusDao.memberJoin());
		return "/WEB-INF/views/admin/status/member-join.jsp";
	}
	
	@RequestMapping("/board-write")
	public String boardWrite(Model model) {
		model.addAttribute("list", statusDao.boardWrite());
		return "/WEB-INF/views/admin/status/board-write.jsp";
	}

}
