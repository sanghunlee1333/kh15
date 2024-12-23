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

		if (!f1.exists()) {
			System.out.println("존재하지 않는 경로입니다");
		}
		if (f1.isFile()) {
			System.out.println("파일명 : " + f1.getName());
			System.out.println("파일크기 : " + f1.length());
			long time = f1.lastModified();

			Date date = new Date(time);
			Format fmt = new SimpleDateFormat("y년 M월 d일 H시 m분 s초");
			System.out.println("최종수정시각 : " + fmt.format(date));
		} else if (f1.isDirectory()) {

			File[] files = f1.listFiles(); // 파일이 여러개
			String type = "";
			for (File file : files) {
				String[] names = f1.list();
				if (file.isFile()) {
					type = "[파일]";
				} else if (file.isDirectory()) {
					type = "[폴더]";
				}
				for (String name : names) {
					System.out.println(name + " " + type);
				}
			}

		}

	}

}
