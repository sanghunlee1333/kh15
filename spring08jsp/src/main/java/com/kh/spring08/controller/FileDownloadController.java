package com.kh.spring08.controller;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring08.dao.AttachmentDao;
import com.kh.spring08.dto.AttachmentDto;
import com.kh.spring08.error.TargetNotFoundException;
import com.kh.spring08.service.AttachmentService;

import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/filedownload")
public class FileDownloadController {

	@Autowired
	private AttachmentDao attachmentDao;
	
	@Autowired
	private AttachmentService attachmentService;
	
	//목록 매핑
	@RequestMapping("/list")
	public String list(Model model) {
		model.addAttribute("list", attachmentDao.selectList());
		return "/WEB-INF/views/filedownload/list.jsp";
	}
	
	//파일 다운로드 처리
	//- /download1 에서는 자바 웹(Java EE)에서 제공하는 방법 사용
	//- /download2 에서는 스프링(Spring)에서 제공하는 방법 사용
	
	@RequestMapping("/download1")
	public void download(@RequestParam int attachmentNo, HttpServletResponse response) throws IOException {
		//[1] 유요한 파일 번호인지 확인
		AttachmentDto attachmentDto = attachmentDao.selectOne(attachmentNo);
		//if(attachmentDto == null) return;
		if(attachmentDto == null) {
			throw new TargetNotFoundException("존재하지 않는 파일번호");
		}
		
		//[2] 실제 파일이 존재하는지 확인
		File dir = new File("D:/upload");
		File target = new File(dir, String.valueOf(attachmentNo));
		if(target.isFile() == false) {
			throw new TargetNotFoundException("파일이 존재하지 않습니다");
		}
		
		//[3] 실제 파일을 불러온다 -> 라이브러리 사용(Apache commons IO)
		byte[] data = FileUtils.readFileToByteArray(target);
		
		//[4] 사용자에게 파일을 전송 (헤더 + 바디)
		response.setHeader("Content-Encoding", "UTF-8");
		response.setHeader("Content-Type", attachmentDto.getAttachmentType()); //알면
		//response.setHeader("Content-Type", "application/octet-stream"); //모르면
		response.setHeader("Content-Length", String.valueOf(attachmentDto.getAttachmentSize()));
		response.setHeader("Content-Disposition", "attachment; filename=" + attachmentDto.getAttachmentName());
		
		response.getOutputStream().write(data);
		
	}
	
	//ResponsEntity는 사용자에게 내보낼 정보가 포장된 개체를 의미
	@RequestMapping("/download2")
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
