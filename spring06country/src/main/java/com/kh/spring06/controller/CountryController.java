package com.kh.spring06.controller;

import java.util.List;
import java.util.Optional;

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
	//- 주소는 사용자 친화적으로 작성하는 편
	@RequestMapping("/add")//상세주소
	public String add(@ModelAttribute CountryDto countryDto) {
		countryDao.insert(countryDto);
		return "나라 등록 완료";
	}
	
	//수정 매핑
	@RequestMapping("/edit")
	public String edit(@ModelAttribute CountryDto countryDto) {
		boolean success = countryDao.update(countryDto);
		return success ? "나라 변경 완료" : "존재하지 않는 나라 번호";
	}
	
	//삭제 매핑
	@RequestMapping("/delete")
	public String delete(@RequestParam int countryNo) {
		boolean success = countryDao.delete(countryNo);
		return success ? "나라 삭제 완료" : "존재하지 않는 나라 번호";
	}
	
	//목록 매핑
	@RequestMapping("/list")
	public String list() {
		List<CountryDto> list = countryDao.selectList();
		StringBuffer buffer = new StringBuffer();
		if(list.isEmpty()) {
			buffer.append("데이터가 존재하지 않습니다");
		}
		else {
			buffer.append("검색 결과 수 : " + list.size() + "<br>");
			for(CountryDto countryDto : list) {
				buffer.append(countryDto.toString());
				buffer.append("<br>");
			}
		}
		return buffer.toString();
	}
	
	//검색 매핑
	@RequestMapping("/search")
	public String search(@RequestParam String column, 
						@RequestParam String keyword) {
		List<CountryDto> list = countryDao.selectList(column, keyword);
		StringBuffer buffer = new StringBuffer();
		buffer.append("검색 결과 수 : " + list.size() + "<br>");
		for(CountryDto countryDto : list) {
			buffer.append(countryDto.toString());
			buffer.append("<br>");
		}
		return buffer.toString();
	}
	
	//조회+검색 매핑
	//내 풀이
//	@RequestMapping("/total")
//	public String total(Optional<String> column, Optional<String> keyword) {
//		List<CountryDto> list;
//		if (column.isPresent() && keyword.isPresent()) {
//			list = countryDao.selectList(column.get(), keyword.get());			
//		}
//		else {
//			list = countryDao.selectList();
//		}
//		StringBuffer buffer = new StringBuffer();
//		buffer.append("검색 결과 수 : " + list.size() + "<br>");
//		for(CountryDto countryDto : list) {
//			buffer.append(countryDto.toString());
//			buffer.append("<br>");
//		}
//		return buffer.toString();
//	}
	
	//강사님 풀이
	@RequestMapping("/total")
	public String total(@RequestParam(required = false) String column, 
						@RequestParam(required = false) String keyword) {
		//검색 매핑인지 판정
		boolean search = column != null && keyword != null;
		
		//3항 연산자
		List<CountryDto> list = search ? countryDao.selectList(column, keyword) : countryDao.selectList();
		
		StringBuffer buffer = new StringBuffer();
		if(list.isEmpty()) {
			buffer.append("데이터가 존재하지 않습니다");
		}
		else {
			buffer.append("검색 결과 수 : " + list.size() + "<br>");
			for(CountryDto countryDto : list) {
				buffer.append(countryDto.toString());
				buffer.append("<br>");
			}
		}
		return buffer.toString();
	}
	
	//상세 매핑
	@RequestMapping("/detail")
	public String detail(@RequestParam int countryNo) {
		CountryDto countryDto = countryDao.selectOne(countryNo);
		if(countryDto == null) {
			return "존재하지 않은 나라 번호";
		}
		else {
			StringBuffer buffer = new StringBuffer();
			buffer.append("국가번호 : " + countryDto.getCountryNo() + "<br>");
			buffer.append("국가명 : " + countryDto.getCountryName() + "<br>");
			buffer.append("수도명 : " + countryDto.getCountryCapital() + "<br>");
			buffer.append("인구수 : " + countryDto.getCountryPopulation() + "<br>");
			return buffer.toString();
		}
	}

}
