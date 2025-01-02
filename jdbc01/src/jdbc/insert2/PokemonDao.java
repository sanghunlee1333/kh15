package jdbc.insert2;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.util.JdbcFactory;

//DAO(Data Access Object)
//- DB의 특정 테이블에 대한 작업을 메소드별로 보관하는 클래스
//- 특정 테이블에 대한 CRUD 작업을 처리하기 위한 클래스

//메인에서 DB관련 코드가 안보이게 모듈화

public class PokemonDao {
	//등록 메소드 (비추천)
	//static(객체가 필요없는) 메소드로 만들지 않는 이유는 딱 포켓몬 테이블 관련해서만 쓸 것이기 때문
	//static은 포켓몬 테이블 말고 다른 테이블에서도 폭 넓게 쓸것이기 때문에 static으로 구현
//	public void insert(String pokemonName, String pokemonType) { //안에 넣어야될 갯수가 달라지는 것이 번거롭다. -> 단점
//		JdbcTemplate jdbctemplate = JdbcFactory.createTemplate();
//		String sql = "insert into pokemon(pokemon_no, pokemon_name, pokemon_type) "
//				+ "values(pokemon_seq.nextval, ?, ?)";
//		Object[] data = {pokemonName, pokemonType}; 
//		
//		jdbctemplate.update(sql, data);
//		
//	}
	
	//객체지향스러운 등록 메소드 (추천)
	public void insert(PokemonDto pokemonDto) {
		
		JdbcTemplate jdbctemplate = JdbcFactory.createTemplate();
		String sql = "insert into pokemon(pokemon_no, pokemon_name, pokemon_type) "
				+ "values(pokemon_seq.nextval, ?, ?)";
		Object[] data = {
			pokemonDto.getPokemonName(),
			pokemonDto.getPokemonType()
		};
		jdbctemplate.update(sql, data);
		
	}
	
}
