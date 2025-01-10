package com.kh.spring09.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring09.dao.PokemonDao;
import com.kh.spring09.dto.PokemonDto;

@Controller
@RequestMapping("/pokemon")
public class PokemonController {

	@Autowired
	private PokemonDao pokemonDao;

	// 사용자 입력 페이지
	@GetMapping("/add") // GET방식만 처리하는 매핑
	public String add() {
		return "/WEB-INF/views/pokemon/add.jsp";
	}

	// 입력 처리
	@PostMapping("/add") // POST방식만 처리하는 매핑
	public String add2(@ModelAttribute PokemonDto pokemonDto) {
		pokemonDao.insert(pokemonDto);
		// return "포켓몬 등록 완료"; //@RestController일 때 가능했던 코드
		// return "/WEB-INF/views/pokemon/add2.jsp"; //새로고침 문제 발생
		// return "redirect:/pokemon/addFinish"; //addFinish으로 쫓아내는 코드(절대경로)
		return "redirect:addFinish"; // addFinish으로 쫓아내는 코드(상대경로)
	}

	// 완료 안내
	@RequestMapping("/addFinish") // 방식 무관
	public String add3() {
		return "/WEB-INF/views/pokemon/addFinish.jsp";
	}

	// 목록 매핑
	// - 데이터베이스에서 조회환 결과(List<PokemonDto>)를 화면에 전달
	@RequestMapping("/list")
	public String list(Model model) {
		List<PokemonDto> list = pokemonDao.selectList();
		model.addAttribute("list", list);

		return "/WEB-INF/views/pokemon/list.jsp";
	}

	// 상세조회 매핑
	// - 상세조회를 위해서는 기본키(primary key)가 필요하다
	@RequestMapping("/detail")
	public String detail(@RequestParam int pokemonNo, Model model) {
		PokemonDto pokemonDto = pokemonDao.selectOne(pokemonNo);
		model.addAttribute("pokemonDto", pokemonDto);
		return "/WEB-INF/views/pokemon/detail.jsp";
	}
	
	//삭제 매핑
	//- JSP를 연동할 필요 없이 처리 후 다른 매핑으로 쫓아낸다(redirect)
//	@RequestMapping("/delete")
//	public String delete(@RequestParam int pokemonNo) {
//		boolean success = pokemonDao.delete(pokemonNo);
//		if(success) {
//			return "redirect:list";
//		}
//		else {
//			return "redirect:list"; //오류 처리로 나중에 변경
//		}
//	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam int pokemonNo) {
		pokemonDao.delete(pokemonNo);
		return "redirect:list";
	}
	
	//수정 매핑
	//- 입력/처리를 GET/POST로 나누어서 처리
	//- 정보를 표시해두기 위해 Model에 DTO 정보를 전달해야 한다
	@GetMapping("/edit")
	public String edit(@RequestParam int pokemonNo, Model model) {
		PokemonDto pokemonDto = pokemonDao.selectOne(pokemonNo);
		model.addAttribute("pokemonDto", pokemonDto);
		return "/WEB-INF/views/pokemon/edit.jsp";
	}
		
	@PostMapping("/edit")
	public String edit(@ModelAttribute PokemonDto pokemonDto) {
		boolean success = pokemonDao.update(pokemonDto);
		if(success) {
			//*참고 : redirect는 다른 매핑으로 GET방식 요청을 생성하는 것이므로 
			return "redirect:detail?pokemonNo="+pokemonDto.getPokemonNo(); 
		}
		else {
			return "redirect:list";
		}
		
	}
	
	@RequestMapping("/edit")
	public String edit(@ModelAttribute PokemonDto pokemonDto, Model model) {
		pokemonDao.update(pokemonDto);
		return "/WEB-INF/views/pokemon/edit.jsp";
	}
}
