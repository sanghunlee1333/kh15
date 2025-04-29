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
	//숫자 형태의 URL로 요청이 오면 이 메서드가 실행. ex) /5 요청 오면 attachmentNo=5. 파일을 다운로드하는 API. 
	//ResponseEntity<ByteArrayResource>로 응답. (파일 데이터를 담아서 응답할 거라는 뜻)
	//-> 파일 번호를 받아서 파일을 메모리로 읽고, 다운로드할 수 있도록 응답 전체를 직접 만들어서 보내는 메서드
	@GetMapping("/{attachmentNo}")
	public ResponseEntity<ByteArrayResource> download(@PathVariable int attachmentNo) throws IOException { 
		//attachmentNo 번호에 해당하는 파일의 "실제 파일 내용(byte 배열)"을 메모리에 불러옴
		//즉, 파일을 메모리에 통째로 읽은 것 
		byte[] data = attachmentService.load(attachmentNo);
		
		//attachmentNo로 DB에 저장된 파일 메타데이터를 불러온다. ex) 파일명, 파일크기, 파일타입(MIME)
		AttachmentDto attachmentDto = attachmentDao.selectOne(attachmentNo);
		
		//포장(Wrap)
		//메모리에 불러온 파일 내용을 ByteArrayResource로 감쌈. Spring이 파일 응답을 쉽게 처리할 수 있게 해주는 "포장지" 
		ByteArrayResource resource = new ByteArrayResource(data);
		
		// 반환
		return ResponseEntity.ok() //HTTP 응답을 보낼 준비를 시작. 기본 응답코드(status)는 200 OK로 설정
				.header(HttpHeaders.CONTENT_ENCODING, "UTF-8") //Content-Encoding 헤더를 UTF-8로 설정 	(보통 파일 다운로드에는 없어도 되지만, 문자 인코딩 참고용으로 넣는 경우 있음)
				.header(HttpHeaders.CONTENT_TYPE, attachmentDto.getAttachmentType()) //파일 타입(MIME 타입)을 설정. ex) image/png, application/pdf, text/plain 같은 것. 브라우저가 "아 이건 이미지구나, 문서구나" 판단할 때 필요
				//.contentType(MediaType.APPLICATION_OCTET_STREAM) //모를때
				.contentLength(attachmentDto.getAttachmentSize()) //파일의 크기(바이트)를 지정. 클라이언트가 "아 파일 크기가 3MB구나" 같은 정보를 알 수 있게 해줌
				.header(HttpHeaders.CONTENT_DISPOSITION, //다운로드 창 뜨게 만들어주는 설정
					ContentDisposition.attachment() //Content-Disposition: attachment; filename="파일명" 형태
						.filename(attachmentDto.getAttachmentName(), StandardCharsets.UTF_8) //파일명을 UTF-8로 안전하게 인코딩해서 이름 깨짐 방지
							.build().toString()
				)
				.body(resource); //포장해놓은 파일(ByteArrayResource)을 HTTP 응답의 body로 보냄. 즉, 이 파일을 클라이언트(브라우저)에게 전송
		
		/*
			#ResponseEntity = Spring에서 "HTTP 응답"을 직접 세밀하게 만들 수 있게 해주는 클래스
			- 서버가 클라이언트(브라우저, 앱)한테 보낼 응답 전체를 직접 만들고 싶을 때 쓰는 것
				- 응답 데이터(Body) = 사용자에게 보내줄 데이터
				- 응답 상태코드(Status) (예: 200, 404, 500) = HTTP 응답 코드
				- 응답 헤더(Header) (예: Content-Type, Location) = 추가 정보 (파일 다운로드, 인증 관련 등)
			-> 이걸 내 맘대로 조립해서 보낼 수 있게 해주는 게 ResponseEntity
			
			(기존)
			@GetMapping("/hello")
			public String hello() {
    			return "Hello World";
			}
			-> Spring은 알아서 이렇게 자동으로 만들어서 보내줘
				- HTTP 200 OK
				- Content-Type: text/plain
				- Body: Hello World
			
			(ResponseEntity 사용 시)
			- 200 OK" 말고 "201 Created"를 보내고 싶을 때
			- 헤더 추가해서 뭔가 다른 정보도 같이 보내고 싶을 때
			- Body 없이 상태코드만 보내고 싶을 때

			ex1) ok() = 상태코드 200 OK로 세팅. "Hello World" = 응답 본문(body)
			@GetMapping("/hello")
			public ResponseEntity<String> hello() {
			    return ResponseEntity.ok("Hello World");
			}
			
			ex2) 201 Created로 직접 응답 상태를 설정. Body는 "Created!"로 설정
			@PostMapping("/create")
			public ResponseEntity<String> createSomething() {
			    return ResponseEntity.status(201).body("Created!");
			}
			
			ex3) 헤더까지 조작해서 파일 다운로드 응답을 만듦
			@GetMapping("/download")
			public ResponseEntity<byte[]> download() {
			    HttpHeaders headers = new HttpHeaders();
			    headers.add("Content-Disposition", "attachment; filename=test.txt");
			
			    byte[] fileContent = "파일내용".getBytes();
			
			    return ResponseEntity.ok()
			        .headers(headers)
			        .body(fileContent);
			}
		

		*/
		
	}
	
}
