package com.kh.spring09.restcontroller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kh.spring09.dao.BoardDao;
import com.kh.spring09.error.TargetNotFoundException;
import com.kh.spring09.service.AttachmentService;

import jakarta.servlet.http.HttpSession;

@CrossOrigin
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
	
	//첨부파일 업로드(summernote 전용 기능)
	@Autowired
	private AttachmentService attachmentService;
	
	//파일 1개 업로드 처리
	@PostMapping("/upload")
	public int upload(@RequestParam MultipartFile attach) throws IllegalStateException, IOException { //public 파일번호(int) or 접근주소 upload(사용자가 올린 파일)
		if(attach.isEmpty()) {
			throw new TargetNotFoundException("첨부파일이 없습니다");
		}
		return attachmentService.save(attach);
	}
	
	//파일 여러 개 업로드 처리
	@PostMapping("/uploads")
	public List<Integer> uploads(@RequestParam(value="attach") List<MultipartFile> attachList) throws IllegalStateException, IOException { //attach로 받고 attachList라는 이름을 쓰겠다
		List<Integer> numbers = new ArrayList<>();
		for(MultipartFile attach : attachList) {
			if(attach.isEmpty()) continue; //비면 스킵
			int attachmentNo = attachmentService.save(attach);
			numbers.add(attachmentNo);
		}
		return numbers;
	}
	
	
}
