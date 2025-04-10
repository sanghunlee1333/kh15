package com.kh.spring12.restcontroller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kh.spring12.dao.ItemDao;
import com.kh.spring12.dto.ItemDto;
import com.kh.spring12.error.TargetNotFoundException;
import com.kh.spring12.service.AttachmentService;

@CrossOrigin
@RestController
@RequestMapping("/api/item")
public class ItemRestController {
	@Autowired
	private ItemDao itemDao;
	
	@Autowired
	private AttachmentService attachmentService;
	
	@GetMapping("/")
	public List<ItemDto> list() {
		return itemDao.selectList();
	}
	
	@GetMapping("/{itemNo}")
	public ItemDto find(@PathVariable long itemNo) {
		//return itemDao.selectOne(itemNo);
		ItemDto itemDto = itemDao.selectOne(itemNo);
		if(itemDto == null) throw new TargetNotFoundException();
		return itemDto;
	}
	
	//파일이 없으면 (application/json 형태 수신)
//	@PostMapping("/")
//	public void add(@RequestBody ItemDto itemDto)
	
	//파일이 있으면 (multipart/form-data 형태 수신)
	@PostMapping(value = "/", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public void add(@ModelAttribute ItemDto itemDto, 
					@RequestParam MultipartFile attach) throws IllegalStateException, IOException { //@RequestParam(value="attach") List<MultipartFile> attachList -> 파일 여러 개 받을 때
		ItemDto resultDto = itemDao.insert(itemDto);
		
		//파일 유무에 따라 추가 처리
		if(attach.isEmpty() == false) {
			int attachmentNo = attachmentService.save(attach);
		}
	}
}
