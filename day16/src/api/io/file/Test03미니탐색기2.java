package api.io.file;

import java.io.File;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Test03미니탐색기2 {

	public static void main(String[] args) {

		// 방식1
		// 최상위 폴더(드라이브) 정보를 구하는 명령
//		File[] drives = File.listRoots();
//		for(File drive : drives) {
//			System.out.println(drive.getAbsolutePath());
//		}

		// 방식2 - 사용자의 홈 폴더 위치에서 시작(터미널(cmd)의 시작 지점 = 사용자 홈 폴더)
		String home = System.getProperty("user.home");
		System.out.println("home = " + home);

		Scanner sc = new Scanner(System.in);
		
		File current = new File(home);

		while (true) {
			
//			for(File f : current.listFiles()) {
//				System.out.println(f.getName());
//			}
			//메시지 표시
			System.out.print(current.getAbsolutePath() + ">");

			// 입력
			String input = sc.nextLine();

			Format fmt = new SimpleDateFormat("yyyy-MM-dd a hh:mm");
//			[1] dir이라는 명령어를 입력했다면
//			if(input.equalsIgnoreCase("dir")) { //대소문자를 무시하든지
			if (input.toLowerCase().equals("dir")) { // 소문자로 바꿔서 비교하던지
				for (File f : current.listFiles()) {
					// 시간찍고
					Date d = new Date(f.lastModified());
					System.out.print(fmt.format(d));
					// 간격 벌리고
					System.out.print("\t");
					if (f.isDirectory()) { // 폴더 표시하고
						System.out.print("<DIR>");
					} else {
						System.out.print("\t");
					}
					// 간격 벌리고
					System.out.print("\t");
					// 이름 찍고
					System.out.print(f.getName());
					System.out.println();
				}

			}
//			[2] 종료 명령
			else if (input.toLowerCase().equals("exit")) {
				System.out.println("프로그램을 종료합니다");
				System.exit(0);
			}
//			[3] 위치 변경 명령(change directory, CD)
			else if(input.toLowerCase().startsWith("cd")) {
				//cd+space는 제거
//				input = input.substring(3);
				input = input.substring("cd ".length());
				
				if(input.equals("..")) {//cd .. 이면 상위폴더로 이동
					File target = current.getParentFile();
					if(target == null) {
						System.err.println("최상위 폴더입니다");
					}
					else {
						current = target;
					}
				}
				else if(input.equals(".")) {//cd . 이면 아무것도 안함
					System.out.println(current.getAbsolutePath());
				}
				else {
					//current의 위치를 변경
					File target = new File(current, input);//current 안에 있는 input
					if(target.isDirectory()) {//디렉터리일때만
						current = target;//현재위치를 변경
					}
					else {
						System.err.println("올바른 디렉터리가 아닙니다");
					}
				}
			}
//			[4] 드라이브 변경 명령
			else if(input.matches("^[A-Z]:[\\\\\\/]?$")) {
				if(!input.endsWith("/") && !input.endsWith("\\")) {
					input += "/";
				}
				File drive = new File(input);
				if(drive.exists()) {
					current = drive;
				}
				else {
					System.err.println("존재하지 않는 드라이브입니다");
				}
			}
			
			
		}
		
	}
}
