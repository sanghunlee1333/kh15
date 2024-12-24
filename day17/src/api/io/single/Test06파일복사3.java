package api.io.single;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test06파일복사3 {

	public static void main(String[] args) throws IOException {
		
		//강사님 파일
		File readTarget = new File("D:\\kh15\\eclipse-java-2024-09-R-win32-x86_64.zip");
		File writeTarget = new File("D:\\kh15\\copy.zip");
			
		FileInputStream in = new FileInputStream(readTarget);
		BufferedInputStream inBuf = new BufferedInputStream(in); //버퍼를 만들기 싫어서 클래스로 만듦
		
		FileOutputStream out = new FileOutputStream(writeTarget);
		BufferedOutputStream outBuf = new BufferedOutputStream(out);
		
		byte[] data = inBuf.readAllBytes(); //버퍼를 사용해서 다 읽으세요!
		outBuf.write(data); //읽은 내용을 다 내보내세요!
		
		inBuf.close(); //연결된 in은 자동 종료. 둘다 닫아도 되지만, 닫는 순서는 inBuf먼저 닫고 in을 닫아야 한다! 반대는 안됨
		outBuf.close(); //연결된 out은 자동 종료
		
	}
	

}
