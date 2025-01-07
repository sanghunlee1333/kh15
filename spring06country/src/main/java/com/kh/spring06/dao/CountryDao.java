package com.kh.spring06.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring06.dto.CountryDto;
import com.kh.spring06.mapper.CountryMapper;

//DAO는 영속성 항목을 제어하는 도구
//- 영속성이라는건 파일이나 데이터베이스처럼 놔두면 영원히 유지되는것을 의미
//- 영속성 항목을 제어하는 도구들은 @Repository로 등록
@Repository
public class CountryDao {
	
	//여기서 필요로 하는 도구들을 등록된 도구중에서 가지고 온다(DI)
		@Autowired //등록된 도구들만 Autowired로 사용할 수 있다. 당연히 없는 도구는 못함, 어노테이션은 하나밖에 적용을 못함
		private CountryMapper countryMapper;
		@Autowired //그래서 각각 만들어줘야 한다
		private JdbcTemplate jdbcTemplate;
		
		public void insert(CountryDto countryDto) {
			String sql = "insert into country(country_no, country_name, country_capital, country_population) "
					+ "values(country_seq.nextval, ?, ?, ?)";
			Object[] data = {countryDto.getCountryName(), countryDto.getCountryCapital(), countryDto.getCountryPopulation()};
			
			jdbcTemplate.update(sql, data);
		}
		
		public boolean update(CountryDto countryDto) {
			String sql = "update country set country_name = ?, country_capital = ?, country_population = ? where country_no = ?";
			Object[] data = {
				
					countryDto.getCountryName(), countryDto.getCountryCapital(), countryDto.getCountryPopulation(), countryDto.getCountryNo()
					
			};
			int rows = jdbcTemplate.update(sql, data);
			
			return rows > 0;
		}
		
		public boolean delete(int countryNo) {
			String sql = "delete country where country_no = ?";
			Object[] data = {countryNo};
			return jdbcTemplate.update(sql, data) > 0;
		}
				
		public List<CountryDto> selectList() {
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
			
			String sql = "select * from country "
					+ "where instr(#1, ?) > 0 "
					+ "order by #1 asc, country_no asc";
			sql = sql.replace("#1", columnName);
			Object[] data = {keyword};
			return jdbcTemplate.query(sql, countryMapper, data);
			
		}
		
		public CountryDto selectOne(int countryNo) {
			String sql = "select * from country where country_no = ?";
			Object[] data = {countryNo};
			List<CountryDto> list = jdbcTemplate.query(sql, countryMapper, data);
			return list.isEmpty() ? null : list.get(0);
		}
	
		

}
