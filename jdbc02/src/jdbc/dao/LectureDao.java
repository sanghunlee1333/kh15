package jdbc.dao;

import java.util.List;
import java.util.Map;

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
	
	private Map<String, String> columnExamples = Map.of(
		
		"강의명","lecture_name",
		"강의카테고리", "lecture_category",
		"강의유형", "lecture_type"
			
	);
	
	public List<LectureDto> selectList(String column, String keyword){
		String columnName = columnExamples.get(column);
		if(columnName == null) {
			throw new RuntimeException("항목 오류");
		}
		
		JdbcTemplate jdbcTemplate = JdbcFactory.createTemplate();
		String sql = "select * from lecture where instr(#1, ?) > 0 order by #1 asc, lecture_no asc";
		sql = sql.replace("#1", columnName);
		Object[] data = {keyword};
		return jdbcTemplate.query(sql, lectureMapper, data);
	}
	
	public LectureDto selectOne(int lectureNo) {
		JdbcTemplate jdbcTemplate = JdbcFactory.createTemplate();
		String sql = "select * from lecture where lecture_no = ?";
		Object[] data = {lectureNo};
		List<LectureDto> list = jdbcTemplate.query(sql, lectureMapper, data);
		return list.isEmpty() ? null : list.get(0);
	}
			

}
