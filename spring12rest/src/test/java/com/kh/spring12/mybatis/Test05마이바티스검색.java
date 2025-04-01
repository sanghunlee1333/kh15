package com.kh.spring12.mybatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring12.dto.PokemonDto;

@SpringBootTest
public class Test05마이바티스검색 {

	@Autowired
	private SqlSession sqlSession; //myBatis용 처리도구
	
	@Test
	public void test() {
		//*중요* 마이바티스는 데이터를 한 개만 전달할 수 있다
		Map<String, Object> param = new HashMap<>();
		param.put("column", "pokemon_name");
		param.put("keyword", "피카");
		
//		List<PokemonDto> list = sqlSession.selectList("pokemon.search", param);
		List<PokemonDto> list = sqlSession.selectList("pokemon.listOrSearch", param);
		System.out.println("결과 수 : "+list.size());
		for(PokemonDto pokemonDto : list) {
			System.out.println(pokemonDto);
		}
	}
	
}
