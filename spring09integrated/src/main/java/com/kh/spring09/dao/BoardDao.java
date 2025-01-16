package com.kh.spring09.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring09.aop.BoardReadInterceptor;
import com.kh.spring09.dto.BoardDto;
import com.kh.spring09.error.NoPermissionException;
import com.kh.spring09.mapper.BoardListMapper;
import com.kh.spring09.mapper.BoardMapper;

@Repository
public class BoardDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private BoardMapper boardMapper;
	@Autowired
	private BoardListMapper boardListMapper;

	// 게시글 목록 조회
	public List<BoardDto> selectList() {
		String sql = "select * from board order by board_no desc"; //*와일드카드 대신 content빼고 전부 다 쓸 수도 있다.
		return jdbcTemplate.query(sql, boardListMapper);
	} 
	
	// 검색 목록 조회
	public List<BoardDto> selectList(String column, String keyword) {
		//검색 항목 검사
		switch(column) {
		case "board_writer":
		case "board_title":
			break;
		default:
			throw new NoPermissionException("검색할 수 없는 항목");
		}
		
		String sql = "select board_no, board_title, board_writer, board_wtime, board_like, " //content 제외
					+ "board_read, board_reply "
					+ "from board " 
					+ "where instr(#1, ?) > 0 " 
					+ "order by #1 asc, board_no desc";
		sql = sql.replace("#1", column);
		Object[] data = { keyword };
		return jdbcTemplate.query(sql, boardListMapper, data);

	}
	
	// 게시글 상세조회 기능
	public BoardDto selectOne(int boardNo) {
		String sql = "select * from board where board_no=?";
		Object[] data = { boardNo };
		List<BoardDto> list = jdbcTemplate.query(sql, boardMapper, data); //boardListMapper는 content가 빠져있으므로 안된다.
		return list.isEmpty() ? null : list.get(0);
	}

	// 게시글 입력 ->  //커피값을 내고 커피를 마시는 게 아니라, 커피를 다 마시고 돈 줄게 하는 느낌
//	public void insert(BoardDto boardDto) {
//		String sql = "insert into board(board_no, board_title, board_content, board_writer) "
//						+ "values(board_seq.nextval, ?, ?, ?)";
//		Object[] data = { boardDto.getBoardTitle(), boardDto.getBoardContent(), boardDto.getBoardWriter() };
//		jdbcTemplate.update(sql, data);
//	}
	
	//시퀀스 발급과 등록을 분리
	public int sequence() {
		String sql = "select board_seq.nextval from dual"; //dual = 임시테이블
		return jdbcTemplate.queryForObject(sql, int.class); //기존의 query는 DTO를 반환해서 안되므로 다른 메소드를 씀. int.class는 자료형이 int라고 알려주는 것
	}
	
	public void insert2(BoardDto boardDto) {
		String sql = "insert into board(board_no, board_title, board_content, board_writer) "
						+ "values(?, ?, ?, ?)"; //커피를 다 마시고 돈준다하는 느낌
		Object[] data = { boardDto.getBoardNo(), boardDto.getBoardTitle(), 
						boardDto.getBoardContent(), boardDto.getBoardWriter() };
		jdbcTemplate.update(sql, data);
	}

	

	public boolean delete(int boardNo) {
		String sql = "delete board where board_no = ?";
		Object[] data = { boardNo };
		return jdbcTemplate.update(sql, data) > 0;
	}

	public boolean update(BoardDto boardDto) {
		String sql = "update board set board_title = ?, board_content = ?, board_etime = systimestamp "
				+ "where board_no = ?";
		Object[] data = { boardDto.getBoardTitle(), boardDto.getBoardContent(), boardDto.getBoardNo() };
		return jdbcTemplate.update(sql, data) > 0;
	}
	
	//조회수 1 증가 메소드
	public boolean updateBoardRead(int boardNo) {
		String sql = "update board "
						+ "set board_read=board_read+1 "
						+ "where board_no=?";
		Object[] data = {boardNo};
		return jdbcTemplate.update(sql, data) > 0;
	}

}
