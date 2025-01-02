package jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import jdbc.dto.CountryDto;

public class CountryMapper implements RowMapper<CountryDto>{

	@Override
	public CountryDto mapRow(ResultSet rs, int arg1) throws SQLException {
		
		CountryDto countryDto = new CountryDto();
		countryDto.setCountryNo(rs.getInt("country_no"));
		countryDto.setCountryName(rs.getString("country_name"));
		countryDto.setCountryCapital(rs.getString("country_capital"));
		countryDto.setCountryPopulation(rs.getLong("country_population"));
		
		return countryDto;
	}
	
	

	
	
}
