package com.kh.spring05.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring05.dao.PokemonDao;
import com.kh.spring05.dto.PokemonDto;

@RestController
@RequestMapping("/pokemon")//공용주소
public class PokemonController {
	
	@Autowired
	private PokemonDao pokemonDao;
	
	//등록 매핑
	//- @RequestParam은 파라미터 1개를 받는 명령
	//- @ModelAttribute는 가능한 모든 파라미터를 받는 명령
	@RequestMapping("/insert")//상세주소
	//public String insert(@RequestParam String pokemonName,
	//							@RequestParam String pokemonType) {
	public String insert(@ModelAttribute PokemonDto pokemonDto) {
		pokemonDao.insert(pokemonDto);
		return "포켓몬 등록 완료";
	}
	
	//수정 매핑
	@RequestMapping("/update")
	public String update(@ModelAttribute PokemonDto pokemonDto) {
		boolean success = pokemonDao.update(pokemonDto);
		return success ? "포켓몬 변경 완료" : "존재하지 않는 포켓몬 번호";
	}
	
	//삭제 매핑
	@RequestMapping("/delete")
	public String delete(@RequestParam int pokemonNo) {
		boolean success = pokemonDao.delete(pokemonNo);
		return success ? "포켓몬 삭제 완료" : "존재하지 않는 포켓몬 번호";
	}
	
	//목록 조회 매핑
	@RequestMapping("/list")
	public String list() {
		List<PokemonDto> list = pokemonDao.selectList();
		StringBuffer buffer = new StringBuffer();
		for(PokemonDto pokemonDto : list) {
			//System.out.println(pokemonDto);
			buffer.append(pokemonDto.toString());
			buffer.append("<br>");
		}
		return buffer.toString();
	}
	
	//검색 매핑
	//- column, keyword라는 항목을 전달받아 유사한 항목을 검색
	@RequestMapping("/search")
	public String list(@RequestParam String column, 
						@RequestParam String keyword) {
		List<PokemonDto> list = pokemonDao.selectList(column, keyword);
		StringBuffer buffer = new StringBuffer();
		buffer.append("검색 결과 수 : " + list.size() + "<br>");
		for(PokemonDto pokemonDto : list) {
			//System.out.println(pokemonDto);
			buffer.append(pokemonDto.toString());
			buffer.append("<br>");
		}
		return buffer.toString();
	}
	
	//상세 조회 매핑
	@RequestMapping("/detail")
	public String detail(@RequestParam int pokemonNo) {
		PokemonDto pokemonDto = pokemonDao.selectOne(pokemonNo);
		if(pokemonDto == null) {
			return "존재하지 않는 포켓몬 번호";
		}
		else {
			return pokemonDto.toString();
		}
	}
}



