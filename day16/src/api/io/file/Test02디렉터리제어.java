package api.io.file;

import java.io.File;

public class Test02디렉터리제어 {

	public static void main(String[] args) {
		//디렉터리(Directory)
		//- 파일을 구분하기 위해 모아두는 역할의 도구
		//- 크기는 없음(정확히 얘기하면 운영체제마다 다르게 약간의 크기가 부여)
		//- 자신에 대한 분석보다 자신이 가지고 있는 파일에 대한 분석이 중요
		
		//(중요) 자바는 파일과 디렉터리를 같이 취급한다
		File dir = new File("sample");
		System.out.println("실제로 있어요? " + dir.exists());
		System.out.println("디렉터리인가요? " + dir.isDirectory());
		System.out.println("파일인가요? " + dir.isFile());
		
		if(dir.isDirectory()) {//dir이 디렉터리라면
			System.out.println("이름 : " + dir.getName());
			System.out.println("생성 시 설정한 경로 : " + dir.getPath());
			System.out.println("절대경로 : " + dir.getAbsolutePath());
			
			//(중요) 디렉터리는 크기가 없다
			System.out.println("크기 : " + dir.length());
			
			//자신이 가진 구성요소를 반환하는 명령이 존재
			//-.list는 이름만 반환
			//-.listFile()은 파일을 반환
			String[] names = dir.list(); //파일 이름이 여러개
			for(String name : names) {
				System.out.println("이름 = " + name);
			}
			
			File[] files = dir.listFiles(); //파일이 여러개
			for(File file : files) {
				System.out.print(file.getAbsolutePath());
				System.out.print("("+file.length()+")");
				System.out.println();
				
			}
		}
//		else {//파일? -> X 파일도 없는 경우가 있음.
//			
//		}
	}

}
