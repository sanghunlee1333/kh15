package jdbc.select3;

import jdbc.dao.LectureDao;
import jdbc.dto.LectureDto;

public class Test08강의상세 {

	public static void main(String[] args) {
		
		int lectureNo = 21;
		
		LectureDao lectureDao = new LectureDao();
		LectureDto lectureDto = lectureDao.selectOne(lectureNo);
		
		if(lectureDto == null) {
			System.out.println("존재하지 않은 강의 번호");
		}
		else {
			System.out.println(lectureDto);
		}
	}

}
