package jdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.PokemonDto;
import jdbc.util.JdbcFactory;

//DAO(Data Access Object)
//- DB의 특정 테이블에 대한 작업을 메소드별로 보관하는 클래스
//- 특정 테이블에 대한 CRUD 작업을 처리하기 위한 클래스

//메인에서 DB관련 코드가 안보이게 모듈화

public class PokemonDao {

	//객체지향스러운 등록 메소드 
	public void insert(PokemonDto pokemonDto) {
		
	}
	
	//수정 메소드(포켓몬 한마리를 받아서 수정된 데이터가 있는지 없는지 반환)
	public boolean update(PokemonDto pokemonDto) {
		JdbcTemplate jdbcTemplate = JdbcFactory.createTemplate();
		String sql = "update pokemon set pokemon_name = ?, pokemon_type = ? where pokemon_no = ?";
		Object[] data = {
				pokemonDto.getPokemonName(), pokemonDto.getPokemonType(), pokemonDto.getPokemonNo()
		};
		//int 반환. 적용된 rows 갯수를 반환
		int rows = jdbcTemplate.update(sql, data);
		
//		if(rows > 0 ) { //rows가 0보다 크면 true를 반환하고
//			return true;
//		} 아니면 false 반환
//		else return false;
		
		return rows > 0; //rows가 0보다 큰지 비교해서 반환하세요
		
	}
	
}
