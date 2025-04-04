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
import com.kh.spring12.service.TokenService;
import com.kh.spring12.vo.AccountInsertVO;
import com.kh.spring12.vo.AccountSignInResponseVO;
import com.kh.spring12.vo.AccountSignInVO;

@CrossOrigin
@RestController
@RequestMapping("/api/account")
public class AccountRestController {

	@Autowired
	private AccountDao accountDao;
	
	@Autowired
	private TokenService tokenService;
	
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
	public AccountSignInResponseVO login(@RequestBody AccountSignInVO vo){
		//사용자가 입력한 내용을 AccountDto로 변환(아이디/비밀번호)
		ModelMapper mapper = new ModelMapper();
		AccountDto accountDto = mapper.map(vo, AccountDto.class);
		
		//데이터 베이스 탐색(+비밀번호 비교)
		AccountDto findDto = accountDao.login(accountDto);
		if(findDto == null) throw new TargetNotFoundException("정보 불일치");
		
		//로그인 성공!
		//사용자가 받아야할 데이터를 생성하고 반환
		return AccountSignInResponseVO.builder()
					.userId(findDto.getAccountId())
					.userLevel(findDto.getAccountLevel())
					.accessToken(tokenService.generateAccessToken(findDto))
				.build();
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
