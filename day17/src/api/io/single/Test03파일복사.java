package api.io.single;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test03파일복사 {

	public static void main(String[] args) throws IOException, InterruptedException {
		
//		// 준비물 : 제어용 파일, 입력용 통로
//		File origin = new File("sample", "origin.txt"); // 제어할 파일
//		FileInputStream in = new FileInputStream(origin); // 파일이 없으면 문제 생길텐데
//		
//		File copy = new File("sample", "copy.txt");
//		FileOutputStream out = new FileOutputStream(copy);
//		
//		ArrayList<Integer> a = new ArrayList<Integer>();
//		
//		
//		while(true) {
//			int value = in.read();
//			if((char)value == ' ') {
//				System.out.println();
//			}	
//			a.add(value);
//			if (value == -1) break;
//			Thread.sleep(250L);
//		}
//		in.close();
//		
//		for(int i = 0; i < a.size(); i++) {
//			if(a.get(i) == -1) break;
//			out.write(a.get(i));
//			Thread.sleep(250L);
//		}
//		
//		out.close();
		
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
		
		int value = in.read();
		out.write(value);
		
		//통로 정리
		in.close();
		out.close();
	}

}
