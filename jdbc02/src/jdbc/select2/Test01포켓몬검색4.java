package jdbc.select2;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dao.PokemonDao;
import jdbc.dto.PokemonDto;
import jdbc.mapper.PokemonMapper;
import jdbc.util.JdbcFactory;

public class Test01포켓몬검색4 {

	public static void main(String[] args) throws Exception {
						
		//입력
		String column = "이름";
		String keyword = "리자몽";
//		String column = "속성";
//		String keyword = "불";
		
		PokemonDao pokemonDao = new PokemonDao();
		List<PokemonDto> list = pokemonDao.selectList(column, keyword);
		//상세와 달리 리스트 결과가 여러개의 Dto가 나올 수 있으므로 List로 구현
				
		for(PokemonDto pokemonDto : list) {
			System.out.println(pokemonDto);
		}
		
		
	}

}
