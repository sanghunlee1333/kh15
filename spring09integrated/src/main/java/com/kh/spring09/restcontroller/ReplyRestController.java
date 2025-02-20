package com.kh.spring09.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring09.dao.ReplyDao;
import com.kh.spring09.dto.ReplyDto;

//@CrossOrigin //같은 프로젝트이므로 사용할 필요가 없음
@RestController
@RequestMapping("/rest/reply")
public class ReplyRestController {

	@Autowired
	private ReplyDao replyDao;
	
	//댓글 목록
	@RequestMapping("/list")
	public List<ReplyDto> list(@RequestParam int replyOrigin) {
		return replyDao.selectList(replyOrigin);
	}
	
}
