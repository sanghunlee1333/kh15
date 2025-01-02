package jdbc.select;

import java.util.List;

import jdbc.dao.LectureDao;
import jdbc.dto.LectureDto;

public class Test08강의조회 {

	public static void main(String[] args) {
		
		LectureDao lectureDao = new LectureDao();
		List<LectureDto> list = lectureDao.selectList();
		
		for (LectureDto lectureDto : list) {
			System.out.println(lectureDto);
		}
				
	}

}
