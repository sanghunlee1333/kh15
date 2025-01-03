package jdbc.select2;

import java.util.List;

import jdbc.dao.LectureDao;
import jdbc.dto.LectureDto;

public class Test08강의검색 {

	public static void main(String[] args) {
		
//		String column = "강의명";
//		String keyword = "자바 프로그래밍 중급";
//		String column = "강의카테고리";
//		String keyword = "IT";
		String column = "강의유형";
		String keyword = "오프라인";
		
		LectureDao lectureDao = new LectureDao();
		List<LectureDto> list = lectureDao.selectList(column, keyword);
		
		for(LectureDto lectureDto : list) {
			System.out.println(lectureDto);
		}
		
	}

}
