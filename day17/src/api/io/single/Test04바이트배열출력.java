package api.io.single;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test04바이트배열출력 {

	public static void main(String[] args) throws IOException {
		//바이트를 모아서 출력
		//- 준비물 : 출력용파일, 출력용통로
		
		File target = new File("sample/singlearray.txt");
		FileOutputStream out = new FileOutputStream(target);
		
		byte[] data = new byte[] {'H','e','l','l','o', ' ', 'J','a','v','a','!'};
		
		out.write(data); //data에 있는 모든 글자를 출력
		out.write('\n'); //개행
		out.write(data, 0, 5); //data 중 일부만 출력 (주의) 0부터 "5개"
		out.write('\n');
		out.write(data, 6, 4); //data 중 일부만 출력 (주의) 6부터 "4개"
		
		out.close();
	}

}
