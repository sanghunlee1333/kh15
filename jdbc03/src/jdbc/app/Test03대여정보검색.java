package jdbc.app;

import java.util.List;

import jdbc.dao.BookLoanDao;
import jdbc.dto.BookLoanDto;

public class Test03대여정보검색 {
	public static void main(String[] args) {
		
		String column = "도서명";
		String keyword = "해리포터와마법사의돌";
//		String column = "대여자";
//		String keyword = "이상진";
		
		BookLoanDao bookLoanDao = new BookLoanDao();
		List<BookLoanDto> list = bookLoanDao.selectList(column, keyword);
		
		for(BookLoanDto bookLoanDto : list) {
			System.out.println(bookLoanDto);
		}
		
	}
}
