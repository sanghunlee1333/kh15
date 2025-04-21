package com.kh.spring12.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring12.dao.PokemonDao;
import com.kh.spring12.dto.CountryDto;
import com.kh.spring12.dto.PokemonDto;
import com.kh.spring12.error.TargetNotFoundException;
import com.kh.spring12.vo.SearchVO;

@CrossOrigin //다른 도메인(주소)에서 오는 요청도 허용해주겠다는 뜻. 현재는 아무 origin이나 허용. 브라우저는 보안상 다른 출처(origin)에서 요청하면 막아버림. 
//ex) 프론트엔드가 localhost:3000, 백엔드는 localhost:8080이면 -> 다른 origin. 이걸 허용하려면 @CrossOrigin이 필요.
//@CrossOrigin(origins = "http://localhost:3000") -> 해당 origin만 허용
@RestController //이 클래스는 "웹 요청을 처리하는 컨트롤러야!" 라고 스프링에게 알려주는 것. 역할 = 사용자의 요청을 받아서, 데이터를 처리한 다음, JSON 형식으로 결과를 반환해줌
//예전에는 @Controller @ResponseBody -> @RestController는 이걸 한 줄로 합친 것
@RequestMapping("/api/pokemon") //이 컨트롤러의 기본 경로(URL) 를 정하는 것
public class PokemonRestController {
	
	/*
	- JSON(JavaScript Object Notation) = 데이터를 주고받을 때 쓰는 형식
	- 말 그대로 자바스크립트 객체처럼 생긴 데이터 표현 방식
	- ex) {
			 "name": "피카츄",
			 "level": 25,
			 "type": "전기"
		  }
	- 이건 name, level, type이라는 속성(키)과 "피카츄", 25, "전기"라는 값을 가지고 있어
	- 왜 쓰냐? -> 
	1) 사람도 읽기 쉽고 (가독성 좋고)
	2) 컴퓨터도 파싱하기 쉬움
	3) 대부분의 언어에서 쉽게 다룰 수 있음
	4) 프론트엔드 <-> 백엔드 간 데이터 전송에 딱!
	- 실제 흐름 -> 프론트엔드가 서버한테 요청을 보내면 서버는 JSON 형식으로 데이터를 줌 -> 프론트가 받아서 화면에 보여줌
	
	 */
	//- REST API = ?????

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
	//	   [PATCH]	/pokemon/{pokemonNo}
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
	
	//컬럼+키워드 검색
	//- 항목(column), 검색어(keyword)를 전달받아서 검색하도록 구현
	//- 문제는 두 개의 데이터를 어떻게 받을 것인가?
	//[1] 조회니까 GET방식으로 수신하며 각각의 데이터는 경로변수로 수신
	//[2] 조회지만 데이터가 많으니까 POST로 수신 (기본규칙을 어기는 방식)
	
	//[1]
	@GetMapping("/column/{column}/keyword/{keyword}")
	public List<PokemonDto> search(@PathVariable String column, @PathVariable String keyword){
		return pokemonDao.selectList(column, keyword);
	}
	
	//[2]
	@PostMapping("/search")
	public List<PokemonDto> search(@RequestBody SearchVO searchVO){
		//return pokemonDao.selectList(searchVO.getColumn(), searchVO.getKeyword());
		return pokemonDao.selectList(searchVO);
	}
	
	
}
