package api.io.single;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test06파일복사2 {

	public static void main(String[] args) throws IOException {
		
		//내 풀이
//		File readTarget = new File("sample/origin.txt"); 
//		FileInputStream in = new FileInputStream(readTarget);
//		
//		File writeTarget = new File("sample/copy.txt");
//		FileOutputStream out = new FileOutputStream(writeTarget);
//		
//		byte[] buffer = new byte[5];
//		
//		while(true) {
//			int size = in.read(buffer);
//			if(size == -1) break;
//			System.out.println("size = " + size);
//			System.out.println(Arrays.toString(buffer));
//			if(size == buffer.length) {
//				out.write(buffer);
//			}
//			else if(size < buffer.length) {
//				out.write(buffer, 0, 3);
//				
//			}
//			
//		}
		
		//강사님 파일
		File readTarget = new File("D:\\kh15\\eclipse-java-2024-09-R-win32-x86_64.zip");
		File writeTarget = new File("D:\\kh15\\copy.zip");
		
		byte[] buffer = new byte[8192]; //자바의 표준 버퍼 크기는 8192byte
		
		FileInputStream in = new FileInputStream(readTarget);
		FileOutputStream out = new FileOutputStream(writeTarget);
		
		//전부 복사
		long begin = System.currentTimeMillis();
		while(true) {
			int size = in.read(buffer); //buffer에 읽고 size에 읽은.. (강의 참고)
			if(size == -1) break;
			out.write(buffer, 0, size); //0부터 size개 만큼 내보내세요. -> 그냥 내보내면 용량이 커짐
			
		}
		long end = System.currentTimeMillis();
		long time = end - begin;
		System.out.println("소요시간 : " + time + "ms");
		
		in.close();
		out.close();
		
	}
	

}
