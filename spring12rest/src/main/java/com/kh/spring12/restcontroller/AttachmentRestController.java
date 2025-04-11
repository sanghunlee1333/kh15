package com.kh.spring12.restcontroller;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring12.dao.AttachmentDao;
import com.kh.spring12.dto.AttachmentDto;
import com.kh.spring12.service.AttachmentService;

//@CrossOrigin //<img src="">로 부르기 때문에 비동기 통신과 관련이 없으므로 
@RestController
@RequestMapping("/attachment")
public class AttachmentRestController {

	@Autowired
	private AttachmentDao attachmentDao;
	
	@Autowired
	private AttachmentService attachmentService;
		
	//ResponsEntity는 사용자에게 내보낼 정보가 포장된 개체를 의미
	@GetMapping("/{attachmentNo}")
	public ResponseEntity<ByteArrayResource> download(@PathVariable int attachmentNo) throws IOException { 
		byte[] data = attachmentService.load(attachmentNo);
		AttachmentDto attachmentDto = attachmentDao.selectOne(attachmentNo);
		
		//포장(Wrap)
		ByteArrayResource resource = new ByteArrayResource(data);
		
		//반환
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_ENCODING, "UTF-8")
				.header(HttpHeaders.CONTENT_TYPE, attachmentDto.getAttachmentType())
				//.contentType(MediaType.APPLICATION_OCTET_STREAM) // 모를때
				.contentLength(attachmentDto.getAttachmentSize())
				.header(HttpHeaders.CONTENT_DISPOSITION,
					ContentDisposition.attachment()
						.filename(attachmentDto.getAttachmentName(), StandardCharsets.UTF_8)
							.build().toString()
				)
				.body(resource);
	}
	
}
