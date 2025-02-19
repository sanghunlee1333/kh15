package com.kh.spring10.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring10.dao.MemberDao;
import com.kh.spring10.dto.MemberDto;

@CrossOrigin
@RestController
@RequestMapping("/member")
public class MemberRestController {
	
	@Autowired
	private MemberDao memberDao;
	
//	@GetMapping("/check/memberId")
//	public boolean checkMemberId(@RequestParam String memberId) {
//		//List<MemberDto> list = memberDao.selectListByMemberId(memberId);
//		MemberDto memberDto = memberDao.selectOne(memberId);
//		return memberDto != null;
//	}
	
	@PostMapping("/check/memberId") //Get매핑도 가능하고, Request매핑으로도 가능(전부 수용)
	public boolean checkMemberId(@RequestParam String memberId) {
		//List<MemberDto> list = memberDao.selectListByMemberId(memberId);
		MemberDto memberDto = memberDao.selectOne(memberId); 
		return memberDto != null;
	}
	
	@PostMapping("/check/memberNickname")
	public boolean checkMemberNickname(@RequestParam String memberNickname) {
		//List<MemberDto> list = memberDao.selectListByMemberNickname(memberNickname);
		MemberDto memberDto = memberDao.selectOneByMemberNickname(memberNickname);
		//int count = memberDao.countByMemberNickname(memberNickname); //count로도 가능하지만 활용 가치가 낮다. 닉네임은 0아니면 1이므로
		return memberDto != null;
	}
}
