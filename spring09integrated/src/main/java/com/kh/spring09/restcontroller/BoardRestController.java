package com.kh.spring09.restcontroller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring09.dao.BoardDao;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/rest/board")
public class BoardRestController {
	
	@Autowired
	private BoardDao boardDao;
	
	//좋아요 여부 검사 매핑
	@RequestMapping("/check")
	public Map<String, Object> check(@RequestParam int boardNo, HttpSession session) {
		String userId = (String)session.getAttribute("userId"); //id를 먼저 꺼낸다
		
		boolean done = boardDao.checkBoardLike(userId, boardNo);
		int count = boardDao.countBoardLike(boardNo);
		
		Map<String, Object> map = new HashMap<>();
		map.put("done", done); //이 회원의 좋아요 여부
		map.put("count", count); //이 글의 좋아요 개수
		return map;
		
	}
	
	//좋아요 설정/해제 매핑 -> 게시글의 좋아요 개수를 갱신
	@RequestMapping("/action")
	public Map<String, Object> action(@RequestParam int boardNo, HttpSession session) {
		String userId = (String)session.getAttribute("userId"); //id를 먼저 꺼낸다
		boolean done = boardDao.checkBoardLike(userId, boardNo);
		if(done) {//이미 좋아요를 한 상태라면
			boardDao.deleteBoardLike(userId, boardNo);
		}
		else { //좋아요 한 적 없는 상태
			boardDao.insertBoardLike(userId, boardNo);
		}
		int count = boardDao.countBoardLike(boardNo); //카운트 다시 구하기
		boardDao.updateBoardLike(boardNo, count); //좋아요 개수 갱신
		//boardDao.updateBoardLike(boardNo); //좋아요 개수 갱신
		
		Map<String, Object> map = new HashMap<>();
		map.put("done", !done); //이 회원의 좋아요 여부
		map.put("count", count); //이 글의 좋아요 개수
		return map;
	}
	
}
