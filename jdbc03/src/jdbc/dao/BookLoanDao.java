package jdbc.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.BookLoanDto;
import jdbc.mapper.BookLoanMapper;
import jdbc.util.JdbcFactory;

public class BookLoanDao {
	
	//작업에 필요한 도구들 미리 필드로 선언
	JdbcTemplate jdbcTemplate = JdbcFactory.createTemplate();
	private BookLoanMapper bookLoanMapper = new BookLoanMapper(); //조회를 위한 Mapper를 필드로 선언
	private Map<String, String> columnExamples = Map.of( //검색에 사용할 컬럼에 대한 정보를 저장
			"도서명","book_loan_title",
			"대여자","book_loan_user"
	);
	
	//CRUD 메소드 구현 (Create/Read/Update/Delete)
	//대여 정보 등록 메소드
	public void insert(BookLoanDto bookLoanDto) {
	
		String sql = "insert into book_loan(book_loan_no, book_loan_title, book_loan_user,"
				+ " book_loan_begin, book_loan_end, book_loan_price) "
				+ "values(book_loan_seq.nextval, ?, ?, SYSTIMESTAMP, SYSTIMESTAMP+7, ?)";
		Object[] data = {
			bookLoanDto.getBookLoanTitle(), 
			bookLoanDto.getBookLoanUser(), 
			bookLoanDto.getBookLoanPrice()
		};
		jdbcTemplate.update(sql, data);
		
	}
	
	//대여 정보 수정 메소드(반납일)
	public boolean update(BookLoanDto bookLoanDto) {
		
		String sql = "update book_loan set book_loan_return = SYSTIMESTAMP where book_loan_no = ?";
		Object[] data = {bookLoanDto.getBookLoanNo()};
		
		int rows = jdbcTemplate.update(sql, data);
		return rows > 0;

	}
	
	////수업내용에서 변형된 형태의 update 메소드
	//- 전체를 변경한 것이 아니기 때문에 update 뒤에 변경한 항목을 기재하여 가독성을 높임
//	public boolean updateBookLoanReturn(int bookLoanNo) {
//		String sql = "update book_loan "
//						+ "set book_loan_return=systimestamp "
//						+ "where book_loan_no=?";
//		Object[] data = {bookLoanNo};
//		return jdbcTemplate.update(sql, data) > 0;		
//	}
	
	//대여 정보 삭제 메소드
	public boolean delete(int bookLoanNo) {
		
		String sql = "delete book_loan where book_loan_no = ?";
		Object[] data = {bookLoanNo};
		
		return jdbcTemplate.update(sql, data) > 0;
				
	}
		
	//대여 정보 조회 메소드
	public List<BookLoanDto> selectList(){
		
		String sql = "select * from book_loan order by book_loan asc";
		return jdbcTemplate.query(sql, bookLoanMapper);
	}
	
	//대여 정보 검색 메소드
	public List<BookLoanDto> selectList(String column, String keyword){
		
		String columnName = columnExamples.get(column);
		if(columnName == null) {
			throw new RuntimeException("항목 오류");
		}
		
		String sql = "select * from book_loan where instr(#1, ?) > 0 order by #1 asc, book_loan_no asc";
		sql = sql.replace("#1", columnName);
		Object[] data = {keyword};
		return jdbcTemplate.query(sql, bookLoanMapper, data);
		
	}
	
	//대여 정보 상세 조회 메소드
	public BookLoanDto selectOne(int bookLoanNo){
		
		String sql = "select * from book_loan where book_loan_no = ?";
		Object[] data = {bookLoanNo};
		List<BookLoanDto> list = jdbcTemplate.query(sql, bookLoanMapper, data);
		return list.isEmpty() ? null : list.get(0);
		
	}
	
	//대출 기간 기반 대여 정보 조회 메소드
	public List<BookLoanDto> search(String bookLoanBegin, String bookLoanEnd){
		
		String sql = "select * from book_loan where book_loan_begin"
				+ " between to_timestamp(? || ' ' || '00:00:00.000', 'YYYY-MM-DD HH24:MI:SS.FF3') " // ||은 오라클에서 문자열 더하기 연산자에 해당
				+ "	and to_timestamp(? || ' ' || '00:00:00.000', 'YYYY-MM-DD HH24:MI:SS.FF3')"; //.000 과 .999를 꼭 붙여줘야 함? 만약에 안 붙이면 당연히 .000초로 잡힌다. 
		Object[] data = {bookLoanBegin, bookLoanEnd};
		return jdbcTemplate.query(sql, bookLoanMapper, data);
		
	}
	
	

}
