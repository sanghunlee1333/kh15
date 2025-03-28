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

import com.kh.spring12.dao.CountryDao;
import com.kh.spring12.dto.CountryDto;
import com.kh.spring12.error.TargetNotFoundException;

@CrossOrigin
@RestController
@RequestMapping("/api/country")
public class CountryRestController {

	@Autowired
	private CountryDao countryDao;
	
	@GetMapping("/")
	public List<CountryDto> list() {
		return countryDao.selectList();
	}
	
	@DeleteMapping("/{countryNo}")
	public void delete(@PathVariable int countryNo) {
		CountryDto countryDto = countryDao.selectOne(countryNo);
		if(countryDto == null) {
			throw new TargetNotFoundException();
		}
		countryDao.delete(countryNo);
	}
	
	@PostMapping("/")
	public void insert(@RequestBody CountryDto countryDto) {
		//countryDao.insert(countryDto);
		int sequence = countryDao.sequence();
		countryDto.setCountryNo(sequence);
		countryDao.insert2(countryDto);
	}
	
	//수정은 2가지가 존재 
	//[1]전체수정(PUT) - 가능한 전체를 바꾸거나 덮어쓰기할 때 사용
	//[2]부분수정(PATCH) - 한개씩 바꾸는 느낌이거나 증가or감소 처리할 때 사용
	//- 둘 다 경로변수로 PK를 받는다 (이론상 PK도 변경이 가능하기 때문)
	@PutMapping("/{countryNo}")
	public void edit(@PathVariable int countryNo, @RequestBody CountryDto countryDto) {
		CountryDto targetDto = countryDao.selectOne(countryNo);
		if(targetDto == null) throw new TargetNotFoundException();
		
		countryDto.setCountryNo(countryNo);
		countryDao.update(countryDto);
	}
}
