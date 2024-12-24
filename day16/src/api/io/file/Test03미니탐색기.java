package api.io.file;

import java.io.File;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Test03미니탐색기 {

	public static void main(String[] args) {
		
		
//		Scanner sc = new Scanner(System.in);
//		System.out.print("경로 : ");
//		File f1 = new File(sc.nextLine());
//
//		if (!f1.exists()) { // 파일 또는 디렉토리가 존재하지 않는다면
//			System.out.println("존재하지 않는 경로입니다");
//		}
//		if (f1.isFile()) { // 사용자가 입력한 것이 파일이라면
//			System.out.println("파일명 : " + f1.getName());
//			System.out.println("파일크기 : " + f1.length() + "bytes");
//			long time = f1.lastModified();
//			Date date = new Date(time);
//			Format fmt = new SimpleDateFormat("y년 M월 d일 a h시 m분 s초");
//			System.out.println("최종수정시각 : " + fmt.format(date));
//		} else if (f1.isDirectory()) { // 사용자가 입력한 것이 디렉터리라면
//			File[] files = f1.listFiles(); // 파일이 여러개
//			String type = "";
//			for (File file : files) {
//				if (file.isFile()) {
//					type = "[파일]";
//				} else if (file.isDirectory()) {
//					type = "[폴더]";
//				}
//				System.out.println(file.getName() + " " + type);
//
//			}
//
//		}
		//경로 입력
		Scanner sc = new Scanner(System.in);
		System.out.print("입력 : "); // 경로 입력 시, / 또는 \ 둘다 상관없으나, /를 추천
		String path = sc.nextLine(); //파일 이름에 띄어쓰기가 있을 가능성이 있으므로 Line으로 받아야 함
		sc.close();
		
		//파일 제어 객체를 생성
		File target = new File(path);
		//target.mkdirs(); //디렉터리 생성
		//target.createNewFile(); //파일 생성
		
		if(target.isFile()) {//파일이라면 //현재 프로그램 목적에 맞는 것을 먼저 적는게 좋음
			System.out.println("[" + target.getName() + "] 파일 정보");
			Format f2 = new DecimalFormat("#, ##0");
			System.out.println("크기 : " + f2.format(target.length()) + "bytes");
			Date d = new Date(target.lastModified());
			Format f = new SimpleDateFormat("y년 M월 d일 a h시 m분 s초");
			System.out.println("최종수정시각 : " + f.format(d));
		}
		else if(target.isDirectory()) {//디렉터리라면
			System.out.println("[" + target.getName() + "] 디렉터리 정보");
			File[] files = target.listFiles();
			for(File f : files) {
				System.out.println(f.getName());
				if(f.isFile()) {
					System.out.println("[파일]");
				}
				else {
					System.out.println("[디렉터리]");
				}
			}
		}
		else {//존재하지 않는다면
			System.err.println("존재하지 않는 폴더 혹은 파일입니다");
		}

	}

}
