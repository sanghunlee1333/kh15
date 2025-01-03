package jdbc.app;

import jdbc.dao.BookLoanDao;
import jdbc.dto.BookLoanDto;

public class Test04대여정보상세 {
	public static void main(String[] args) {
	
		int bookLoanNo = 23;

		BookLoanDao bookLoanDao = new BookLoanDao();
		BookLoanDto bookLoanDto = bookLoanDao.selectOne(bookLoanNo);

		if(bookLoanDto == null){
			System.out.println("대여 번호가 없습니다");
		}
		else{
			System.out.println(bookLoanDto);
		}

	}

}