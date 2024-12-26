package api.io.string;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Test01문자열출력3 {

	public static void main(String[] args) throws IOException {
		//문자열은 객체 출력과 바이트 출력이 모두 가능
		//- byte 출력이 편하지만 변환을 수동으로 해야함
		//- writer를 사용해서 이 모든 작업을 손쉽게 구현
		
		String str = "안녕하세요";
		
		File target = new File("sample", "string3.txt");
		FileWriter fw = new FileWriter(target); //내장된 파일/버퍼/오브젝트 스트림
		
		fw.write(str); //줄넘기기 안됨
		fw.write(str);
		fw.write(str);
		fw.write(100); //아스키코드 값이 출려됨
		
		//fw.flush();
		fw.close();
	}

}
