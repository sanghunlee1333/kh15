package api.io.single;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test03파일복사2 {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		
		//(Q) sample/origin.txt를 sample/copy.txt로 복사하세요
		//1단계 : 한 글자만 복사(h)
		
		//준비 : 입력용 파일, 입력용 통로, 출력용 파일, 출력용 통로
		//File readTarget = new File("sample", "origin.txt");
		File readTarget = new File("sample/origin.txt");
		File writeTarget = new File("sample/copy.txt");
		
		if(!readTarget.exists()) {
			System.err.println("대상이 존재하지 않습니다");
			System.exit(-1); //0이 들어가면 잘 끝난 것. -1들어가면 잘못 끝난 것
		}
		
		//통로 생성
		FileInputStream in = new FileInputStream(readTarget);
		FileOutputStream out = new FileOutputStream(writeTarget);
		//readTarget -> in -> [프로그램] -> out -> writeTarget
		
		while(true) {
			int value = in.read();
			if(value == -1) break; //EOF //순서 중요!! -> 잘못 쓰면 용량이 엄청 커짐 -> 깃허브 100MB 넘으면 안됨
			out.write(value);
		}
		//통로 정리
		in.close();
		out.close();
	}

}
