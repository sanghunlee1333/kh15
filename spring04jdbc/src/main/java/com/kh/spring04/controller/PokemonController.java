package com.kh.spring04.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PokemonController {
	
	//여기서 어떻게 JdbTemplate를 쓴다는 건가?
	//- 만드는 건 안됨 (스프링을 쓸 필요가 없음)
	//- 만들어진 걸 달라고 해야됨(의존성 주입(DI), 주세요~)
	@Autowired //이 변수에 맞는 것을 알아서 넣어주세요
	private JdbcTemplate jdbcTemplate;
	
	@RequestMapping("/insert")
	public String insert(@RequestParam String pokemonName,
						@RequestParam String pokemonType){
		String sql = "insert into pokemon("
				+ "pokemon_no, pokemon_name, pokemon_type"
				+ ") values(pokemon_seq.nextval, ?, ?)";
		Object[] data = {pokemonName, pokemonType};
		jdbcTemplate.update(sql, data);
		return "포켓몬 등록 완료";
	}
	
	
}
