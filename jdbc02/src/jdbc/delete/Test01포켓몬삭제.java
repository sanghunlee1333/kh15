package jdbc.delete;

import jdbc.dao.PokemonDao;

public class Test01포켓몬삭제 {

	public static void main(String[] args) {
		//목표 : 원하는 번호(PK)의 포켓몬 정보를 삭제
		
		int pokemonNo = 26; 
		
		PokemonDao pokemonDao = new PokemonDao();
		boolean success = pokemonDao.delete(pokemonNo);
		
		if(success) System.out.println("삭제 완료");
		else System.out.println("존재하지 않는 포켓몬 번호");
		
	}

}
