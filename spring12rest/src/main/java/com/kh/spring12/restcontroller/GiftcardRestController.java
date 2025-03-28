package com.kh.spring12.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring12.dao.GiftcardDao;
import com.kh.spring12.dto.BookDto;
import com.kh.spring12.dto.GiftcardDto;
import com.kh.spring12.error.TargetNotFoundException;

@CrossOrigin
@RestController
@RequestMapping("/api/giftcard")
public class GiftcardRestController {
	
	@Autowired
	private GiftcardDao giftcardDao;
	
	@GetMapping("/")
	public List<GiftcardDto> list(){
		return giftcardDao.selectList();
	}
	
	@DeleteMapping("/{giftcardNo}")
	public void delete(@PathVariable int giftcardNo) {
		GiftcardDto giftcardDto = giftcardDao.selectOne(giftcardNo);
		if(giftcardDto == null) throw new TargetNotFoundException();
		giftcardDao.delete(giftcardNo);
	}
	
	@PostMapping("/")
	public void insert(@RequestBody GiftcardDto giftcardDto) {
		int sequence = giftcardDao.sequence();
		giftcardDto.setGiftcardNo(sequence);
		giftcardDao.insert(giftcardDto);
	}
	
	@PutMapping("/{giftcardNo}")
	public void edit(@PathVariable int giftcardNo, @RequestBody GiftcardDto giftcardDto) {
		GiftcardDto targetDto = giftcardDao.selectOne(giftcardNo);
		if(targetDto == null) throw new TargetNotFoundException();
		
		giftcardDto.setGiftcardNo(giftcardNo);
		giftcardDao.update(giftcardDto);
	}
}
