package jdbc.dao;

import java.util.List;
import java.util.Map;

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
	
	private Map<String, String> columnExamples = Map.of(
		"국가명", "country_name",
		"수도명", "country_capital"
	);
	
	public List<CountryDto> selectList(String column, String keyword){
		//컬럼 변환
		String columnName = columnExamples.get(column);
		if(columnName == null) throw new RuntimeException("항목 오류");
		
		JdbcTemplate jdbcTemplate = JdbcFactory.createTemplate();
		String sql = "select * from country "
				+ "where instr(#1, ?) > 0 "
				+ "order by #1 asc, country_no asc";
		sql = sql.replace("#1", columnName);
		Object[] data = {keyword};
		return jdbcTemplate.query(sql, countryMapper, data);
		
	}
	
	public CountryDto selectOne(int countryNo) {
		JdbcTemplate jdbcTemplate = JdbcFactory.createTemplate();
		String sql = "select * from country where country_no = ?";
		Object[] data = {countryNo};
		List<CountryDto> list = jdbcTemplate.query(sql, countryMapper, data);
		return list.isEmpty() ? null : list.get(0);
	}
			
	
}
