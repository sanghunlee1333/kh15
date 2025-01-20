package com.kh.spring08.controller;

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
			@RequestParam MultipartFile attach) {
		System.out.println("uploader = " + uploader);
		System.out.println("attach = " + attach);
		System.out.println(" -> empty = " + attach.isEmpty());
		System.out.println(" -> filename = " + attach.getOriginalFilename());
		System.out.println(" -> filesize = " + attach.getSize());
		System.out.println(" -> content type = " + attach.getContentType());
		return "redirect:test3";
	}

}
