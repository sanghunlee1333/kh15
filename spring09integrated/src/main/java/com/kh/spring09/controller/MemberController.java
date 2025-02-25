package com.kh.spring09.controller;


import java.io.IOException;

import javax.naming.NoPermissionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring09.dao.CertDao;
import com.kh.spring09.dao.MemberDao;
import com.kh.spring09.dao.PurchaseHistoryDao;
import com.kh.spring09.dto.CertDto;
import com.kh.spring09.dto.MemberDto;
import com.kh.spring09.error.TargetNotFoundException;
import com.kh.spring09.service.EmailService;

import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private PurchaseHistoryDao purchaseHistoryDao;
	
	@Autowired
	private CertDao certDao;
	
	// 회원가입 매핑
	@GetMapping("/join") // GET방식만 처리하는 매핑
	public String join() {
		return "/WEB-INF/views/member/join.jsp";
	}
	
	@Autowired
	private EmailService emailService;

	// 입력 처리
	@PostMapping("/join") // POST방식만 처리하는 매핑
	public String join(@ModelAttribute MemberDto memberDto, @RequestParam String certNumber) throws NoPermissionException, MessagingException, IOException {
		//이메일과 인증번호를 이용한 이메일 진위여부 검사
		CertDto certDto = certDao.selectOne(memberDto.getMemberEmail());
		if(certDto == null) { //인증메일 발송내역 자체가 없을 때
			throw new NoPermissionException("비정상적인 회원가입");
		}
		if(certNumber.equals(certDto.getCertNumber()) == false) { //번호 다름
			throw new NoPermissionException("비정상적인 회원가입");
		}
		if(certDto.getCertConfirm() == null) { //인증을 완료하지 않은 경우
			throw new NoPermissionException("비정상적인 회원가입");
		}
		
		certDao.delete(memberDto.getMemberEmail());
		memberDao.insert(memberDto); //회원가입
		emailService.sendWelcomeMail(memberDto); //환영메일 발송
		
		return "redirect:joinFinish"; // joinFinish으로 쫓아내는 코드(상대경로)
	}

	// 완료 안내
	@RequestMapping("/joinFinish") // join-finish도 가능. 다만 주소에는 대문자를 쓸수 있는곳이 있고 안되는 곳이 있음. http://localhost:8080 // 여기에는 대소문자 구분이 안됨을 알아야함!
	public String joinFinish() {
		return "/WEB-INF/views/member/joinFinish.jsp";
	}

	// 로그인 매핑
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
//		System.out.println(memberDto);
//		System.out.println(findDto);
		boolean isValid = findDto.getMemberPw().equals(memberDto.getMemberPw());
		if (isValid) {// 로그인 성공 시
			
			//(+추가)세션에 userId란 이름으로 사용자의 ID를 저장
			session.setAttribute("userId", findDto.getMemberId()); 
			//(+추가)세션에 userLevel이란 이름으로 사용자의 등급을 저장
			session.setAttribute("userLevel", findDto.getMemberLevel());
			
			//(+추가)최종 로그인 시각을 갱신 처리
			memberDao.updateMemberLogin(findDto.getMemberId());
			
			return "redirect:/";
		} 
		else {// 비밀번호 다름
			return "redirect:login?error";// 로그인 페이지로 쫓아낸다
		}
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("userId");
		session.removeAttribute("userLevel");
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
		
		model.addAttribute("purchaseHistoryList", purchaseHistoryDao.selectList(userId));
		return "/WEB-INF/views/member/mypage.jsp";
	}
	
	//비밀번호 변경 매핑
	@GetMapping("/password")
	public String password() {
		return "/WEB-INF/views/member/password.jsp"; //포워드
	}
	
	@PostMapping("/password")
	public String password(@RequestParam String currentPw, @RequestParam String newPw, HttpSession session) { //아이디를 꺼내야 됨
		String userId = (String) session.getAttribute("userId"); //세션은 꺼낼 때 아무거나 꺼낼 수 있도록 Object형태로 꺼내기 때문에 다운캐스팅 필요함
		MemberDto memberDto = memberDao.selectOne(userId);
		boolean isValid = currentPw.equals(memberDto.getMemberPw());
		if(isValid == false) { //비밀번호가 일치하지 않는 경우
			return "redirect:password?error=1";
		}
		
		//(+추가) 동일한 비밀번호를 변경할 수 없도록 차단 처리
		if(currentPw.equals(newPw)) {
			return "redirect:password?error=2"; //위와 다른 에러이기 때문에 구분해야 함
		}
		
		memberDto.setMemberPw(newPw); //비밀번호 변경
		memberDao.updateMemberPassword(memberDto);
		return "redirect:mypage";
		
	}
	
	//개인정보 변경 매핑
	//- 비밀번호는 검사용으로 사용
	//- 닉네임, 생년월일, 연락처, 이메일, 주소(우편, 기본, 상세) 변경 가능
	@GetMapping("/change")
	public String change(HttpSession session, Model model) {
		String userId = (String) session.getAttribute("userId");
		MemberDto memberDto = memberDao.selectOne(userId);
		model.addAttribute("memberDto", memberDto);
		return "/WEB-INF/views/member/change.jsp";
	}
	
	@PostMapping("/change")
	public String change(@ModelAttribute MemberDto memberDto, HttpSession session) {
		String userId = (String) session.getAttribute("userId");
		MemberDto findDto = memberDao.selectOne(userId);
		boolean isValid = findDto.getMemberPw().equals(memberDto.getMemberPw()); //사용자가 입력한 비밀번호가 데이터베이스 비밀번호와 일치하지 않을 경우
		if(!isValid) {
			return "redirect:change?error";
		}
	
		//findDto에 원하는 항목을 교체한 뒤 수정 요청
		findDto.setMemberNickname(memberDto.getMemberNickname());
		findDto.setMemberBirth(memberDto.getMemberBirth());
		findDto.setMemberContact(memberDto.getMemberContact());
		findDto.setMemberEmail(memberDto.getMemberEmail());
		findDto.setMemberPost(memberDto.getMemberPost());
		findDto.setMemberAddress1(memberDto.getMemberAddress1());
		findDto.setMemberAddress2(memberDto.getMemberAddress2());
		
		memberDao.update(findDto);
		return "redirect:mypage";
	}
	
	//회원 탈퇴 매핑
	@GetMapping("/exit")
	public String exit(HttpSession session, Model model) {
		String userId = (String) session.getAttribute("userId");
		MemberDto memberDto = memberDao.selectOne(userId);
		model.addAttribute("memberDto", memberDto);
		return "/WEB-INF/views/member/exit.jsp";
	}
	
	@PostMapping("/exit")
	public String exit(@RequestParam String memberPw, HttpSession session) {
		String userId = (String) session.getAttribute("userId");
		MemberDto memberDto = memberDao.selectOne(userId);
		boolean isValidPw = memberPw.equals(memberDto.getMemberPw()); 
		if(isValidPw == false) {
			return "redirect:exit?error";
		}
		memberDao.delete(userId);
		//return "redirect:logout";
		session.removeAttribute("userId");
		return "redirect:exitFinish";
	}
	
	@RequestMapping("/exitFinish")
	public String exitFinish() {
		return "/WEB-INF/views/member/exitFinish.jsp";
	}
	
	//비밀번호 찾기 매핑
	@GetMapping("/findPw")
	public String findPw() {
		return "/WEB-INF/views/member/findPw.jsp";
	}
	
	@PostMapping("/findPw")
	public String findPw(@ModelAttribute MemberDto memberDto) throws NoPermissionException, MessagingException, IOException {
		MemberDto findDto = memberDao.selectOne(memberDto.getMemberId());
		if(findDto == null) {
			//throw new TargetNotFoundException("존재하지 않는 아이디");
			return "redirect:findPw?error";
		}
		if(!findDto.getMemberEmail().equals(memberDto.getMemberEmail())) {
			//throw new NoPermissionException("이메일 정보 오류");
			return "redirect:findPw?error";
		}
		emailService.sendResetMail(memberDto); //재설정 메일 발송
		
		return "redirect:findPwSend";
	}
	
	@GetMapping("/findPwSend")
	public String findPwSend() {
		return "/WEB-INF/views/member/findPwSend.jsp";
	}
	
	//이 페이지들은 인증정보가 일치할 경우에만 접근을 허용
	@GetMapping("/reset")
	public String reset(@RequestParam String memberId, Model model, 
						@RequestParam String certEmail, @RequestParam String certNumber) throws NoPermissionException {
		CertDto certDto = certDao.selectOne(certEmail);
		if(certDto == null) throw new NoPermissionException("허용되지 않는 접근");
		if(!certDto.getCertNumber().equals(certNumber)) throw new NoPermissionException("허용되지 않는 접근");
		
		model.addAttribute("memberId", memberId);
		model.addAttribute("certEmail", certEmail);
		model.addAttribute("certNumber", certNumber);
		
		return "/WEB-INF/views/member/reset.jsp";
	}
	
	@PostMapping("/reset")
	public String reset(@ModelAttribute MemberDto memberDto, 
						@RequestParam String certEmail,
						@RequestParam String certNumber) throws NoPermissionException {
		CertDto certDto = certDao.selectOne(certEmail);
		if(certDto == null) 
			throw new NoPermissionException("허용되지 않는 접근");
		if(!certDto.getCertNumber().equals(certNumber)) 
			throw new NoPermissionException("허용되지 않는 접근");
		
		certDao.delete(certEmail); //인증정보 삭제
		
		memberDao.updateMemberPassword(memberDto);
		return "redirect:resetFinish";
	}
	
	@GetMapping("/resetFinish")
	public String resetFinish() {
		return "/WEB-INF/views/member/resetFinish.jsp";
	}
	
}