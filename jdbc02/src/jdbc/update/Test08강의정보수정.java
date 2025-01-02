package jdbc.update;

import jdbc.dao.LectureDao;
import jdbc.dto.LectureDto;

public class Test08강의정보수정 {

	public static void main(String[] args) {

		LectureDto lectureDto = new LectureDto();
		lectureDto.setLectureNo(21);
		lectureDto.setLectureName("자바 프로그래밍 중급");;
		lectureDto.setLectureCategory("IT");
		lectureDto.setLecturePeriod(210);
		lectureDto.setLecturePrice(300000);
		lectureDto.setLectureType("오프라인");
		
		LectureDao lectureDao = new LectureDao();
		boolean success = lectureDao.update(lectureDto);
		
		if(success) System.out.println("강의 정보 수정 완료");
		else System.out.println("대상이 아닙니다");
		
	}

}
