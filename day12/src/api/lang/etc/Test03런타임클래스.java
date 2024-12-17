package api.lang.etc;

import java.io.IOException;

public class Test03런타임클래스 {

	public static void main(String[] args) throws IOException {
		// Runtime 클래스
		// - 외부 실행환경에 명령을 보낼 수 있는 도구
		// - 생성자가 없지만 생성 명령이 있는 경우

		// Runtime rt = new Runtime(); (X)
		Runtime rt = Runtime.getRuntime();

		String os = System.getProperty("os.name");
		if (os.toLowerCase().startsWith("window")) {
// 			rt.exec("notepad");
//			rt.exec("mspaint");
//			rt.exec("calc");
//			rt.exec("cmd /c start https://iei.or.kr"); 
			rt.exec(new String[] { "cmd", "/c", "start", "https://iei.or.kr" });
		}
		else if(os.toLowerCase().startsWith("mac")) {
			rt.exec(new String[] {"open", "-a", "TextEdit.app"});
			rt.exec(new String[] {"open", "https://iei.or.kr"});
		}
		
	}

}
