package jdbc.select2;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.PokemonDto;
import jdbc.mapper.PokemonMapper;
import jdbc.util.JdbcFactory;

public class Test01포켓몬검색 {

	public static void main(String[] args) {
	
		//입력
		String column = "속성";
		String keyword = "불";
		
		//처리
		PokemonMapper pokemonMapper = new PokemonMapper();
		
		if(column.equals("이름")) {
			JdbcTemplate jdbcTemplate = JdbcFactory.createTemplate();
			String sql = "select * from pokemon "
					+ "where instr(pokemon_name, ?) > 0 "
					+ "order by pokemon_name asc, pokemon_no asc";
			Object[] data = {keyword};
			List<PokemonDto> list = jdbcTemplate.query(sql,pokemonMapper,data); //sql(구문)은 무조건 처음, data는 무조건 마지막에 
			for(PokemonDto pokemonDto : list) {
				System.out.println(pokemonDto);
			}
		}
		else if(column.equals("속성")) {
			JdbcTemplate jdbcTemplate = JdbcFactory.createTemplate();
			String sql = "select * from pokemon "
					+ "where instr(pokemon_type, ?) > 0 "
					+ "order by pokemon_type asc, pokemon_no asc";
			Object[] data = {keyword};
			List<PokemonDto> list = jdbcTemplate.query(sql,pokemonMapper,data); //sql(구문)은 무조건 처음, data는 무조건 마지막에 
			for(PokemonDto pokemonDto : list) {
				System.out.println(pokemonDto);
			}
		}
		
	}

}
