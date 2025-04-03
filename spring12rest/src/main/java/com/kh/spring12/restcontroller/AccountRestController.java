package com.kh.spring12.restcontroller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring12.dao.AccountDao;
import com.kh.spring12.dto.AccountDto;
import com.kh.spring12.error.TargetNotFoundException;
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
	
	@GetMapping("/accountId/{accountId}")
	public void findAccountId(@PathVariable String accountId) {
		AccountDto accountDto = accountDao.selectOne(accountId);
		if(accountDto == null) throw new TargetNotFoundException();
	}
	
	@GetMapping("/accountNickname/{accountNickname}")
	public void findNickname(@PathVariable String accountNickname) {
		AccountDto accountDto = accountDao.selectOneByAccountNickname(accountNickname);
		if(accountDto == null) throw new TargetNotFoundException();
	}
}
