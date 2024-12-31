package jdbc.insert2;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.util.JdbcFactory;

public class CountryDao {
	
	public void insert(CountryDto countryDto) {
		JdbcTemplate jdbctemplate = JdbcFactory.createTemplate();
		String sql = "insert into country(country_no, country_name, country_capital, country_population) "
				+ "values(country_seq.nextval, ?, ?, ?)";
		Object[] data = {countryDto.getCountryName(), countryDto.getCountryCapital(), countryDto.getCountryPopulation()};
		
		jdbctemplate.update(sql, data);
	}
	
}
