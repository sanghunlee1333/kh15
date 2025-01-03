package jdbc.app;

import jdbc.dao.BookLoanDao;
import jdbc.dto.BookLoanDto;

public class Test05대여정보수정 {

	public static void main(String[] args) {
		
		BookLoanDto bookLoanDto = new BookLoanDto();
		bookLoanDto.setBookLoanNo(23);
		
		BookLoanDao bookLoanDao = new BookLoanDao();
		boolean success = bookLoanDao.update(bookLoanDto);
		
		if(success) {
			System.out.println("반납 완료");
			//System.out.println("반납 일시 : " + bookLoanDto.getBookLoanReturn());
		}
		else {
			System.out.println("반납할 도서가 없습니다");
		}
		
	}

}
