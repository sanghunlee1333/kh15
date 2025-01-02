package jdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.CountryDto;
import jdbc.mapper.CountryMapper;
import jdbc.util.JdbcFactory;

public class CountryDao {
	
	public void insert(CountryDto countryDto) {
		JdbcTemplate jdbctemplate = JdbcFactory.createTemplate();
		String sql = "insert into country(country_no, country_name, country_capital, country_population) "
				+ "values(country_seq.nextval, ?, ?, ?)";
		Object[] data = {countryDto.getCountryName(), countryDto.getCountryCapital(), countryDto.getCountryPopulation()};
		
		jdbctemplate.update(sql, data);
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
	
	public boolean delete(int countryNo) {
		JdbcTemplate jdbcTemplate = JdbcFactory.createTemplate();
		String sql = "delete country where country_no = ?";
		Object[] data = {countryNo};
		return jdbcTemplate.update(sql, data) > 0;
	}
	
	private CountryMapper countryMapper = new CountryMapper();
	
	public List<CountryDto> selectList() {
		JdbcTemplate jdbcTemplate = JdbcFactory.createTemplate();
		String sql = "select * from country";
		return jdbcTemplate.query(sql, countryMapper);
	}
	
}
