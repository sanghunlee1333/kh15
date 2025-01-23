package com.kh.spring09.controller.admin;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kh.spring09.dao.GiftcardDao;
import com.kh.spring09.dto.GiftcardDto;
import com.kh.spring09.service.AttachmentService;

@Controller
@RequestMapping("/admin/giftcard")
public class AdminGiftcardController {

	@Autowired
	private GiftcardDao giftcardDao;
	
	@Autowired
	private AttachmentService attachmentService;
	
	@GetMapping("/add")
	public String add() {
		return "/WEB-INF/views/admin/giftcard/add.jsp";
	}
	
	@PostMapping("/add")
	public String add(@ModelAttribute GiftcardDto giftcardDto, @RequestParam MultipartFile attach)
			throws IllegalStateException, IOException {
		int giftcardNo = giftcardDao.sequence();
		giftcardDto.setGiftcardNo(giftcardNo);
		giftcardDao.add(giftcardDto);

		if (attach.isEmpty() == false) { // 비어있지 않다면(첨부파일이 있을 경우)
			// [2] 첨부파일 등록 -> 첨부파일번호(시퀀스)
			int attachmentNo = attachmentService.save(attach);

			// [3] 포켓몬 이미지 등록(연결) -> 1, 2번에서 뽑은 포켓몬번호, 첨부파일번호
			giftcardDao.connect(giftcardNo, attachmentNo);
		}
		return "redirect:list";
	}
	
}
