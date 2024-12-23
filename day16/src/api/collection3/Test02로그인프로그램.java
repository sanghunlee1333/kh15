package api.collection3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test02로그인프로그램 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 데이터 준비
		Map<String, String> db = new HashMap<>();
		db.put("khadmin", "admin1234");
		db.put("khstudent", "student1234");
		db.put("khteacher", "teacher1234");
		db.put("khmanager", "manager1234");

		// 사용자 입력
		while (true) {

			System.out.print("아이디 : ");
			String id = sc.next();
			System.out.print("비밀번호 : ");
			String password = sc.next();
			sc.close();
			
			boolean idValid = db.containsKey(id);
			String dbPassword = db.get(id);
			//boolean PasswordValid = dbPassword != null && dbPassword.equals(password);
			boolean PasswordValid = password.equals(dbPassword);

			if (idValid && PasswordValid) {
				System.out.println("**로그인 성공**");
			} else {
				System.out.println("**입력하신 정보가 일치하지 않습니다**");
			}
		}
	}

}
