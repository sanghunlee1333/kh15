package com.kh.spring09.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring09.dao.MemberDao;
import com.kh.spring09.dto.MemberDto;

import jakarta.servlet.http.HttpSession;

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
	@RequestMapping("/joinFinish") // join-finish도 가능. 다만 주소에는 대문자를 쓸수 있는곳이 있고 안되는 곳이 있음. http://localhost:8080 // 여기에는 대소문자 구분이 안됨을 알아야함!
	public String joinFinish() {
		return "/WEB-INF/views/member/joinFinish.jsp";
	}

	// 로그인 판정

	@GetMapping("/login")
	public String login() {
		return "/WEB-INF/views/member/login.jsp";
	}
	
	//HttpSession 추가
	//- 사용자 별로 무언가 다른 정보를 기록해야 할 필요가 있을 때 사용
	//- Model처럼 선언만 하면 자동으로 스프링이 제공해줌
	//- 데이터 추가 : session.setAttribute("key", value);
	//- 데이터 추출 : session.getAttribute("key");
	//- 데이터 제거 : session.removeAttribute("key");
	//- 목표 : 로그인 성공 시 이 회원의 정보를 세션에 저장 (PK)
	@PostMapping("/login")
	public String login(@ModelAttribute MemberDto memberDto,
						HttpSession session) { // 사용자가 입력한 정보 //아이디와 비밀번호를 String으로 받을지, Dto로 받을지 선택의 문제
		MemberDto findDto = memberDao.selectOne(memberDto.getMemberId()); // 데이터베이스에 있는 정보 - findDto
		// 아이디가 없으면 findDto는 null이다
		if (findDto == null) {
			return "redirect:login?error"; // 로그인페이지로 쫒아낸다 //GET의 login으로 리다이렉트된다. 원래 리다이렉트는 get밖에 안되긴 함
		}
		// 아이디가 있으면 비밀번호 검사를 진행
		System.out.println(memberDto);
		System.out.println(findDto);
		boolean isValid = findDto.getMemberPw().equals(memberDto.getMemberPw());
		if (isValid) {// 로그인 성공 시
			
			//(+추가)세션에 userId란 이름으로 사용자의 ID를 저장
			session.setAttribute("userId", findDto.getMemberId()); 
			
			return "redirect:/";
		} else {// 비밀번호 다름
			return "redirect:login";// 로그인 페이지로 쫓아낸다
		}
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("userId");
		//session.invalidate(); //세션 소멸 명령
		return "redirect:/";
	}
	
	//마이페이지(내정보) 매핑
	//- 현재 로그인한 회원의 모든 정보가 화면에 출력(단, 비밀번호 제외)
	//- HttpSession에 있는 아이디를 꺼내 회원의 모든 정보를 조회
	@RequestMapping("/mypage")
	public String mypage(HttpSession session, Model model) {
		String userId = (String) session.getAttribute("userId"); //내 아이디 추출
		MemberDto memberDto = memberDao.selectOne(userId); //내 정보 획득
		model.addAttribute("memberDto", memberDto);
		return "/WEB-INF/views/member/mypage.jsp";
	}
	
	@GetMapping("/password")
	public String password() {
		return "/WEB-INF/views/member/password.jsp";
	}
	
	@PostMapping("/password")
	public String password(@RequestParam String currentPw, @RequestParam String newPw) {
		if(!currentPw.equals(newPw)) {
			String regex = "^([A-Z]+)([a-z]+)([0-9]+)([!@#$]+)[A-Za-z0-9!@#$]{8,16}$";
			if(newPw.matches(regex)) {
				MemberDto memberDto = new MemberDto();
				memberDto.setMemberPw(newPw);
				return "redirect:mypage";
			}
			else return "redirect:password?error";
		}
		else return "redirect:password?error";
	}

	
}