package jdbc.insert;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Test01포켓몬등록 {

	public static void main(String[] args) {
		
		//연결 정보를 생성
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe"); //오라클의 위치
		dataSource.setUsername("kh15");
		dataSource.setPassword("kh15");
		
		//연결 도구를 생성
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource); //연결 정보를 설정
		
		//실행할 구문을 생성 (마지막에 세미콜론 작성 금지)
		String sql = "insert into pokemon(pokemon_no, pokemon_name, pokemon_type"
		+ ") "
		+ "values(pokemon_seq.nextval, '테스트몬', '바람')";
		
		//실행
		jdbcTemplate.update(sql);
		System.out.println("실행 완료");
	}

}
