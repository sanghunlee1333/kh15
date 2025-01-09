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

import com.kh.spring09.dao.GameUserDao;
import com.kh.spring09.dto.GameUserDto;

@Controller
@RequestMapping("/game-user") //gameUser, game-user, game_user -> 세부경로부터는 대소문자 구분 가능
public class GameUserController {
	
	@Autowired
	private GameUserDao gameUserDao;
	
	//사용자 입력 페이지
	@GetMapping("/add") //GET방식만 처리하는 매핑
	public String add() {
		return "/WEB-INF/views/game-user/add.jsp"; 
	}
	
	//입력 처리
	@PostMapping("/add") //POST방식만 처리하는 매핑
	public String add(@ModelAttribute GameUserDto gameUserDto) { //사용자에게 보여지면 안되는 페이지
		//방법1
		//GameUserDto 에서 레벨 필드를 1로 설정
		
		//방법2
		if(gameUserDto.getGameUserLevel() == 0) { //사용자가 레벨을 입력하지 않는다면
			gameUserDto.setGameUserLevel(1);
		}
		gameUserDao.insert(gameUserDto);
		return "redirect:addFinish"; //addFinish으로 쫓아내는 코드(상대경로)
	}
	
	//완료 안내
	@RequestMapping("/add-finish") //방식 무관
	public String addFinish() {
		return "/WEB-INF/views/game-user/add-finish.jsp";
	}
	
	//목록 + 검색 매핑
	@RequestMapping("/list")
	public String list(@RequestParam(required = false) String column,
						@RequestParam(required = false) String keyword,
						Model model) {
		boolean search = column != null && keyword != null;
		
		//List<GameUserDto> list = search ? gameUserDao.selectList(column, keyword) : gameUserDao.selectList();
		if(search) {
			model.addAttribute("list", gameUserDao.selectList(column, keyword));
		}
		else {
			model.addAttribute("list", gameUserDao.selectList());
		}
		model.addAttribute("search", search);
		model.addAttribute("column", column);
		model.addAttribute("keyword", keyword);
		//model.addAttribute(list);
		
		return "/WEB-INF/views/game-user/list.jsp";
	}
	
	@RequestMapping("/table")
	public String table() {
		return "/WEB-INF/views/game-user/table.jsp";
	}

}
 