package jdbc.select2;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.PokemonDto;
import jdbc.mapper.PokemonMapper;
import jdbc.util.JdbcFactory;

public class Test01포켓몬검색2 {

	public static void main(String[] args) throws Exception {
		//검색 가능한 항목을 미리 저장해두고 꺼내서 사용하도록 구현
		Map<String, String> example = Map.of( //Key - Value(이름 - pokemon_name)
				"이름", "pokemon_name",
				"속성", "pokemon_type"
		);
				
		//입력
		String column = "이름";
		String keyword = "디그다";
//		String column = "속성";
//		String keyword = "불";
		
		//column에 의해 검색해야하는 항목만 구해낼 수 있다면 구문을 통일
		//String columnName = "pokemon_name" or "pokemon_type";
		//스위치 방법
//		String columnName;
//		switch(column) {
//		case "이름" : columnName = "pokemon_name"; break;
//		case "속성" : columnName = "pokemon_type"; break;
//		default : //나머지는 예외상황(원치 않는 상황)
//			throw new Exception("지원하지 않는 검색항목");
//		}
		
		//맵 방법
		String columnName = example.get(column); 
		if(columnName == null) {
			throw new Exception("지원하지 않는 검색항목");
		}
		
		//처리
		PokemonMapper pokemonMapper = new PokemonMapper();
		
		if(column.equals("이름")) {
			JdbcTemplate jdbcTemplate = JdbcFactory.createTemplate();
			String sql = "select * from pokemon "
					+ "where instr(" + columnName + ", ?) > 0 " //columnName -> 정적할당, ?(홀더) -> 동적할당(데이터에) // 가공하냐 않하냐의 차이
					+ "order by " + columnName + " asc, pokemon_no asc";
			Object[] data = {keyword};
			List<PokemonDto> list = jdbcTemplate.query(sql,pokemonMapper,data); //sql(구문)은 무조건 처음, data는 무조건 마지막에 
			for(PokemonDto pokemonDto : list) {
				System.out.println(pokemonDto);
			}
		}
//		else if(column.equals("속성")) {
//			JdbcTemplate jdbcTemplate = JdbcFactory.createTemplate();
//			String sql = "select * from pokemon "
//					+ "where instr(pokemon_type, ?) > 0 "
//					+ "order by pokemon_type asc, pokemon_no asc";
//			Object[] data = {keyword};
//			List<PokemonDto> list = jdbcTemplate.query(sql,pokemonMapper,data); //sql(구문)은 무조건 처음, data는 무조건 마지막에 
//			for(PokemonDto pokemonDto : list) {
//				System.out.println(pokemonDto);
//			}
//		}
		
	}

}
