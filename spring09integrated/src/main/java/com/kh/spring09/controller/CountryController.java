package com.kh.spring09.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring09.dao.CountryDao;
import com.kh.spring09.dto.CountryDto;
import com.kh.spring09.dto.PokemonDto;

@Controller
@RequestMapping("/country")
public class CountryController {

	@Autowired
	private CountryDao countryDao;
	
	@GetMapping("/add")
	public String add() {
		return "/WEB-INF/views/country/add.jsp";
	}
	
	@PostMapping("/add")
	public String add(@ModelAttribute CountryDto countryDto) { //메소드 오버로딩
		countryDao.insert(countryDto);
		return "redirect:addFinish"; //상대 경로
		//return "redirect:/country/addFinish"; //절대 경로 - 둘다 상관없지만 add.jsp파일 바로 옆에 Finish파일이 있으므로 상대 경로 사용
	}
	
	@RequestMapping("/addFinish")
	public String addFinish() {
		return "/WEB-INF/views/country/addFinish.jsp";
	}
	
	//목록 + 검색 매핑
	@RequestMapping("/list")
	public String list(@RequestParam(required = false) String column,
						@RequestParam(required = false) String keyword,
						Model model) {
		boolean search = column != null && keyword != null;
		List<CountryDto> list = search ? countryDao.selectList(column, keyword) : countryDao.selectList();
		
		model.addAttribute("search", search);
		model.addAttribute("column", column);
		model.addAttribute("keyword", keyword);
		model.addAttribute("list", list);
		
		return "/WEB-INF/views/country/list.jsp";
	}
	
	//상세 매핑
	@RequestMapping("/detail")
	public String detail(@RequestParam int countryNo, Model model) {
		CountryDto countryDto = countryDao.selectOne(countryNo);
		model.addAttribute("countryDto", countryDto);
		return "/WEB-INF/views/country/detail.jsp";
	}
	
	//삭제 매핑
	@RequestMapping("/delete")
	public String delete(@RequestParam int countryNo) {
		countryDao.delete(countryNo);
		return "redirect:list";
	}
	
	//수정 매핑
	@GetMapping("/edit")
	public String edit(@RequestParam int countryNo, Model model) {
		CountryDto countryDto = countryDao.selectOne(countryNo);
		model.addAttribute("countryDto", countryDto);
		return "/WEB-INF/views/country/edit.jsp";
	}
	
	@PostMapping("/edit")
	public String edit(@ModelAttribute CountryDto countryDto) {
		boolean success = countryDao.update(countryDto);
		if(success) {
			return "redirect:detail?countryNo="+countryDto.getCountryNo();
		}
		else {
			return "redirect:list";
		}
	}
	
	@RequestMapping("/edit")
	public String edit(@ModelAttribute CountryDto countryDto, Model model) {
		countryDao.update(countryDto);
		return "/WEB-INF/views/country/edit.jsp";
	}
	
	
	
}
