package com.kh.spring08.controller;



import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/fileupload")
public class FileUploadController {
	
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
		System.out.println(" -> empty = " + attach.isEmpty());
		System.out.println(" -> filename = " + attach.getOriginalFilename());
		System.out.println(" -> filesize = " + attach.getSize());
		System.out.println(" -> content type = " + attach.getContentType());
		
		//실제 파일은 어디에 어떻게 저장할 것인가?
		//- MultipartFile에서 제공하는 저장메소드(transferTo)를 사용
		//그리고 DB는 어떻게 사용할 것인가?
		//- DB는 파일의 정보만 저장을 하고 실물은 하드디스크에 저장한다
		
		//파일의 이름이 중복되는 현상을 해결하는 방법
		//[1] DB를 쓰지 않는다면 UUID를 생성하여 해결할 수 있다 -> DB를 안쓰는 것은 문제가 있음
		// - UUID는 시간이 포함된 랜덤시리얼 번호(중복이 불가능)
		//[2] DB를 쓴다면 UUID대신 시퀀스번호를 파일명으로 사용할 수 있다
		// - 업로드한 이름 등을 기억해둬야 하므로 DB의 컬럼에 저장
		// - 시퀀스번호, 업로드된 파일명, 파일유형, 파일크기 정도는 저장이 필요
		File dir = new File("D:/upload");
		dir.mkdirs();
		//File target = new File(dir, attach.getOriginalFilename());
		File target = new File(dir, UUID.randomUUID().toString()); //[1]
		attach.transferTo(target);
		
		return "redirect:test3";
	}

}
