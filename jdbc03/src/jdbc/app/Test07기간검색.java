package jdbc.app;

import java.util.List;
import java.util.Scanner;

import jdbc.dao.BookLoanDao;
import jdbc.dto.BookLoanDto;

public class Test07기간검색 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("검색 시작일(YYYY-MM-DD) : ");
		String bookLoanBegin = sc.next();
		
		System.out.print("검색 종료일(YYYY-MM-DD) : ");
		String bookLoanEnd = sc.next();
		sc.close();
		
		BookLoanDao bookLoanDao = new BookLoanDao();
		List<BookLoanDto> list = bookLoanDao.search(bookLoanBegin, bookLoanEnd);
		
		for(BookLoanDto bookLoanDto : list) {
			System.out.println("[" + bookLoanBegin + " ~ " + bookLoanEnd + "] 대여중인 도서는 총 "+list.size()+"권 있습니다");
			System.out.println(bookLoanDto);
		}
		
	}

}
