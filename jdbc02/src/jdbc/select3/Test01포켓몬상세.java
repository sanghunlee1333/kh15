package jdbc.select3;

import jdbc.dao.PokemonDao;
import jdbc.dto.PokemonDto;
import jdbc.mapper.PokemonMapper;

public class Test01포켓몬상세 {

	public static void main(String[] args) {
	
		//상세 조회
		//- 원하는 대상 1개만 조회하기 위한 작업
		//- 기본키(PK) 조건을 사용
		//- (문제) 목록/검색처럼 Mapper를 쓰면 List가 나온다
		//	- Mapper를 사용한다면 List의 맨 앞 데이터를 추출해야 한다.
		
		int pokemonNo = 21;
		
//		PokemonMapper pokemonMapper = new PokemonMapper();
		
//		JdbcTemplate jdbcTemplate = JdbcFactory.createTemplate();
//		String sql = "select * from pokemon where pokemon_no = ?";
//		Object[] data = {pokemonNo};
//		List<PokemonDto> list = jdbcTemplate.query(sql, pokemonMapper, data);
		
		
//		PokemonDto pokemonDto;
//		if(list.size() == 0) { //조회된 결과가 없으면
//			pokemonDto = null;
//		}
//		else { //1
//			pokemonDto = list.get(0); //리스트의 첫번째 방의 값(pokemonDto)을 꺼내 저장
//		}
		//PokemonDto pokemonDto = list.size() == 0 ? null : list.get(0);
//		PokemonDto pokemonDto = list.isEmpty() ? null : list.get(0);
		
		PokemonDao pokemonDao = new PokemonDao();
		PokemonDto pokemonDto = pokemonDao.selectOne(pokemonNo);
		
		if(pokemonDto == null) {
			System.out.println("존재하지 않는 포켓몬 번호");
		}
		else {
			System.out.println(pokemonDto);
		}
	}

}
