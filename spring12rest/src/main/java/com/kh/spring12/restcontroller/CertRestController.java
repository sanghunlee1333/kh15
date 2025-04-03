package com.kh.spring12.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring12.dto.CertDto;
import com.kh.spring12.error.TargetNotFoundException;
import com.kh.spring12.service.CertService;

@CrossOrigin
@RestController
@RequestMapping("/api/cert")
public class CertRestController {

	@Autowired
	private CertService certService;
	
	@PostMapping("/") // { "certEmail" : "test@kh.com" }
	public void sendCert(@RequestBody CertDto certDto) {
		certService.sendCertEmail(certDto.getCertEmail());
	}
	
	// { "certEmail : "test@kh.com", "certNumber" : "01234567" }
	// @GetMapping("/certEmail/{certEmail}/certNumber/{certNumber}") //GetMapping으로 한다면
	@PostMapping("/check")
	public void checkCert(@RequestBody CertDto certDto) {
		boolean result = certService.checkCert(certDto);
		if(result == false) throw new TargetNotFoundException();
	}
	
	
}
