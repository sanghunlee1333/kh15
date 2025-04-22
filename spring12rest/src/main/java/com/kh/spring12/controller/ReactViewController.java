package com.kh.spring12.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReactViewController {

	//react에 연결되어야 할 주소를 지정
	@RequestMapping(value = {
			"/", "/pokemon", "/info", "/country*", "/book", "/member/**", "/giftcard",
			"/admin/**", "/item/**", "/pay/**", "/buy/**", "/websocket/**"
	})
	public String forward() {
		return "forward:/index.html";
	}
}
