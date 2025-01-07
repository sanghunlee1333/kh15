package com.kh.spring06.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.kh.spring06.dto.CountryDto;

//이 클래스는 country 테이블을 조회(select)한 결과를 변환하는 클래스
//- 소모품이 아니기 때문에 싱글톤 방식을 쓰는 것이 효과적
//- 스프링에게 등록을 요청해서 관리 및 혜택을 받는다
//- @Component 라는 애노테이션으로 등록한다 (단위기능을 수행하는 도구)
@Component
public class CountryMapper implements RowMapper<CountryDto>{
	@Override
	public CountryDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		CountryDto countryDto = new CountryDto();
		countryDto.setCountryNo(rs.getInt("country_no"));
		countryDto.setCountryName(rs.getString("country_name"));
		countryDto.setCountryCapital(rs.getString("country_capital"));
		countryDto.setCountryPopulation(rs.getLong("country_population"));
		return countryDto;
	}
}