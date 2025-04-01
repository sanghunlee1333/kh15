package com.kh.spring12.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring12.dto.PokemonDto;

@SpringBootTest
public class Test04마이바티스수정 {

	@Autowired
	private SqlSession sqlSession; //myBatis용 처리도구
	
	@Test
	public void test() {
		PokemonDto pokemonDto = new PokemonDto();
		pokemonDto.setPokemonNo(79);
		pokemonDto.setPokemonName("이름바꾼몬");
		pokemonDto.setPokemonType("전기");
		
		int count = sqlSession.update("pokemon.edit", pokemonDto);
		System.out.println("count = " + count);
	}
}
