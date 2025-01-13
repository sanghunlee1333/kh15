package com.kh.spring09.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring09.dao.MemberDao;
import com.kh.spring09.dto.MemberDto;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberDao memberDao;

	// 사용자 입력 페이지
	@GetMapping("/join") // GET방식만 처리하는 매핑
	public String join() {
		return "/WEB-INF/views/member/join.jsp";
	}

	// 입력 처리
	@PostMapping("/join") // POST방식만 처리하는 매핑
	public String join(@ModelAttribute MemberDto memberDto) {
		memberDao.insert(memberDto);
		return "redirect:joinFinish"; // joinFinish으로 쫓아내는 코드(상대경로)
	}
 
	// 완료 안내
	@RequestMapping("/joinFinish") // 방식 무관
	public String joinFinish() {
		return "/WEB-INF/views/member/joinFinish.jsp";
	}


}