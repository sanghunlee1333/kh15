package api.io.file;

import java.io.File;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test01파일제어 {

	public static void main(String[] args) {
		//File f1 = new File("dummy"); //이미 존재하는 파일을 제어할 수 있는 도구 생성
		File f1 = new File("D:\\kh15\\github\\kh15\\day16\\dummy"); 
		
		System.out.println("실제로 있어요? " + f1.exists());
		if(f1.exists()) {
			System.out.println("파일명 : " + f1.getName());
			System.out.println("파일의 생성 시 설정한 위치 : " + f1.getPath()); //풀 주소를 넣으면 풀 주소로 나옴 -> 생성 시 입력한 경로가 나온다고 보면 됨
			System.out.println("파일의 절대위치 : " + f1.getAbsolutePath());
			System.out.println("파일 크기 : " + f1.length() + "bytes"); //파일은 글자를 가지고 있음 -> 글자 길이가 파일 크기를 결정!
			
			long time = f1.lastModified(); //수정시각
			System.out.println("최종수정시각 : " + time);
			//형식 변환하여 출력
			Date date = new Date(time);
			Format fmt = new SimpleDateFormat("y년 M월 d일 H시 m분 s초");
			System.out.println("최종수정시각: " + fmt.format(date));
			
			System.out.println("쓰기 가능? " + f1.canWrite()); //읽기 전용은 쓰기가 안된다는 의미
			System.out.println("숨겨져 있나? " + f1.isHidden());
			
		}
		
	}

}
