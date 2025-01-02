package jdbc.update;

import jdbc.dao.PokemonDao;
import jdbc.dto.PokemonDto;

public class Test01포켓몬수정 {

	public static void main(String[] args) {
		//목표 : 포켓몬스터 정보를 변경하는 코드 작성(main에 전부 다 작성)
		// * JDBC는 구문이 정해져야 한다
		
		//입력
//		int pokemonNo = 1;
//		String pokemonName = "바꾼이름";
//		String pokemonType = "전기";
		PokemonDto pokemonDto = new PokemonDto();
		pokemonDto.setPokemonName("바꾼이름");
		pokemonDto.setPokemonType("불");
		pokemonDto.setPokemonNo(21);
		
		//처리
//		JdbcTemplate jdbcTemplate = JdbcFactory.createTemplate();
//		String sql = "update pokemon set pokemon_name = ?, pokemon_type = ? where pokemon_no = ?";
//		Object[] data = {
//				pokemonName, pokemonType, pokemonNo
//		};
//		//int 반환. 적용된 rows 갯수를 반환
//		int rows = jdbcTemplate.update(sql, data);
//		System.out.println("rows = " + rows);
		
		PokemonDao pokemonDao = new PokemonDao();
		boolean success = pokemonDao.update(pokemonDto);		
		
		//출력
		if(success) {
			System.out.println("수정 완료");
		}
		else {
			System.out.println("대상이 없습니다");
		}
	}

}
