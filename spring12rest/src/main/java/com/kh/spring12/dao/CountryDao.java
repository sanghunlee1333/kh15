package com.kh.spring12.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring12.dto.CountryDto;

//DAO는 영속성 항목을 제어하는 도구
//- 영속성이라는건 파일이나 데이터베이스처럼 놔두면 영원히 유지되는것을 의미
//- 영속성 항목을 제어하는 도구들은 @Repository로 등록
@Repository
public class CountryDao {

	@Autowired
	private SqlSession sqlSession;

	// 등록 메소드
	public void insert(CountryDto countryDto) {
		sqlSession.insert("country.add", countryDto);
	}
	// 시퀀스생성+등록 메소드
	public long sequence() {
		return sqlSession.selectOne("country.sequence");
	}
	public void insert2(CountryDto countryDto) {
		sqlSession.insert("country.add2", countryDto);
	}

	// 수정 메소드
	public boolean update(CountryDto countryDto) {
		return sqlSession.update("country.edit", countryDto) > 0;
	}
	public boolean updateUnit(CountryDto countryDto) {
		return sqlSession.update("country.editUnit", countryDto) > 0;
	}

	// 삭제 메소드
	public boolean delete(long countryNo) {
		return sqlSession.delete("country.delete", countryNo) > 0;
	}

	// 조회 메소드
	public List<CountryDto> selectList() {
		return sqlSession.selectList("country.list");
	}

	// 상세조회 메소드
	public CountryDto selectOne(long countryNo) {
		return sqlSession.selectOne("country.find", countryNo);
	}



}
