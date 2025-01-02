package jdbc.delete;

import jdbc.dao.LectureDao;

public class Test08강의삭제 {

	public static void main(String[] args) {
		
		int lectureNo = 22;
		
		LectureDao lectureDao = new LectureDao();
		boolean success = lectureDao.delete(lectureNo);
		
		if(success) System.out.println("강의 삭제 완료");
		else System.out.println("존재하지 않은 강의");
		
	}

}
