package api.io.string;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Test02콘솔메모장 {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		
		File target = new File("sample", "note.kh");
		FileWriter fw = new FileWriter(target);
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

	}

}
