package com.kh.spring12.restcontroller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring12.dao.AccountDao;
import com.kh.spring12.dto.AccountDto;
import com.kh.spring12.error.TargetNotFoundException;
import com.kh.spring12.vo.AccountFindNicknameVO;
import com.kh.spring12.vo.AccountFindVO;
import com.kh.spring12.vo.AccountInsertVO;
import com.kh.spring12.vo.AccountSignInVO;

@CrossOrigin
@RestController
@RequestMapping("/api/account")
public class AccountRestController {

	@Autowired
	private AccountDao accountDao;
	
	@PostMapping("/")
	public void join(@RequestBody AccountInsertVO accountInsertVO) {
		//vo -> dto 변경 (ModelMapper)
		ModelMapper mapper = new ModelMapper(); //@Autowired로 등록해놔도 됨
		AccountDto accountDto = mapper.map(accountInsertVO, AccountDto.class);
		accountDao.insert(accountDto);
	}
	
	//로그인
	//@GetMapping("/accountId/{accountId}/accountPw/{accountPw}")
	@PostMapping("/login")
	public AccountDto login(@RequestBody AccountSignInVO vo){
		ModelMapper mapper = new ModelMapper();
		AccountDto accountDto = mapper.map(vo, AccountDto.class);
		AccountDto findDto = accountDao.login(accountDto);
		if(findDto == null) throw new TargetNotFoundException("정보 불일치");
		return findDto;
	}
	
//	@PostMapping("/accountId/{accountId}")
//	public AccountDto find(@RequestBody AccountFindVO vo) {
//		ModelMapper mapper = new ModelMapper();
//		AccountDto accountDto = mapper.map(vo, AccountDto.class);
//		AccountDto findDto = accountDao.find(accountDto);
//		if(findDto == null) throw new TargetNotFoundException("아이디 불일치");
//		return findDto;
//	}
//	
//	@PostMapping("/accountId/{accountId}/accountNickname/{accountNickname}")
//	public AccountDto findNickname(@RequestBody AccountFindNicknameVO vo) {
//		ModelMapper mapper = new ModelMapper();
//		AccountDto accountDto = mapper.map(vo, AccountDto.class);
//		AccountDto findDto = accountDao.findNickname(accountDto);
//		if(findDto == null) throw new TargetNotFoundException("닉네임 불일치");
//		return findDto;
//	}
}
