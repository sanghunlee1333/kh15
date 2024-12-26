package api.io.object;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test06회원가입프로그램심화 {

	public static void main(String[] args) throws IOException {

		// 파일을 불러와서 database를 읽어들이도록 설정
		// -> 파일은 없을 수도 있다
		// map은 어려움
		List<Member> list;
		try { // 플랜A -> (강의 참고)
			File target = new File("sample", "member2.db");
			FileInputStream in = new FileInputStream(target);
			BufferedInputStream inBuffer = new BufferedInputStream(in);
			ObjectInputStream inObj = new ObjectInputStream(inBuffer);
			list = (List<Member>) inObj.readObject();
			inObj.close();
		} catch (Exception e) { // 플랜B
			list = new ArrayList<>();
		}

		// list.add(new Member("이상훈", "abcd1234", "테스트유저1")); //더미 데이터
		// list.add(new Member("이상진", "abcd5678", "테스트유저2"));

		Scanner sc = new Scanner(System.in);
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		System.out.print("비밀번호 : ");
		String password = sc.nextLine();
		System.out.print("닉네임 : ");
		String nickname = sc.nextLine();
		sc.close();

		// list에 담긴 회원 정보들을 모두 조회하여 아이디와 닉네임을 검사
		boolean idValid = true, nicknameValid = true;
		for (Member member : list) { // 모든 회원을 조회하며
			if (member.getId().equals(id)) { // 아이디가 같은 회원을 발견하면
				idValid = false;
				break;
			} else if (member.getNickname().equals(nickname)) { // 닉네임이 같은 회원을 발견하면
				nicknameValid = false;
				break;
			}
		}

		// 결과에 따라 메시지 출력
		if (idValid == false) {
			System.out.println("아이디가 이미 사용중입니다");
		} else if (!nicknameValid) {
			System.out.println("닉네임이 이미 사용중입니다");
		} else {
			list.add(new Member(id, password, nickname));
			System.out.println("회원 가입이 완료되었습니다");
		}

		// 처리 결과를 저장
		File target = new File("sample", "member2.db");
		FileOutputStream out = new FileOutputStream(target);
		BufferedOutputStream outBuffer = new BufferedOutputStream(out);
		ObjectOutputStream outObj = new ObjectOutputStream(outBuffer);

		outObj.writeObject(list);

		outObj.close();

	}

}
