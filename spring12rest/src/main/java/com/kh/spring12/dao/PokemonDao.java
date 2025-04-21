package com.kh.spring12.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring12.dto.PokemonDto;
import com.kh.spring12.vo.SearchVO;

//DAO는 영속성 항목을 제어하는 도구
//- 영속성이라는건 파일이나 데이터베이스처럼 놔두면 영원히 유지되는것을 의미 
//- 예를 들어, 파일이나 데이터베이스에 저장된 데이터는 프로그램이 종료되더라도 사라지지 않고 계속 유지됨. 이와 같은 데이터를 다루는 방법을 영속성
//- DAO (Data Access Object) = 데이터베이스나 파일과 같은 저장소에서 데이터를 읽거나 쓰는 작업을 추상화해서 처리하는 도구. 즉, 데이터베이스와 연결하여 데이터를 저장하거나 불러오는 역할
//- 영속성 항목을 제어하는 도구들은 @Repository로 등록
@Repository
public class PokemonDao {

	// 여기서 필요로 하는 도구들을 등록된 도구중에서 가지고 온다(DI)
//	@Autowired
//	private JdbcTemplate jdbcTemplate; //Spring JDBC용 처리도구
	
	@Autowired
	private SqlSession sqlSession; //SqlSession = MyBatis에서 SQL 실행할 수 있게 해주는 핵심 도구
	// PokemonDao dao = new PokemonDao(); // 직접 객체를 만드는 방식
	/*
	@Autowired =  "이 변수에 쓸 객체를 스프링이 알아서 넣어줘!" 라는 뜻
	private PokemonDao dao;
	- 이렇게만 쓰면, 스프링이 알아서 PokemonDao 객체를 찾아서 넣어줌 = 의존성 주입(Dependency Injection, DI)
	 */
	
	
	//목록
	public List<PokemonDto> selectList() {
		//sqlSession을 이용해서 namespace="pokemon" 영역을 찾아 id="list"인 구문을 실행하세요!
		return sqlSession.selectList("pokemon.list");
	}
	
	//검색
	public List<PokemonDto> selectList(String column, String keyword){
		Map<String, Object> param = new HashMap<>(); // String: 키는 보통 이름이니까 문자열, Object: 값은 어떤 타입이든 올 수 있으니까 (String이든 int든 다 받을 수 있음)
		param.put("column", column);
		param.put("keyword", keyword);
		return sqlSession.selectList("pokemon.listOrSearch", param);
		
		/*
		 	- Map은 인터페이스(설계도). 그걸 구현한 게 여러 개 있음
		 	1. HashMap: 가장 기본적이고 빠른 일반 Map. 해시 함수를 이용해서 데이터의 위치(저장 위치)를 빠르게 찾아냄 -> 일반적인 상황엔 HashMap이 가장 빠르고 가벼워서 많이 씀.
			2. TreeMap: 키 순서대로 자동 정렬됨
		*/
	}
	
	//등록(1) - 시퀀스 자동생성
	//메서드에서 pokemonDto 객체를 파라미터로 전달할 때, MyBatis는 pokemonDto 객체의 pokemonName과 pokemonType 속성값을 
	//각각 #{pokemonName}과 #{pokemonType}에 바인딩. 
	//따라서 객체의 필드 이름과 MyBatis의 쿼리에서 사용하는 이름이 일치해야 함!
	public void insert(PokemonDto pokemonDto) {
		sqlSession.insert("pokemon.add", pokemonDto);
	}

	//등록(2) 시퀀스+등록
	public int sequence() {
		return sqlSession.selectOne("pokemon.sequence");
	}
	
	public void insert2(PokemonDto pokemonDto) {
		sqlSession.insert("pokemon.add2", pokemonDto);
	}
	
	//삭제 메소드
	public boolean delete(int pokemonNo) { //MyBatis는 update, delete 등의 SQL을 실행하고 나면 영향을 받은 행(row)의 개수를 int로 리턴
		return sqlSession.delete("pokemon.delete", pokemonNo) > 0;
	}
	
	//수정 메소드
	public boolean update(PokemonDto pokemonDto) {
		return sqlSession.update("pokemon.edit", pokemonDto) > 0;
	}
	
	//상세조회 메소드
	public PokemonDto selectOne(int pokemonNo) {
		return sqlSession.selectOne("pokemon.find", pokemonNo);
	}

	//검색에서처럼 Map 쓰는 방식 대신, 객체 형태인 SearchVO를 넘겨줌. SearchVO 안에 column, keyword가 들어 있으니까 MyBatis는 알아서 .getColumn(), .getKeyword()로 값을 꺼내 씀. 훨씬 깔끔하고 객체지향적인 방식!
	public List<PokemonDto> selectList(SearchVO searchVO) { 
		return sqlSession.selectList("pokemon.listOrSearch", searchVO);
	}
	
//	// 목록조회 메소드
//	public List<PokemonDto> selectList() {
//		String sql = "select * from pokemon order by pokemon_no asc";
//		return jdbcTemplate.query(sql, pokemonMapper);
//	}
//
//	// 검색에 사용할 컬럼에 대한 정보를 저장
//	private Map<String, String> columnExample = Map.of("이름", "pokemon_name", "속성", "pokemon_type");
//
//	// 검색 메소드
//	public List<PokemonDto> selectList(String column, String keyword) {
//		String columnName = columnExample.get(column);// 컬럼명 획득(없으면 null)
//		if (columnName == null) {
//			// return null;//없다고 말해주겠다
//			// return List.of();//결과가 비어있다고 말해주겠다
//			throw new RuntimeException("항목 오류");// 너는 문제가 있다고 말해주겠다
//		}
//
//		String sql = "select * from pokemon " + "where instr(" + columnName + ", ?) > 0 " + "order by " + columnName
//				+ " asc, pokemon_no asc";
//		Object[] data = { keyword };
//		return jdbcTemplate.query(sql, pokemonMapper, data);
//	}

//	// 포켓몬 이미지 등록(연결)
//	public void connect(int pokemonNo, int attachmentNo) {
//		String sql = "insert into pokemon_image (" + "pokemon_no, attachment_no" + ") values(?, ?)";
//		Object[] data = { pokemonNo, attachmentNo };
//		jdbcTemplate.update(sql, data);
//	}
//
//	// 포켓몬 이미지 찾기
//	// - 반환형이 int이기 때문에 만약 이미지가 없으면 예외가 발생함
//	public int findAttachment(int pokemonNo) { // Integer로도 가능함. 다만, 외부에서 null이 나올 경우를 처리해야 함
//		String sql = "select attachment_no from pokemon_image where pokemon_no = ?";
//		Object[] data = { pokemonNo };
//		return jdbcTemplate.queryForObject(sql, int.class, data);
//	}
//
//	////////////////////////////////
//	// 게시글 좋아요 관련 처리 기능
//	////////////////////////////////
//
//	// 좋아요 설정
//	public void insertPokemonLike(String memberId, int pokemonNo) {
//		String sql = "insert into pokemon_like(member_id, pokemon_no) values(?, ?)";
//		Object[] data = { memberId, pokemonNo };
//		jdbcTemplate.update(sql, data);
//	}
//
//	// 좋아요 해제
//	public void deletePokemonLike(String memberId, int pokemonNo) { // boolean도 가능
//		String sql = "delete pokemon_like where member_id = ? and pokemon_no = ?";
//		Object[] data = { memberId, pokemonNo };
//		jdbcTemplate.update(sql, data);
//	}
//
//	// 좋아요 검사
//	public boolean checkPokemonLike(String memberId, int pokemonNo) {
//		String sql = "select count(*) from pokemon_like where member_id = ? and pokemon_no = ?";
//		Object[] data = { memberId, pokemonNo };
//		return jdbcTemplate.queryForObject(sql, int.class, data) > 0;
//	}
//
//	//좋아요 개수
//	public int countPokemonLike(int pokemonNo) {
//		String sql = "select count(*) from pokemon_like where pokemon_no = ?";
//		Object[] data = { pokemonNo };
//		return jdbcTemplate.queryForObject(sql, int.class, data);
//	}
//
//	//좋아요 개수를 갱신하는 메소드
//	public boolean updatePokemonLike(int pokemonNo, int count) {
//		String sql = "update pokemon set pokemon_like = ? where pokemon_no = ?";
//		Object[] data = { count, pokemonNo };
//		return jdbcTemplate.update(sql, data) > 0;
//	}
//
//	public boolean updatePokemonLike(int pokemonNo) { // 니가 count를 세어서 넣어
//		String sql = "update pokemon set pokemon_like = (select count(*) from pokemon_like where pokemon_no = ?) where pokemon_no = ?";
//		Object[] data = { pokemonNo, pokemonNo }; // pokemonNo를 홀더 갯수에 맞게 두 번 넣어야함
//		return jdbcTemplate.update(sql, data) > 0;
//	}

}
