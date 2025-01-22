package com.kh.spring09.controller;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring09.dao.AttachmentDao;
import com.kh.spring09.dto.AttachmentDto;
import com.kh.spring09.error.TargetNotFoundException;
import com.kh.spring09.service.AttachmentService;

import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/attachment")
public class FileDownloadController {

	@Autowired
	private AttachmentDao attachmentDao;
	
	@Autowired
	private AttachmentService attachmentService;
		
	//ResponsEntity는 사용자에게 내보낼 정보가 포장된 개체를 의미
	@RequestMapping("/download")
	public ResponseEntity<ByteArrayResource> download2(@RequestParam int attachmentNo) throws IOException { 
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
