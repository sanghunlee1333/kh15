package api.io.string;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Test03문자열입력 {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		File target = new File("sample/string4.txt");
		FileReader fr = new FileReader(target);
		BufferedReader br = new BufferedReader(fr);
		
		//BufferedReader를 통해 한 줄씩 읽을 수 있다
		//(주의) PrintReader는 없다
		while(true) {
			String line = br.readLine();
				
			//Thread.sleep(500);
			if(line == null) break; //EOF(null)
			System.out.println("line = " + line);
			
		}
		br.close();
	}

}
