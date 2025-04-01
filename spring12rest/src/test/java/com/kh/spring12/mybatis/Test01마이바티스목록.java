package com.kh.spring12.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring12.dto.PokemonDto;

@SpringBootTest
public class Test01마이바티스목록 {

//	@Autowired
//	private JdbcTemplate jdbcTemplate; //Spring JDBC용 처리도구
	
	@Autowired
	private SqlSession sqlSession; //myBatis용 처리도구
	
	@Test
	public void test() {
		List<PokemonDto> list = sqlSession.selectList("pokemon.list");
		System.out.println("조회 결과 : " + list.size());
		for(PokemonDto pokemonDto : list) {
			System.out.println(pokemonDto);
		}
	}
}
