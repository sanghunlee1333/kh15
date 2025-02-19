package com.kh.spring10.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring10.dao.PokemonDao;

@CrossOrigin
@RestController
@RequestMapping("/pokemon")
public class PokemonRestController {
		
	@Autowired
	private PokemonDao pokemonDao;
	
	//포켓몬스터 이름이 사용중인지 알려주는 매핑
	@GetMapping("/check")
	public boolean check(@RequestParam String pokemonName) {
		//List<PokemonDto> list = pokemonDao.selectListByName(pokemonName);
		int count = pokemonDao.countByPokemonName(pokemonName);
		return count > 0;
	}
	
	
	
}
