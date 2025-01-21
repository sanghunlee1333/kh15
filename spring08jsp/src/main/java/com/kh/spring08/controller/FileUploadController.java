package com.kh.spring08.controller;



import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kh.spring08.dao.AttachmentDao;
import com.kh.spring08.dto.AttachmentDto;
import com.kh.spring08.service.AttachmentService;

@Controller
@RequestMapping("/fileupload")
public class FileUploadController {
	
	@Autowired
	private AttachmentDao attachmentDao;
	
	@RequestMapping("/test1")
	public String test1() {
		return "/WEB-INF/views/fileupload/test1.jsp";
	}
	
	@GetMapping("/upload1")
	public String upload1(@RequestParam String attach) {
		System.out.println("attach = " + attach);
		return "redirect:test1";
	}
	
	@RequestMapping("/test2")
	public String test2() {
		return "/WEB-INF/views/fileupload/test2.jsp";
	}
	
	@PostMapping("/upload2")
	public String upload2(@RequestParam String attach) {
		System.out.println("attach = " + attach);
		return "redirect:test2";
	}
	
	@RequestMapping("/test3")
	public String test3() {
		return "/WEB-INF/views/fileupload/test3.jsp";
	}
	
	//multipart/form-data로 전송되는 값은 @RequestParam으로 수신 가능하다
	//- 단, 다른 값들은 기존처럼 받으면 되지만 파일만큼은 Multifile 사용
	//- @ModelAttribute도 사용가능
	
	@PostMapping("/upload3")
	public String upload3(
			@RequestParam String uploader,
			@RequestParam MultipartFile attach) throws IllegalStateException, IOException {
		System.out.println("uploader = " + uploader);
		System.out.println("attach = " + attach);
		//(*주의) 파일이 오지 않아도 attach는 생긴다(isEmpty())로 구분)
		System.out.println(" -> empty = " + attach.isEmpty());
		System.out.println(" -> filename = " + attach.getOriginalFilename());
		System.out.println(" -> filesize = " + attach.getSize());
		System.out.println(" -> content type = " + attach.getContentType());
		
		//실제 파일은 어디에 어떻게 저장할 것인가?
		//- MultipartFile에서 제공하는 저장메소드(transferTo)를 사용
		//그리고 DB는 어떻게 사용할 것인가?
		//- DB는 파일의 정보만 저장을 하고 실물은 하드디스크에 저장한다
		
		//파일의 이름이 중복되는 현상을 해결하는 방법
		// - 사용자가 올리는 파일명 그대로 저장하면 안된다 (폴더로 구분할게 아니라면)
		//[1] DB를 쓰지 않는다면 UUID를 생성하여 해결할 수 있다 -> DB를 안쓰는 것은 문제가 있음
		// - UUID는 시간이 포함된 랜덤시리얼 번호(중복이 불가능)
		//[2] DB를 쓴다면 UUID대신 시퀀스번호를 파일명으로 사용할 수 있다
		// - 업로드한 이름 등을 기억해둬야 하므로 DB의 컬럼에 저장
		// - 시퀀스번호, 업로드된 파일명, 파일유형, 파일크기 정도는 저장이 필요
		File dir = new File("D:/upload");
		dir.mkdirs();
		//File target = new File(dir, attach.getOriginalFilename());
		//File target = new File(dir, UUID.randomUUID().toString()); //[1]
		
		//첨부파일 저장 서비스(@Service)
		//물리파일 저장
		int attachmentNo = attachmentDao.sequence(); //시퀀스번호 추출
		File target = new File(dir, String.valueOf(attachmentNo)); //파일명으로 설정 
		attach.transferTo(target); //저장
		//데이터베이스 등록
		AttachmentDto attachmentDto = new AttachmentDto();
		attachmentDto.setAttachmentNo(attachmentNo);
		attachmentDto.setAttachmentName(attach.getOriginalFilename());
		attachmentDto.setAttachmentType(attach.getContentType());
		attachmentDto.setAttachmentSize(attach.getSize());
		attachmentDao.insert(attachmentDto);
		
		return "redirect:test3";
	}
	
	//최종 파일 저장 코드
	@Autowired
	private AttachmentService attachmentService;
	
	@RequestMapping("/test4")
	public String test4() {
		return "/WEB-INF/views/fileupload/test4.jsp";
	}
	
	@PostMapping("/upload4")
	public String upload4(@RequestParam String uploader, @RequestParam MultipartFile attach) throws IllegalStateException, IOException {
		attachmentService.save(attach); //파일 저장(물리+DB)
		return "redirect:test4";
	}
	
	//여러 개의 파일이 업로드 되는 경우에 대한 처리
	//- 수신할 때 Collection 또는 배열 형태로 수신할 수 있다
	@RequestMapping("/test5")
	public String test5() {
		return "/WEB-INF/views/fileupload/test5.jsp";
	}
	
	//(*주의) 파일이 전송되지 않아도 attachList의 사이즈는 1이다 (isEmpty로 구분해야 함)
	@PostMapping("/upload5")
	public String upload5(@RequestParam String uploader, @RequestParam("attach") List<MultipartFile> attachList) throws IllegalStateException, IOException {
		for(MultipartFile attach : attachList) {
			//System.out.println("전송된 파일 개수 : " + attachList.size());
			attachmentService.save(attach); //파일 저장(물리+DB)
		}
		return "redirect:test5";
	}

}
