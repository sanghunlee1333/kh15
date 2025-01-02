package jdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.LectureDto;
import jdbc.util.JdbcFactory;

public class LectureDao {
	
	public void insert(LectureDto lectureDto) {
		
		
		
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

}
