package com.kh.spring09.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring09.dao.StatusDao;
import com.kh.spring09.vo.StatusVO;

@CrossOrigin
@RestController
@RequestMapping("/rest/status")
public class StatusRestController {

	@Autowired
	private StatusDao statusDao;
	
	@RequestMapping("/pokemon")
	public List<StatusVO> pokemon() {
		return statusDao.pokemon();
	}
	
	@RequestMapping("/game-user")
	public List<StatusVO> gameUser() {
		return statusDao.gameUser();
	}
	
	@RequestMapping("/member")
	public List<StatusVO> member() {
		return statusDao.member();
	}
	
	@RequestMapping("/member-join")
	public List<StatusVO> memberJoin() {
		return statusDao.memberJoin();
	}
	
	@RequestMapping("/board-write")
	public List<StatusVO> boardWrite() {
		return statusDao.boardWrite();
	}
	
}
