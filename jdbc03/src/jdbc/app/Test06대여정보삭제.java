package jdbc.app;

import jdbc.dao.BookLoanDao;

public class Test06대여정보삭제 {

	public static void main(String[] args) {
		
		int bookLoanNo = 22;
		
		BookLoanDao bookLoanDao = new BookLoanDao();
		boolean success = bookLoanDao.delete(bookLoanNo);
		
		if(success) {
			System.out.println("도서 대여 정보 삭제 완료");
		}
		else {
			System.out.println("대여 정보가 없습니다");
		}
		
	}

}
