package jdbc.insert2;

public class Test08강의등록 {

	public static void main(String[] args) {
		
		LectureDto lectureDto = new LectureDto();
		lectureDto.setLectureName("프리미어 프로 고급");
		lectureDto.setLectureCategory("그래픽");
		lectureDto.setLecturePeriod(30);
		lectureDto.setLecturePrice(250000);
		lectureDto.setLectureType("혼합");
		
		LectureDao lectureDao = new LectureDao();
		lectureDao.insert(lectureDto);
		
		System.out.println("강의 등록 완료");
		
	}

}
