package jdbc.select;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.PokemonDto;
import jdbc.mapper.PokemonMapper;
import jdbc.util.JdbcFactory;

public class Test01포켓몬조회 {

	public static void main(String[] args) {
		
		//포켓몬 목록 -> 
		//1. Pokemon[] -> 길이가 고정이라 쉽진 않다.
		//2. List<PokemonDto> -> RowMapper 사용 (오라클 테이블의 어떤 항목을 자바의 필드와 어떻게 매핑할지 결정 -> 데이터베이스 한줄한줄 전부 매핑해줄 필요도 없어짐)
		
		//select는 데이터베이스 조회 결과를 자바로 옮겨와야 한다
		//- insert, update, delete와는 데이터의 방향이 반대
		//- 자바에서는 데이터베이스 조회 결과를 ResultSet이라고 부름
		//- 최종적으로 만들어야내는 형태는 List<PokemonDto>이다
		//- 자바에서는 ResultSet의 한 줄을 PokemonDto로 바꿀 줄 모른다
		//- 개발자가 RowMapper라는 클래스를 만들어서 알려줘야 한다
		//- RowMapper는 인터페이스라서 직접적인 인스턴스 생성이 어려움
		//- PokemonMapper 클래스를 만들어서 상속받아 구현
		
		PokemonMapper pokemonMapper = new PokemonMapper();
		
		JdbcTemplate jdbcTemplate = JdbcFactory.createTemplate();
		String sql = "select * from pokemon";
		//Object[] data = {};
		
		List<PokemonDto> list = jdbcTemplate.query(sql, pokemonMapper);
		for(PokemonDto pokemonDto : list) {
			System.out.println(pokemonDto);
		}
		
		
	}

}
