package api.io.single;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test01싱글바이트출력 {

	public static void main(String[] args) throws IOException {
		//준비물 : 제어할 파일객체, 출력용 통로 객체
		
		File dir = new File("sample");
		dir.mkdirs(); //디렉터리 생성
		
		//File target = new File(dir, "single.txt");
		File target = new File("sample", "single.txt");
		FileOutputStream out = new FileOutputStream(target); //출력용 통로
		
		//[프로그램] -> out -> target -> [sample/single.txt]
		
		out.write(104); //out을 통해 아스키코드 104번을 내보내세요 (소문자 h)
		out.write(101); //e
		out.write(108); //l
		out.write(108); //l
		out.write(111); //o
		out.write(10); //\n
		
		out.write('h');
		out.write('e');
		out.write('l');
		out.write('l');
		out.write('o');
		out.write('\n');
		
		//아스키코드 범위를 벗어나면 안된다
		//- 초과한다면 byte(-128 ~ 127)로 강제변환되어 전송
		out.write(40000);
		out.write('밥');
		
		//통로는 자원소모가 크므로 사용이 끝났으면 해제
		out.close();
	}

}
