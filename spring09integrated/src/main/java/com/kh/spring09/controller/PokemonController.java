package com.kh.spring09.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring09.dao.PokemonDao;
import com.kh.spring09.dto.PokemonDto;

@Controller
@RequestMapping("/pokemon")
public class PokemonController {
	
	@Autowired
	private PokemonDao pokemonDao;
	
	//사용자 입력 페이지
	@GetMapping("/add") //GET방식만 처리하는 매핑
	public String add() {
		return "/WEB-INF/views/pokemon/add.jsp";
	}
	
	//입력 처리
	@PostMapping("/add") //POST방식만 처리하는 매핑
	public String add2(@ModelAttribute PokemonDto pokemonDto) {
		pokemonDao.insert(pokemonDto);
		//return "포켓몬 등록 완료"; //@RestController일 때 가능했던 코드 
		//return "/WEB-INF/views/pokemon/add2.jsp"; //새로고침 문제 발생
		//return "redirect:/pokemon/addFinish"; //addFinish으로 쫓아내는 코드(절대경로)
		return "redirect:addFinish"; //addFinish으로 쫓아내는 코드(상대경로)
	}
	
	//완료 안내
	@RequestMapping("/addFinish") //방식 무관
	public String add3() {
		return "/WEB-INF/views/pokemon/addFinish.jsp";
	}
	
	//목록 매핑
	//- 데이터베이스에서 조회환 결과(List<PokemonDto>)를 화면에 전달
	@RequestMapping("/list")
	public String list(Model model) {
		List<PokemonDto> list = pokemonDao.selectList();
		model.addAttribute("list", list);
		
		return "/WEB-INF/views/pokemon/list.jsp";	
	}

}
 