package com.kh.spring08.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring08.dto.AttachmentDto;
import com.kh.spring08.mapper.AttachmentMapper;

@Repository
public class AttachmentDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private AttachmentMapper attachmentMapper;
	
	//등록(시퀀스 생성은 분리) -> 파일명 만들기 위해
	public int sequence() {
		String sql = "select attachment_seq.nextval from dual";
		return jdbcTemplate.queryForObject(sql, int.class);
	}
	
	public void insert(AttachmentDto attachmentDto) {
		String sql = "insert into attachment("
						+ "attachment_no, attachment_name, attachment_type, attachment_size"
						+ ") values(?, ?, ?, ?)";
		Object[] data = {
				attachmentDto.getAttachmentNo(), attachmentDto.getAttachmentName(),
				attachmentDto.getAttachmentType(), attachmentDto.getAttachmentSize()
		};
		
		jdbcTemplate.update(sql, data);
				
	}
	
}
