package com.kh.spring09.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring09.dao.MemberDao;
import com.kh.spring09.dto.BoardDto;
import com.kh.spring09.dto.MemberDto;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private MemberDao memberDao;

	@RequestMapping("/home")
	public String home() {
		return "/WEB-INF/views/admin/home.jsp";
	}

	@RequestMapping("/member/list")
	public String memberList(Model model, @RequestParam(required = false) String column,
			@RequestParam(required = false) String keyword) {
		List<MemberDto> memberList;
		if (column != null && keyword != null) {
			memberList = memberDao.selectList(column, keyword);
		} else {
			memberList = memberDao.selectList();
		}
		model.addAttribute("list", memberList);
		return "/WEB-INF/views/admin/member/list.jsp";
	}

	@RequestMapping("/member/detail")
	public String detail(@RequestParam String memberId, Model model) {
		MemberDto memberDto = memberDao.selectOne(memberId);
		model.addAttribute("memberDto", memberDto);
		
		return "/WEB-INF/views/admin/member/detail.jsp";
	}

	@GetMapping("/edit")
	public String edit(@RequestParam String memberId, Model model) {
		MemberDto memberDto = memberDao.selectOne(memberId);
		System.out.println(memberId);
		model.addAttribute("memberDto", memberDto);
		return "/WEB-INF/views/admin/member/edit.jsp";
	}

	@PostMapping("/edit")
	public String edit(@ModelAttribute MemberDto memberDto) {
		memberDao.update(memberDto);
		return "redirect:detail?memberId=" + memberDto.getMemberId();
	}
}
