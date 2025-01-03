package jdbc.util;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JdbcFactory {

	//모듈화
		//사용자가 쉽게 이용 가능하도록 JdbcTemplate을 생성하는 메소드
		public static JdbcTemplate createTemplate() { //반환형이 JdbcTemplate
			DriverManagerDataSource dataSource = new DriverManagerDataSource();
			dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
			dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe"); 
			dataSource.setUsername("kh15");
			dataSource.setPassword("kh15");

			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			return jdbcTemplate;
		}
}
