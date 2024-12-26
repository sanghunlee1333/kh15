package api.io.string;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Test01문자열출력 {

	public static void main(String[] args) throws IOException {
		//문자열은 객체 출력과 바이트 출력이 모두 가능
		
		String str = "안녕하세요";
		
		File target = new File("sample", "string1.txt");
		FileOutputStream out = new FileOutputStream(target);
		BufferedOutputStream buffer = new BufferedOutputStream(out);
		ObjectOutputStream obj = new ObjectOutputStream(buffer);
		
		obj.writeObject(str);
		
		obj.close();
	}

}
