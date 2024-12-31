package jdbc.insert2;

public class Test01포켓몬등록 {

	public static void main(String[] args) {
		//포켓몬 등록이라 하면..
		//사용자에게 이름과 속성만 입력받아 전달하면 등록이 되어야 한다
		//나머지 코드들은 미리 준비해서 모듈화 시켜놓을 수 있지 않을까?
		
		//PokemonDao라는 이름의 클래스를 만들어 pokemon 테이블을 전담하도록 구성
		
		//DTO(Data Transfer Object) -> 변환객체(상자) - DB의 데이터 한 개에 대한 정보 
//		String pokemonName = "디그다";
//		String pokemonType = "땅";
		PokemonDto pokemonDto = new PokemonDto();
		pokemonDto.setPokemonName("버터플");
		pokemonDto.setPokemonType("바람");
		
		//DAO
		PokemonDao pokemonDao = new PokemonDao();
		//pokemonDao.insert(pokemonName, pokemonType);
		pokemonDao.insert(pokemonDto);
		
		System.out.println("등록 완료");
		
	}

}
