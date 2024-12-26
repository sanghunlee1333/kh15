package api.io.object;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test05회원가입프로그램 {

	public static void main(String[] args) throws IOException {

		//파일을 불러와서 database를 읽어들이도록 설정
		//-> 파일은 없을 수도 있다
		Map<String, String> database;
				
		//Load -> 메소드로 처리 가능
		try { //플랜A -> (강의 참고)
			File target = new File("sample", "member.db");
			FileInputStream in = new FileInputStream(target);
			BufferedInputStream inBuffer = new BufferedInputStream(in);
			ObjectInputStream inObj = new ObjectInputStream(inBuffer);
			database = (Map<String, String>) inObj.readObject(); 
			inObj.close();			
		}
		catch(Exception e) { //플랜B
			database = new HashMap<>();
		}

		
//		database.put("이상훈", "abcd1234");
//		database.put("이상진", "xcvz1234");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		System.out.print("비밀번호 : ");
		String password = sc.nextLine();
		sc.close();

		boolean hasid = database.containsKey(id);

		if (hasid) { // 아이디가 이미 사용중이라면
			System.out.println("사용중인 아이디");
		} else { // 아이디가 사용중이 아니라면
			database.put(id, password);
			System.out.println("가입 완료");
		}
		
		//Save -> 메소드로 처리 가능
		//처리 결과를 저장
		File target = new File("sample", "member.db");
		FileOutputStream out = new FileOutputStream(target);
		BufferedOutputStream outBuffer = new BufferedOutputStream(out);
		ObjectOutputStream outObj = new ObjectOutputStream(outBuffer);
		
		outObj.writeObject(database);
		
		outObj.close();

	}

}
