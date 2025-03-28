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

import com.kh.spring12.dao.BookDao;
import com.kh.spring12.dto.BookDto;
import com.kh.spring12.error.TargetNotFoundException;

@CrossOrigin
@RestController
@RequestMapping("/api/book")
public class BookRestController {

	@Autowired
	private BookDao bookDao;
	
	@GetMapping("/")
	public List<BookDto> list(){
		return bookDao.selectList();
	}
	
	@DeleteMapping("/{bookId}")
	public void delete(@PathVariable int bookId) {
		BookDto bookDto = bookDao.selectOne(bookId);
		if(bookDto == null) throw new TargetNotFoundException();
		bookDao.delete(bookId);
	}
	
	@PostMapping("/")
	public void insert(@RequestBody BookDto bookDto) {
		int sequence = bookDao.sequence();
		bookDto.setBookId(sequence);
		bookDao.insert2(bookDto);
	}
	
	@PutMapping("/{bookId}")
	public void edit(@PathVariable int bookId, @RequestBody BookDto bookDto) {
		BookDto targetDto = bookDao.selectOne(bookId);
		if(targetDto == null) throw new TargetNotFoundException();
		
		bookDto.setBookId(bookId);
		bookDao.update(bookDto);
	}
	
	
}
