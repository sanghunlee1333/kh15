package api.io.string;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Test02콘솔메모장2 {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		
		File dir = new File("sample");
		
		//임시파일의 존재여부 확인
		File[] list = dir.listFiles();
		boolean tempExist = false;
		for(File f : list) {
			//if(f.getname().startWith("note") && f.getName().endsWith(".kh") {}
			if(f.getName().matches("^note(.*?)\\.kh$")) { //note어쩌구.kh면 
				tempExist = true;
				break;
			}
		}
		
		System.out.println("임시파일 존재여부 : " + tempExist);
				
		//임시파일 생성
		File temp = File.createTempFile("note", ".kh", dir);
		temp.deleteOnExit(); //종료시 삭제
		//System.out.println(temp.getAbsolutePath());
		FileWriter fw = new FileWriter(temp);
		BufferedWriter bw = new BufferedWriter(fw); //없어도 되긴 함
		PrintWriter pw = new PrintWriter(bw);

		while (true) {
			System.out.print("입력 : ");
			String line = sc.nextLine();
			if (line.equals("/종료")) {
				break;
			}
			pw.println(line);
			pw.flush();//버퍼가 차든 말든 내보내라. 프로그램이 강제 종료되어도 저장됨
		}
		pw.close();
		sc.close();
		
		//파일 복사(임시파일(temp) --> 본파일(target))FileWriter fw = new FileWriter(target);
		File target = new File(dir, "noth.kh");
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(temp));
		BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(target));
		out.write(in.readAllBytes());
		in.close();
		out.close();

	}

}
