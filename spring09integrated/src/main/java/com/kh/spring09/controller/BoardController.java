package com.kh.spring09.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring09.dao.BoardDao;
import com.kh.spring09.dto.BoardDto;
import com.kh.spring09.vo.PageVO;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardDao boardDao;

	// 목록 + 검색 매핑
	//- 검색을 위해 column, keyword 항목을 수신
	//- 페이징을 위해 page, size 항목을 수신
//	@RequestMapping("/list")
//	public String list(Model model,
//		@RequestParam(required = false) String column, 
//		@RequestParam(required = false) String keyword,
//		@RequestParam(required = false, defaultValue = "1") int page,
//		@RequestParam(required = false, defaultValue = "10") int size) {
//		boolean search = column != null && keyword != null;
//
//		List<BoardDto> list = search ? boardDao.selectListByPaging(column, keyword, page, size) : boardDao.selectListByPaging(page, size); // 검색 : 목록
//		model.addAttribute("list", list);
//		
//		//페이징에 필요한 데이터들을 전달
//		model.addAttribute("search", search); //검색 여부
//		model.addAttribute("page", page); //현재 페이지 번호
//		model.addAttribute("size", size); //현재 페이지 크기
//		model.addAttribute("column", column); //검색항목
//		model.addAttribute("keyword", keyword); //검색어
//		int startBlock = (page - 1) / 10 * 10 + 1;
//		int finishBlock = (page - 1) / 10 * 10 + 10;
//		model.addAttribute("startBlock", startBlock); //블록의 시작번호
//		//model.addAttribute("finishBlock", finishBlock); //블록의 종료번호
//
//		//게시글 수
//		int count;
//		if(search) {
//			count = boardDao.count(column, keyword);
//		}
//		else {
//			count = boardDao.count();
//		}
//		//페이지 수 
//		int pageCount = (count - 1) / size + 1;
//		model.addAttribute("count", count);
//		model.addAttribute("pageCount", pageCount);
//		
//		model.addAttribute("finishBlock", Math.min(pageCount, finishBlock)); //둘 중의 작은 것이 나감
//		
//		return "/WEB-INF/views/board/list.jsp";
//	}
	
	//VO를 이용하여 구조를 개선한 매핑
	//- @ModelAttribute는 자동으로 Model에 추가되는 숨겨진 기능이 있다
	//- @ModelAttrubute("pageVO")로 작성하면 model에 pageVO란 이름으로 
	@RequestMapping("/list")
	public String list(Model model, @ModelAttribute("pageVO") PageVO pageVO) {
		//model.addAttribute("pageVO", pageVO);
		model.addAttribute("list", boardDao.selectListByPaging(pageVO));
		
		//게시글 수
		int count = boardDao.count(pageVO);
		pageVO.setCount(count);
		
		return "/WEB-INF/views/board/list.jsp";
	}

	// 게시글 상세 매핑
	// - 상세조회를 위해서는 기본키(primary key)가 필요하다
	@RequestMapping("/detail")
	public String detail(@RequestParam int boardNo, Model model) {
		BoardDto boardDto = boardDao.selectOne(boardNo);
		model.addAttribute("boardDto", boardDto);
		return "/WEB-INF/views/board/detail.jsp";
	}

	// 게시글 작성 매핑
	@GetMapping("/write")
	public String write() {
		return "/WEB-INF/views/board/write.jsp";
	}

	@PostMapping("/write")
	public String write(@ModelAttribute BoardDto boardDto, HttpSession session) { // boardTitle, content로 받으면 리퀘스트파람으로,
																					// DTO로 대체해서 받으면 Modelattribute로
		// 사용자는 2개의 정보(제목, 내용)만 작성
		// 작성자 정보는 HttpSession에 있으므로 이를 꺼내어 합쳐서 등록
		String userId = (String) session.getAttribute("userId");
		boardDto.setBoardWriter(userId);

		// 1. 등록 후 글 목록으로
//	    boardDao.insert(boardDto);
//		return "redirect:list"; //목록으로 리다이렉트

		// 2. 등록 후 글 상세로
		// 등록 후 상세페이지로 이동시켜야할 경우 반드시 등록된 대상의 번호가 필요
		// [1] 등록하고 나서 DB에서 가장 큰 글 번호를 조회 // (max) -> 만약 두 명이 딱 동시에 글 등록을 하면 문제가 생기므로 절대
		// 안되는 방법
		// - select max(board_no) from board
		// [2] 시퀀스만 번호만 미리 생성해오는 방법
		// - select board_seq.nextval from dual

		int boardNo = boardDao.sequence();// 시퀀스 번호 발행
		boardDto.setBoardNo(boardNo); // 번호설정
		boardDao.insert2(boardDto); // 등록

		return "redirect:detail?boardNo=" + boardNo; // 상세로 리다이렉트
	}

	// 게시글 삭제 매핑
	@RequestMapping("/delete")
	public String delete(@RequestParam int boardNo) {
		boardDao.delete(boardNo);
		return "redirect:list";
	}

	// 게시글 수정 매핑
	@GetMapping("/edit")
	public String edit(@RequestParam int boardNo, Model model) {
		BoardDto boardDto = boardDao.selectOne(boardNo);
		model.addAttribute("boardDto", boardDto);
		return "/WEB-INF/views/board/edit.jsp";
	}

	@PostMapping("/edit")
	public String edit(@ModelAttribute BoardDto boardDto) {
		boardDao.update(boardDto);
		return "redirect:detail?boardNo=" + boardDto.getBoardNo();
	}

}
