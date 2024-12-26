package api.io.string;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Test01문자열출력4 {

	public static void main(String[] args) throws IOException {
		//문자열은 객체 출력과 바이트 출력이 모두 가능
		//- byte 출력이 편하지만 변환을 수동으로 해야함
		//- writer를 사용해서 이 모든 작업을 손쉽게 구현
		
		String str = "안녕하세요";
		
		File target = new File("sample", "string4.txt");
		FileWriter fw = new FileWriter(target);
		//외장된 기능을 써서 효율과 편리성을 높이자
		BufferedWriter bw = new BufferedWriter(fw); //효율만 높여줌
		PrintWriter pw = new PrintWriter(bw); //편리함을 높여줌
		
		pw.println(str);
		pw.println(str);
		pw.println(str);
		pw.println(100);
		pw.println(100+200);
		
		pw.close();
	}

}
