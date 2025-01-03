package jdbc.app;

import jdbc.dao.BookLoanDao;
import jdbc.dto.BookLoanDto;

public class Test01도서대여 {

	public static void main(String[] args) {
		
		
		BookLoanDto bookLoanDto = new BookLoanDto();
		bookLoanDto.setBookLoanTitle("해리포터와비밀의방");
		bookLoanDto.setBookLoanUser("이상진");
		bookLoanDto.setBookLoanPrice(30000);
		
		BookLoanDao bookLoanDao = new BookLoanDao();
		bookLoanDao.insert(bookLoanDto);
		
		System.out.println("등록 완료");
	}

}
