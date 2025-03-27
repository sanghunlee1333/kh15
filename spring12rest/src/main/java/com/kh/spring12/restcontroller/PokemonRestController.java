package com.kh.spring12.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring12.dao.PokemonDao;
import com.kh.spring12.dto.PokemonDto;
import com.kh.spring12.error.TargetNotFoundException;

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
	
	//	등록[POST]	/pokemon/
	//	조회[GET]		/pokemon/
	//	상세[GET]		/pokemon/{pokemonNo}
	//	수정[PUT]		/pokemon/{pokemonNo}
	//	     [PATCH]	/pokemon/{pokemonNo}
	//	삭제[DELETE]	/pokemon/{pokemonNo}
	
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
	
	//http://localhost:8080/swagger-ui/index.html or http://localhost:8080/api.html
	@GetMapping("/")
	public List<PokemonDto> list() {
		return pokemonDao.selectList();
	}
	
	@DeleteMapping("/{pokemonNo}")
	public void delete(@PathVariable int pokemonNo) {
		PokemonDto pokemonDto = pokemonDao.selectOne(pokemonNo);
		if(pokemonDto == null) {
			throw new TargetNotFoundException(); //없으면 404
		}
		pokemonDao.delete(pokemonNo); //있으면 200
	}
	
	//이 방식에서 @ModelAttribute는 사용이 어렵다
	//JSON으로 전달되는 데이터는 @RequestBody 로 읽는다
	//(주의) RequestBody가 두 개가 있는데 잘 골라야 합니다 - spring 것으로 선택
	@PostMapping("/")
	public void insert(@RequestBody PokemonDto pokemonDto) {
		pokemonDao.insert(pokemonDto);
	}
	
	
}
