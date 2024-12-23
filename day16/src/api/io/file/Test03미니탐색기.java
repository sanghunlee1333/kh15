package api.io.file;

import java.io.File;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Test03미니탐색기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("경로 : ");
		File f1 = new File(sc.nextLine());

		if (!f1.exists()) { // 파일 또는 디렉토리가 존재하지 않는다면
			System.out.println("존재하지 않는 경로입니다");
		}
		if (f1.isFile()) { // 사용자가 입력한 것이 파일이라면
			System.out.println("파일명 : " + f1.getName());
			System.out.println("파일크기 : " + f1.length() + "bytes");
			long time = f1.lastModified();
			Date date = new Date(time);
			Format fmt = new SimpleDateFormat("y년 M월 d일 a h시 m분 s초");
			System.out.println("최종수정시각 : " + fmt.format(date));
		} else if (f1.isDirectory()) { // 사용자가 입력한 것이 디렉터리라면
			File[] files = f1.listFiles(); // 파일이 여러개
			String type = "";
			for (File file : files) {
				if (file.isFile()) {
					type = "[파일]";
				} else if (file.isDirectory()) {
					type = "[폴더]";
				}
				System.out.println(file.getName() + " " + type);

			}

		}

	}

}
