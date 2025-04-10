package com.kh.spring12.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring12.dao.ItemDao;
import com.kh.spring12.dto.ItemDto;
import com.kh.spring12.error.TargetNotFoundException;

@CrossOrigin
@RestController
@RequestMapping("/api/item")
public class ItemRestController {
	@Autowired
	private ItemDao itemDao;
	
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
}
