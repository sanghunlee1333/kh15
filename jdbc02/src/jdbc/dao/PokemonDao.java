package jdbc.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.PokemonDto;
import jdbc.mapper.PokemonMapper;
import jdbc.util.JdbcFactory;

//DAO(Data Access Object)
//- DB의 특정 테이블에 대한 작업을 메소드별로 보관하는 클래스
//- 특정 테이블에 대한 CRUD 작업을 처리하기 위한 클래스

//메인에서 DB관련 코드가 안보이게 모듈화

public class PokemonDao {

	//객체지향스러운 등록 메소드 
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
	
	//수정 메소드(포켓몬 한마리를 받아서 수정된 데이터가 있는지 없는지 반환)
	public boolean update(PokemonDto pokemonDto) {
		JdbcTemplate jdbcTemplate = JdbcFactory.createTemplate();
		String sql = "update pokemon set pokemon_name = ?, pokemon_type = ? where pokemon_no = ?";
		Object[] data = {
				pokemonDto.getPokemonName(), pokemonDto.getPokemonType(), pokemonDto.getPokemonNo()
		};
		//int 반환. 적용된 rows 갯수를 반환
		int rows = jdbcTemplate.update(sql, data);
		
//		if(rows > 0 ) { //rows가 0보다 크면 true를 반환하고
//			return true;
//		} 아니면 false 반환
//		else return false;
		
		return rows > 0; //rows가 0보다 큰지 비교해서 반환하세요
		
	}
	
	//삭제 메소드
	public boolean delete(int pokemonNo) { //Dto(포켓몬 정보)로 메소드 매개변수로 받아도 되지만, 1개이므로 그냥 int(PK)로 메소드 매개변수로 받아도 된다
		JdbcTemplate jdbcTemplate = JdbcFactory.createTemplate();
		String sql = "delete pokemon where pokemon_no = ?";
		// 1개여도 무조건 배열을 써야한다.
		Object[] data = {pokemonNo};	
//		int rows = jdbcTemplate.update(sql, data);
//		return rows > 0;
		return jdbcTemplate.update(sql, data) > 0;
	}
	
	//조회를 위한 Mapper를 필드로 선언
	private PokemonMapper pokemonMapper = new PokemonMapper();
	
	//목록 조회 메소드
	public List<PokemonDto> selectList() {
		JdbcTemplate jdbcTemplate = JdbcFactory.createTemplate();
		String sql = "select * from pokemon";
		return jdbcTemplate.query(sql, pokemonMapper);
	}
	
	//검색에 사용할 컬럼에 대한 정보를 저장
	private Map<String, String> columnExamples = Map.of(
		"이름", "pokemon_name",
		"속성", "pokemon_type"
	);
	
	//검색 메소드
	public List<PokemonDto> selectList(String column, String keyword) {
		String columnName = columnExamples.get(column); //컬럼명 획득(없으면 null)
		if(columnName == null) {
			//return null; //없다고 말해주겠다 //비추천
			//return List.of(); //결과가 비어있다고 말해주겠다
			throw new RuntimeException("항목 오류"); //너는 문제가 있다고 말해주겠다 //런타임익셉션은 전가를 하지 않아도 됨
		}
		
		JdbcTemplate jdbcTemplate = JdbcFactory.createTemplate();
		String sql = "select * from pokemon "
				+ "where instr(" + columnName + ", ?) > 0 " //columnName -> 정적할당, ?(홀더) -> 동적할당(데이터에) // 가공하냐 않하냐의 차이
				+ "order by " + columnName + " asc, pokemon_no asc";
		Object[] data = {keyword};
		return jdbcTemplate.query(sql,pokemonMapper,data); //sql(구문)은 무조건 처음, data는 무조건 마지막에 
		
	}
	
	//상세조회 메소드
	public PokemonDto selectOne(int pokemonNo) {
		JdbcTemplate jdbcTemplate = JdbcFactory.createTemplate();
		String sql = "select * from pokemon where pokemon_no = ?";
		Object[] data = {pokemonNo};
		List<PokemonDto> list = jdbcTemplate.query(sql, pokemonMapper, data); //query의 반환형이 List인데, 목록에서 NO만을 꺼내야 한다
		return list.isEmpty() ? null : list.get(0); //PK이므로 어차피 list에는 1개만 있든지 아니면 없든지 이므로, 있다면 0번째 방에 있는 것을 꺼내면 된다. 
	}
	
}
