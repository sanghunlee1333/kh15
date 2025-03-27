package com.kh.spring12.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
}
