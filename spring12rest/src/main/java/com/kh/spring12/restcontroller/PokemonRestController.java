package com.kh.spring12.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring12.dao.PokemonDao;
import com.kh.spring12.dto.PokemonDto;

@CrossOrigin
@RestController
@RequestMapping("/api/pokemon")
public class PokemonRestController {

	@Autowired
	private PokemonDao pokemonDao;
	
	//@RequestMapping은 이제 사용하지 않는다
	//작업에 맞게 주소를 최소화하여 사용한다(자원 기반 주소 방식, ROA(Resource Oriented Architecture))
	//- 주소가 같아도 방식이 다르면 다른 작업을 시킬 수 있다
	//- 방식이 몇 가지가 있을까? 작업은 몇 종류가 있을까?
	//- 작업은 C, R, U, D 네 가지가 있다
	//- GET, POST, PUT, PATCH, DELETE 방식을 각각의 작업에 연결하여 사용
	//- 조회(GET), 삭제(DELETE), 등록(POST), 수정(PUT-전체 / PATCH-부분) *(참고-면접)PUT과 PATCH 차이!!!
	//- 주소에 기능은 가급적 배제하고 Entity만 기술
	
	//SOA - Service Oriented Architecture
		// /member/join
		// /member/login
		// /member/mypage
		// /board/write
		// /board/detail
	
	//ROA - Resource Oriented Architecture
		// /member/[GET] 회원 조회
		// /member/[POST] 회원 등록(가입X)
		// /member/[PUT] 회원 전체 수정 
		// /board/[GET] 게시글 조회
		// /board/[POST] 게시글 등록
	
	@GetMapping("/")
	public List<PokemonDto> list() {
		return pokemonDao.selectList();
	}
	
}
