package jdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.CountryDto;
import jdbc.util.JdbcFactory;

public class CountryDao {
	
	public void insert(CountryDto countryDto) {
		
	}
	
	public boolean update(CountryDto countryDto) {
		JdbcTemplate jdbcTemplate = JdbcFactory.createTemplate();
		String sql = "update country set country_name = ?, country_capital = ?, country_population = ? where country_no = ?";
		Object[] data = {
			
				countryDto.getCountryName(), countryDto.getCountryCapital(), countryDto.getCountryPopulation(), countryDto.getCountryNo()
				
		};
		int rows = jdbcTemplate.update(sql, data);
		
		return rows > 0;
	}
	
}
