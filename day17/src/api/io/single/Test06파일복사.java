package api.io.single;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class Test06파일복사 {

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
		File readTarget = new File("sample/origin.txt"); 
		File writeTarget = new File("sample/copy.txt");
		
		byte[] buffer = new byte[10];
		
		FileInputStream in = new FileInputStream(readTarget);
		FileOutputStream out = new FileOutputStream(writeTarget);
		
		//1회 복사
		int size = in.read(buffer);
		out.write(buffer, 0, size); //0부터 size개 만큼 내보내세요. -> 그냥 내보내면 용량이 커짐
		
		in.close();
		out.close();
		
	}
	

}
