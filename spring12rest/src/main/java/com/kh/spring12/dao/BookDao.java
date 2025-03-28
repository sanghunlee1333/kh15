package com.kh.spring12.dao;

import java.awt.print.Book;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring12.dto.BookDto;
import com.kh.spring12.mapper.BookMapper;

@Repository
public class BookDao {

	@Autowired
	private BookMapper bookMapper;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void insert(BookDto bookDto) {
		String sql = "insert into book(" + "book_id, book_title, book_author, book_publication_date, book_price, "
										 + "book_publisher, book_page_count, book_genre" + ") "
										 + "values(book_seq.nextval, ?, ?, ?, ?, ?, ?, ?)";
		Object[] data = { bookDto.getBookTitle(), bookDto.getBookAuthor(), 
							bookDto.getBookPublicationDate(), bookDto.getBookPrice(),
							bookDto.getBookPublisher(), bookDto.getBookPageCount(), bookDto.getBookGenre()};
		jdbcTemplate.update(sql, data);
	}

	// 시퀀스+등록
	public int sequence() {
		String sql = "select book_seq.nextval from dual";
		return jdbcTemplate.queryForObject(sql, int.class);
	}

	public void insert2(BookDto bookDto) {
		String sql = "insert into book(" + "book_id, book_title, book_author, book_publication_date, book_price, "
											+ "book_publisher, book_page_count, book_genre" + ") "
											+ "values(?, ?, ?, ?, ?, ?, ?, ?)";
		Object[] data = { bookDto.getBookId(), bookDto.getBookTitle(), bookDto.getBookAuthor(), 
							bookDto.getBookPublicationDate(), bookDto.getBookPrice(), bookDto.getBookPublisher(), 
							bookDto.getBookPageCount(), bookDto.getBookGenre() };
		jdbcTemplate.update(sql, data);
	}

	// 수정 메소드
	public boolean update(BookDto bookDto) {
		String sql = "update book " + "set book_title = ?, book_author = ?, "
									+ "book_publication_date = ?, book_price = ?, book_publisher = ?, "
									+ "book_page_count = ?, book_genre = ? "
									+ "where book_id = ?";
		Object[] data = { bookDto.getBookTitle(), bookDto.getBookAuthor(), 
							bookDto.getBookPublicationDate(), bookDto.getBookPrice(), bookDto.getBookPublisher(), 
							bookDto.getBookPageCount(), bookDto.getBookGenre(),	bookDto.getBookId()
						};
		int rows = jdbcTemplate.update(sql, data);

		return rows > 0;
	}

	// 삭제 메소드
	public boolean delete(int bookId) {
		String sql = "delete book where book_id = ?";
		Object[] data = { bookId };
		return jdbcTemplate.update(sql, data) > 0;
	}

	// 목록조회 메소드
	public List<BookDto> selectList() {
		String sql = "select * from book order by book_id asc";
		return jdbcTemplate.query(sql, bookMapper);
	}

	// 검색에 사용할 컬럼에 대한 정보를 저장
	private Map<String, String> columnExample = Map.of("제목", "book_title", "작가", "book_author", "장르", "book_genre");

	// 검색 메소드
	public List<BookDto> selectList(String column, String keyword) {
		String columnName = columnExample.get(column);// 컬럼명 획득(없으면 null)
		if (columnName == null) {
			throw new RuntimeException("항목 오류");// 너는 문제가 있다고 말해주겠다
		}

		String sql = "select * from book " + "where instr(" + columnName + ", ?) > 0 " + "order by " + columnName
				+ " asc, book_id asc";
		Object[] data = { keyword };
		return jdbcTemplate.query(sql, bookMapper, data);
	}

	// 상세조회 메소드
	public BookDto selectOne(int bookId) {
		String sql = "select * from book where book_id = ? order by book_id asc";
		Object[] data = { bookId };
		List<BookDto> list = jdbcTemplate.query(sql, bookMapper, data);
		return list.isEmpty() ? null : list.get(0);
	}


}
