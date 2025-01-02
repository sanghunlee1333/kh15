package jdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.LectureDto;
import jdbc.mapper.LectureMapper;
import jdbc.util.JdbcFactory;

public class LectureDao {
	
	public void insert(LectureDto lectureDto) {
		
		JdbcTemplate jdbcTemplate = JdbcFactory.createTemplate();
		String sql = "insert into lecture(lecture_no, lecture_name, lecture_category, lecture_period, lecture_price, lecture_type) "
				+ "values(lecture_seq.nextval, ?, ?, ?, ?, ?)";
		Object[] data = {
			
			lectureDto.getLectureName(), lectureDto.getLectureCategory(), lectureDto.getLecturePeriod(), 
			lectureDto.getLecturePrice(), lectureDto.getLectureType()
				
		};
		jdbcTemplate.update(sql, data);
		
	}
	
	public boolean update(LectureDto lectureDto) {
		
		JdbcTemplate jdbcTemplate = JdbcFactory.createTemplate();
		String sql = "update lecture set lecture_name = ?, lecture_category = ?, lecture_period = ?, lecture_price = ?, lecture_type = ? where lecture_no = ?";
		Object[] data = {
			
			lectureDto.getLectureName(), lectureDto.getLectureCategory(), lectureDto.getLecturePeriod(), 
			lectureDto.getLecturePrice(), lectureDto.getLectureType(), lectureDto.getLectureNo()
				
		};
		int rows = jdbcTemplate.update(sql, data);
		
		return rows > 0;
		
	}
	
	public boolean delete(int lectureNo) {
		
		JdbcTemplate jdbcTemplate = JdbcFactory.createTemplate();
		String sql = "delete lecture where lecture_no = ?";
		Object[] data = {lectureNo};
		return jdbcTemplate.update(sql, data) > 0;
		
	}
	
	private LectureMapper lectureMapper = new LectureMapper();
	
	public List<LectureDto> selectList() {
		
		JdbcTemplate jdbcTemplate = JdbcFactory.createTemplate();
		String sql = "select * from lecture";
		
		return jdbcTemplate.query(sql, lectureMapper);
		
	}

}
