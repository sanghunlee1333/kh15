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

import com.kh.spring09.dao.BoardDao;
import com.kh.spring09.dao.MemberDao;
import com.kh.spring09.dto.BoardDto;
import com.kh.spring09.dto.MemberDto;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardDao boardDao;

	// 목록 + 검색 매핑
	@RequestMapping("/list")
	public String list(@RequestParam(required = false) String column, @RequestParam(required = false) String keyword,
			Model model) {
		boolean search = column != null && keyword != null;

		List<BoardDto> list = search ? boardDao.selectList(column, keyword) : boardDao.selectList();

		model.addAttribute("list", list);

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
