package com.kh.spring12.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.kh.spring12.dto.BookDto;

@Component
public class BookMapper implements RowMapper<BookDto>{

	@Override
	public BookDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		return BookDto.builder()
				.bookId(rs.getInt("book_id"))
				.bookTitle(rs.getString("book_title"))
				.bookAuthor(rs.getString("book_author"))
				.bookPublicationDate(rs.getString("book_publication_date"))
				.bookPrice(rs.getInt("book_price"))
				.bookPublisher(rs.getString("book_publisher"))
				.bookPageCount(rs.getInt("book_page_count"))
				.bookGenre(rs.getString("book_genre"))
			.build();
	}
	
}
