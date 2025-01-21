package com.kh.spring09.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kh.spring09.dao.GameUserDao;
import com.kh.spring09.dto.GameUserDto;
import com.kh.spring09.service.AttachmentService;

@Controller
@RequestMapping("/game-user") // gameUser, game-user, game_user -> 세부경로부터는 대소문자 구분 가능
public class GameUserController {

	@Autowired
	private GameUserDao gameUserDao;

	@Autowired
	private AttachmentService attachmentService;
	
	// 사용자 입력 페이지
	@GetMapping("/add") // GET방식만 처리하는 매핑
	public String add() {
		return "/WEB-INF/views/game-user/add.jsp";
	}

	// 입력 처리
//	@PostMapping("/add") // POST방식만 처리하는 매핑
//	public String add(@ModelAttribute GameUserDto gameUserDto) { // 사용자에게 보여지면 안되는 페이지
//		// 방법1
//		// GameUserDto 에서 레벨 필드를 1로 설정
//
//		// 방법2
//		if (gameUserDto.getGameUserLevel() == 0) { // 사용자가 레벨을 입력하지 않는다면
//			gameUserDto.setGameUserLevel(1);
//		}
//		gameUserDao.insert(gameUserDto);
//		return "redirect:addFinish"; // addFinish으로 쫓아내는 코드(상대경로)
//	}
	
	@PostMapping("/add")
	public String add(@ModelAttribute GameUserDto gameUserDto, @RequestParam MultipartFile attach) throws IllegalStateException, IOException {
		
		if (gameUserDto.getGameUserLevel() == 0) { // 사용자가 레벨을 입력하지 않는다면
			gameUserDto.setGameUserLevel(1);
		}
		
		int gameUserNo = gameUserDao.sequence();
		gameUserDto.setGameUserNo(gameUserNo);
		gameUserDao.insert2(gameUserDto);
		
		if(attach.isEmpty() == false) {
			int attachmentNo = attachmentService.save(attach);
			gameUserDao.connect(gameUserNo, attachmentNo);
		}
		
		return "redirect:add-finish";
	}

	// 완료 안내
	@RequestMapping("/add-finish") // 방식 무관
	public String addFinish() {
		return "/WEB-INF/views/game-user/add-finish.jsp";
	}

	// 목록 + 검색 매핑
	@RequestMapping("/list")
	public String list(@RequestParam(required = false) String column, @RequestParam(required = false) String keyword,
			Model model) {
		boolean search = column != null && keyword != null;

		// List<GameUserDto> list = search ? gameUserDao.selectList(column, keyword) :
		// gameUserDao.selectList();
		if (search) {
			model.addAttribute("list", gameUserDao.selectList(column, keyword));
		} else {
			model.addAttribute("list", gameUserDao.selectList());
		}
		model.addAttribute("search", search);
		model.addAttribute("column", column);
		model.addAttribute("keyword", keyword);
		// model.addAttribute(list);

		return "/WEB-INF/views/game-user/list.jsp";
	}

	// 상세 매핑
	@RequestMapping("/detail")
	public String detail(@RequestParam int gameUserNo, Model model) {
		GameUserDto gameUserDto = gameUserDao.selectOne(gameUserNo);
		model.addAttribute("gameUserDto", gameUserDto);
		return "/WEB-INF/views/game-user/detail.jsp";
	}
	
	//삭제 매핑
	@RequestMapping("/delete")
	public String delete(@RequestParam int gameUserNo) {
		gameUserDao.delete(gameUserNo);
		//return "redirect:list";
		return "redirect:/game-user/list"; //redirect -> 주소가 바뀜, 끝나고 다른 곳으로 이동
		//return "/WEB-INF/views/country/list.jsp"; //forward -> 주소가 유지되고 화면만 연결
	}
	
	//수정 매핑
	@GetMapping("/edit")
	public String edit(@RequestParam int gameUserNo, Model model) { // 어노테이션 붙은 것은 사용자 입력값, 안붙은 것은 스프링 도구
		GameUserDto gameUserDto = gameUserDao.selectOne(gameUserNo);
		model.addAttribute("gameUserDto", gameUserDto);
		return "/WEB-INF/views/game-user/edit.jsp";
	}
	
//	@PostMapping("/edit")
//	public String edit(@ModelAttribute GameUserDto gameUserDto) {
//		boolean success = gameUserDao.update(gameUserDto);
//		if(success) {
//			return "redirect:detail?gameUserNo="+gameUserDto.getGameUserNo();
//		}
//		else {
//			return "redirect:list";
//		}
//	}
	
	@PostMapping("/edit")
	public String edit(@ModelAttribute GameUserDto gameUserDto, @RequestParam MultipartFile attach) throws IllegalStateException, IOException {
		boolean success = gameUserDao.update(gameUserDto);
		if(!success) {
			return "redirect:list";
		}
		if(attach.isEmpty() == false) {
			try {
				int attachmentNo = gameUserDao.findAttachment(gameUserDto.getGameUserNo());
				attachmentService.delete(attachmentNo);
			} catch(Exception e) { }
			
			int newAttachmentNo = attachmentService.save(attach);
			gameUserDao.connect(gameUserDto.getGameUserNo(), newAttachmentNo);
		}
		return "redirect:detail?gameUserNo="+gameUserDto.getGameUserNo();
	}
	
	@RequestMapping("/edit")
	public String edit(@ModelAttribute GameUserDto gameUserDto, Model model) {
		gameUserDao.update(gameUserDto);
		return "/WEB-INF/views/game-user/edit.jsp";
	}
	
	//(+추가) 레벨업 매핑
	@RequestMapping("/levelup")
	public String levelup(@RequestParam int gameUserNo) {
		GameUserDto gameUserDto = gameUserDao.selectOne(gameUserNo);
		int level = gameUserDto.getGameUserLevel();
		gameUserDto.setGameUserLevel(level+1);
		gameUserDao.update(gameUserDto);
		
		//gameUserDao.updateGameUserLevel(gameUserNo);
		
		return "redirect:detail?gameUserNo="+gameUserNo;
				
	}
	
}
