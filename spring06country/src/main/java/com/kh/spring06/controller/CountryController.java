package com.kh.spring06.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring06.dao.CountryDao;
import com.kh.spring06.dto.CountryDto;

@RestController
@RequestMapping("/country")//공용주소
public class CountryController {
	
	@Autowired
	private CountryDao countryDao;
	
	//등록 매핑
	//- @RequestParam은 파라미터 1개를 받는 명령
	//- @ModelAttribute는 가능한 모든 파라미터를 받는 명령
	@RequestMapping("/add")//상세주소
	public String add(@ModelAttribute CountryDto countryDto) {
		countryDao.insert(countryDto);
		return "나라 등록 완료";
	}
	
	//수정 매핑
	@RequestMapping("/edit")
	public String update(@ModelAttribute CountryDto countryDto) {
		boolean success = countryDao.update(countryDto);
		return success ? "나라 변경 완료" : "존재하지 않는 나라 번호";
	}
	
	//삭제 매핑
	@RequestMapping("/delete")
	public String delete(@RequestParam int countryNo) {
		boolean success = countryDao.delete(countryNo);
		return success ? "나라 삭제 완료" : "존재하지 않는 나라 번호";
	}

}
