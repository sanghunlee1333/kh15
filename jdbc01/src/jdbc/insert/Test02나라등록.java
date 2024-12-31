package jdbc.insert;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Test02나라등록 {

	public static void main(String[] args) {

		// 연결 정보를 생성 - dbeaver에서 확인 가능, 자바에서는 매번 생성해야 함
		// 드라이버 - 장치와 운영체제가 서로 대화할 수 있도록 도와주는 프로그램 
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe"); // 오라클의 위치
		dataSource.setUsername("kh15");
		dataSource.setPassword("kh15");

		// 연결 도구를 생성 - 연결하는 직원
		//JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource); (강의 다시)
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource); // 연결 정보를 설정
		

		// 실행할 구문을 생성 (마지막에 세미콜론 작성 금지)
		String sql = "insert into country(country_no, country_name, country_capital, country_population" + ") "
				+ "values(country_seq.nextval, '일본', '도쿄', 120000000)";

		// 실행
		jdbcTemplate.update(sql);
		System.out.println("실행 완료");
	}

}
