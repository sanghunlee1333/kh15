package jdbc.app;

import java.util.List;

import jdbc.dao.BookLoanDao;
import jdbc.dto.BookLoanDto;

public class Test02대여정보조회 {

	public static void main(String[] args) {
		
		BookLoanDao bookLoanDao = new BookLoanDao();
		List<BookLoanDto> list = bookLoanDao.selectList();
		
		for(BookLoanDto bookLoanDto : list) {
			System.out.println(bookLoanDto);
		}
		
	}

}
