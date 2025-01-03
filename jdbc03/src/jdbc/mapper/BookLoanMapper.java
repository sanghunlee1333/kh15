package jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import jdbc.dto.BookLoanDto;

public class BookLoanMapper implements RowMapper<BookLoanDto> {

	@Override
	public BookLoanDto mapRow(ResultSet rs, int arg1) throws SQLException {
		
		BookLoanDto bookLoanDto = new BookLoanDto();
		bookLoanDto.setBookLoanNo(rs.getLong("book_loan_no"));
		bookLoanDto.setBookLoanTitle(rs.getString("book_loan_title"));
		bookLoanDto.setBookLoanUser(rs.getString("book_loan_user"));
		bookLoanDto.setBookLoanBegin(rs.getTimestamp("book_loan_begin"));
		bookLoanDto.setBookLoanEnd(rs.getTimestamp("book_loan_end"));
		bookLoanDto.setBookLoanReturn(rs.getTimestamp("book_loan_return"));
		bookLoanDto.setBookLoanPrice(rs.getInt("book_loan_price"));
				
		return bookLoanDto;
	}

}
