package api.io.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test04표준입력 {

	public static void main(String[] args) throws IOException {
		//Scanner가 아니라 BuffedReader로 키보드 입력받기
		//Scanner sc = new Scanner(System.in); //System.in은 InputStream
		
		//Reader는 220v, InputStream은 110v 같은 존재라 서로 연결이 안됨
		//연결하고 싶다면 변환 클래스를 사용해야 함(어댑터 클래스)
		//InputStreamReader isr = new InputStreamReader(System.in, "UTF-8");
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		System.out.print("입력 : ");
		String line = br.readLine();
		
		br.close();
		
		System.out.println("입력값 : " + line);
	}

}
