package com.kh.spring12.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring12.dto.PokemonDto;

@SpringBootTest
public class Test02마이바티스등록2 {

	@Autowired
	private SqlSession sqlSession; //myBatis용 처리도구
	
	@Test
	public void test() {
		//myBatis에서는 등록 시 DTO 객체를 전송하면 된다
		int pokemonNo = sqlSession.selectOne("pokemon.sequence");
		
		PokemonDto pokemonDto = new PokemonDto();
		pokemonDto.setPokemonNo(pokemonNo);
		pokemonDto.setPokemonName("디그다");
		pokemonDto.setPokemonType("불");
		
		sqlSession.insert("pokemon.add2", pokemonDto);
		//jdbcTemplate.update(sql, data);
		
	}
}
