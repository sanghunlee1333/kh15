package com.kh.spring09.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kh.spring09.dao.PokemonDao;
import com.kh.spring09.dto.PokemonDto;
import com.kh.spring09.service.AttachmentService;

@Controller
@RequestMapping("/pokemon")
public class PokemonController {

	@Autowired
	private PokemonDao pokemonDao;

	@Autowired
	private AttachmentService attachmentService;

	// 사용자 입력 페이지
	@GetMapping("/add") // GET방식만 처리하는 매핑
	public String add() {
		return "/WEB-INF/views/pokemon/add.jsp";
	}

	// 입력 처리
//	@PostMapping("/add") // POST방식만 처리하는 매핑
//	public String add2(@ModelAttribute PokemonDto pokemonDto) {
//		pokemonDao.insert(pokemonDto);
//		// return "포켓몬 등록 완료"; //@RestController일 때 가능했던 코드
//		// return "/WEB-INF/views/pokemon/add2.jsp"; //새로고침 문제 발생
//		// return "redirect:/pokemon/addFinish"; //addFinish으로 쫓아내는 코드(절대경로)
//		return "redirect:addFinish"; // addFinish으로 쫓아내는 코드(상대경로)
//	}

	@PostMapping("/add")
	public String add(@ModelAttribute PokemonDto pokemonDto, @RequestParam MultipartFile attach)
			throws IllegalStateException, IOException {
		// [1] 포켓몬 등록 -> 포켓몬번호(시퀀스)
		int pokemonNo = pokemonDao.sequence();
		pokemonDto.setPokemonNo(pokemonNo);
		pokemonDao.insert2(pokemonDto);

		if (attach.isEmpty() == false) { // 비어있지 않다면(첨부파일이 있을 경우)
			// [2] 첨부파일 등록 -> 첨부파일번호(시퀀스)
			int attachmentNo = attachmentService.save(attach);

			// [3] 포켓몬 이미지 등록(연결) -> 1, 2번에서 뽑은 포켓몬번호, 첨부파일번호
			pokemonDao.connect(pokemonNo, attachmentNo);
		}
		return "redirect:addFinish";
	}

	// 완료 안내
	@RequestMapping("/addFinish") // 방식 무관
	public String add3() {
		return "/WEB-INF/views/pokemon/addFinish.jsp";
	}

	// 목록 매핑
	// - 데이터베이스에서 조회환 결과(List<PokemonDto>)를 화면에 전달
	@RequestMapping("/list")
	public String list(Model model /* , @ModelAttribute("pageVO") PageVO pageVO */) {
		List<PokemonDto> list = pokemonDao.selectList();
		model.addAttribute("list", list);

		return "/WEB-INF/views/pokemon/list.jsp";
	}

	// 상세조회 매핑
	// - 상세조회를 위해서는 기본키(primary key)가 필요하다
	@RequestMapping("/detail")
	public String detail(@RequestParam int pokemonNo, Model model) {
		PokemonDto pokemonDto = pokemonDao.selectOne(pokemonNo);
		model.addAttribute("pokemonDto", pokemonDto);
		return "/WEB-INF/views/pokemon/detail.jsp";
	}

	// 삭제 매핑
	// - JSP를 연동할 필요 없이 처리 후 다른 매핑으로 쫓아낸다(redirect)
//	@RequestMapping("/delete")
//	public String delete(@RequestParam int pokemonNo) {
//		boolean success = pokemonDao.delete(pokemonNo);
//		if(success) {
//			return "redirect:list";
//		}
//		else {
//			return "redirect:list"; //오류 처리로 나중에 변경
//		}
//	}

	// (+추가) 첨부파일이 있다면 해당 파일을 찾아서 삭제하도록 구현
	@RequestMapping("/delete")
	public String delete(@RequestParam int pokemonNo) {
		try {// 첨부파일 삭제를 시도해보고
			int attachmentNo = pokemonDao.findAttachment(pokemonNo);
			attachmentService.delete(attachmentNo);
		} catch (Exception e) {
			/* 첨부파일이 없을 경우 예외 발생 */}

		// 첨부파일 결과와 상관없이 포켓몬은 삭제하세요
		pokemonDao.delete(pokemonNo);
		return "redirect:list";
	}

	// 수정 매핑
	// - 입력/처리를 GET/POST로 나누어서 처리
	// - 정보를 표시해두기 위해 Model에 DTO 정보를 전달해야 한다
	@GetMapping("/edit")
	public String edit(@RequestParam int pokemonNo, Model model) {
		PokemonDto pokemonDto = pokemonDao.selectOne(pokemonNo);
		model.addAttribute("pokemonDto", pokemonDto);
		return "/WEB-INF/views/pokemon/edit.jsp";
	}

//	@PostMapping("/edit")
//	public String edit(@ModelAttribute PokemonDto pokemonDto) {
//		boolean success = pokemonDao.update(pokemonDto);
//		
//		if(success) {
//			//*참고 : redirect는 다른 매핑으로 GET방식 요청을 생성하는 것이므로 
//			return "redirect:detail?pokemonNo="+pokemonDto.getPokemonNo(); 
//		}
//		else {
//			return "redirect:list";
//		}
//		
//	}

	@PostMapping("/edit")
	public String edit(@ModelAttribute PokemonDto pokemonDto, @RequestParam MultipartFile attach)
			throws IllegalStateException, IOException {
		// 정보를 변경하고 첨부파일이 있다면 기존 파일을 지우고 신규 등록

		// [1] 수정 요청
		boolean success = pokemonDao.update(pokemonDto);
		if (!success) {
			return "redirect:list";
		}

		// [2] 이미지 변경 요청
		if (attach.isEmpty() == false) { // 첨부파일이 존재한다면
			try {// 기존 이미지 삭제 처리(없으면 예외 발생)
				int attachmentNo = pokemonDao.findAttachment(pokemonDto.getPokemonNo());
				attachmentService.delete(attachmentNo);
			} catch (Exception e) {
				/* 아무것도 안함 */}

			// 신규 이미지 등록
			int newAttachmentNo = attachmentService.save(attach);
			pokemonDao.connect(pokemonDto.getPokemonNo(), newAttachmentNo);
		}

		// *참고 : redirect는 다른 매핑으로 GET방식 요청을 생성하는 것이므로
		return "redirect:detail?pokemonNo=" + pokemonDto.getPokemonNo();

	}

	@RequestMapping("/edit")
	public String edit(@ModelAttribute PokemonDto pokemonDto, Model model) {
		pokemonDao.update(pokemonDto);
		return "/WEB-INF/views/pokemon/edit.jsp";
	}

	// 포켓몬 번호(PK)로 이미지 주소를 반환하는 매핑
	@RequestMapping("/image")
	public String image(@RequestParam int pokemonNo) {
		try {// 플랜A : 이미지가 있는 경우
			int attachmentNo = pokemonDao.findAttachment(pokemonNo);
			return "redirect:/attachment/download?attachmentNo=" + attachmentNo;
		} catch (Exception e) {// 플랜B : 이미지가 없는 경우
			return "redirect:/images/empty.jpg";
			//return "redirect:https://placehold.co/400x400?text=P";
		}
	}

}
