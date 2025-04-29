package com.kh.spring12.configuration;

import java.io.File;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component // Component = Spring이 이 클래스를 자동으로 관리하게 해주는 어노테이션
//이 클래스는 Spring한테 Bean(객체)로 등록됨. 나중에 다른 곳에서 @Autowired로 쉽게 가져다 쓸 수 있게 해줌
@ConfigurationProperties(prefix = "custom.fileupload") //application.properties나 application.yml 파일에 설정된 값을 읽어오는 어노테이션
//custom.fileupload로 시작하는 설정을 이 클래스에 자동으로 연결해줌. 해당 설정 값이 자동으로 private String root;에 들어감
public class FileuploadProperties { //파일 업로드 설정을 저장하는 전용 클래스
	private String root; //루트 디렉터리 경로를 담을 변수
	
	public File getRootDir() { //root 문자열을 실제로 File 객체로 변환해서 리턴하는 메소드
		return new File(root); //문자열로 저장된 경로를 진짜 File 객체로 만들어서 반환
	}
}
