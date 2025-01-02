package jdbc.select;

import java.util.List;

import jdbc.dao.PokemonDao;
import jdbc.dto.PokemonDto;

public class Test01포켓몬조회2 {

	public static void main(String[] args) {

		PokemonDao pokemonDao = new PokemonDao();
		List<PokemonDto> list = pokemonDao.selectList();
		
		for(PokemonDto pokemonDto : list) {
			System.out.println(pokemonDto);
		}
		
		
	}

}
