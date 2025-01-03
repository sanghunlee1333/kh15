package jdbc.dto;

import java.sql.Timestamp;

public class BookLoanDto {
	
	private long bookLoanNo;
	private String bookLoanTitle;
	private String bookLoanUser;
	private Timestamp bookLoanBegin;
	private Timestamp bookLoanEnd;
	private Timestamp bookLoanReturn;
	private int bookLoanPrice;
	
	public long getBookLoanNo() {
		return bookLoanNo;
	}
	public void setBookLoanNo(long bookLoanNo) {
		this.bookLoanNo = bookLoanNo;
	}
	public String getBookLoanTitle() {
		return bookLoanTitle;
	}
	public void setBookLoanTitle(String bookLoanTitle) {
		this.bookLoanTitle = bookLoanTitle;
	}
	public String getBookLoanUser() {
		return bookLoanUser;
	}
	public void setBookLoanUser(String bookLoanUser) {
		this.bookLoanUser = bookLoanUser;
	}
	public Timestamp getBookLoanBegin() {
		return bookLoanBegin;
	}
	public void setBookLoanBegin(Timestamp bookLoanBegin) {
		this.bookLoanBegin = bookLoanBegin;
	}
	public Timestamp getBookLoanEnd() {
		return bookLoanEnd;
	}
	public void setBookLoanEnd(Timestamp bookLoanEnd) {
		this.bookLoanEnd = bookLoanEnd;
	}
	public Timestamp getBookLoanReturn() {
		return bookLoanReturn;
	}
	public void setBookLoanReturn(Timestamp bookLoanReturn) {
		this.bookLoanReturn = bookLoanReturn;
	}
	public int getBookLoanPrice() {
		return bookLoanPrice;
	}
	public void setBookLoanPrice(int bookLoanPrice) {
		this.bookLoanPrice = bookLoanPrice;
	}

	@Override
	public String toString() {
		return "BookLoanDao [bookLoanNo=" + bookLoanNo + ", bookLoanTitle=" + bookLoanTitle + ", bookLoanUser="
				+ bookLoanUser + ", bookLoanBegin=" + bookLoanBegin + ", bookLoanEnd=" + bookLoanEnd
				+ ", bookLoanReturn=" + bookLoanReturn + ", bookLoanPrice=" + bookLoanPrice + "]";
	}

	public BookLoanDto() {
		super();
	}
	
		
}
