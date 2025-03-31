package com.kh.spring12;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring12.dto.PokemonDto;

@SpringBootTest
public class Test02마이바티스등록 {

	@Autowired
	private SqlSession sqlSession; //myBatis용 처리도구
	
	@Test
	public void test() {
		//myBatis에서는 등록 시 DTO 객체를 전송하면 된다
		PokemonDto pokemonDto = new PokemonDto();
		pokemonDto.setPokemonName("오크몬");
		pokemonDto.setPokemonType("땅");
		
		sqlSession.insert("pokemon.add", pokemonDto);
		//jdbcTemplate.update(sql, data);
		
	}
}
