package com.kh.spring12.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring12.dao.BuyDao;
import com.kh.spring12.service.TokenService;
import com.kh.spring12.vo.BuyTotalVO;
import com.kh.spring12.vo.ClaimVO;

@CrossOrigin
@RestController
@RequestMapping("/api/buy")
public class BuyRestController {

	@Autowired
	private BuyDao buyDao;
	
	@Autowired
	private TokenService tokenService;
	
	@GetMapping("/")
	public List<BuyTotalVO> list(@RequestHeader("Authorization") String bearerToken) {
		ClaimVO claimVO = tokenService.parseBearerToken(bearerToken);
		//return buyDao.listTotalManual(claimVO.getUserId());
		return buyDao.listTotalAuto(claimVO.getUserId());
	}
	
}
