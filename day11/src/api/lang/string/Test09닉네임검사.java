package api.lang.string;

import java.util.Scanner;

public class Test09닉네임검사 {

	public static void main(String[] args) {
		
		/*
		Scanner sc = new Scanner(System.in);

		String nickname = sc.next();
		StringBuffer buffer = new StringBuffer();
		
		boolean nicknameLength = nickname.length() >= 2 && nickname.length() <= 10; // 2글자 이상 10글자 이하인지
		boolean hasOperator = nickname.contains("운영자"); //운영자를 포함하고 있는지
		boolean hasFirst = nickname.charAt(0) >= (char)'0' && nickname.charAt(0) <= '9'; //첫 글자가 0과 9 사이인지
		
		if (nicknameLength) { 
			if (!hasOperator) {
				if (!hasFirst) { 
					for (int i = 0; i < nickname.length(); i++) { // 첫 번째 글자부터 마지막 글자까지
						if (nickname.charAt(i) >= (char)'0' && nickname.charAt(i) <= (char)'9' // 각 글자가 0 ~ 9 사이의 숫자인지
								|| nickname.charAt(i) >= '가' && nickname.charAt(i) <= '힣') { // 혹은 각 글자가 가 ~ 힣 사이의 문자인지
							buffer.append(nickname.charAt(i)); // 맞으면 문자열 합성
						} else { // 한글 또는 숫자 외에 다른 것이 있다면
							System.out.println("닉네임 형식에 맞지 않습니다");
							break;
						}
					}				
				} else { // 첫 번째 글자가 숫자라면
					System.out.println("닉네임 형식에 맞지 않습니다");
				}

			} else { // "운영자"가 포함되어 있다면
				System.out.println("닉네임 형식에 맞지 않습니다");
			}

		} else { // 2글자 미만 10글자 초과라면
			System.out.println("닉네임 형식에 맞지 않습니다");
		}
		
		if (nickname.equals(buffer.toString())){ // 닉네임이 buffer에서 쌓은 문자와 최종적으로 같다면
			System.out.println("닉네임 설정 완료");
		}
		*/
		
		//입력
		String nickname = "테스트닉네임";
		
		//처리
		//1. 닉네임 글자수가 2~10글자인지 검사
		boolean lengthOk = nickname.length() >= 2 && nickname.length() <= 10;
		// System.out.println("lengthOk = " + lengthOk); //중간 중간 확인이 꼭 필요!
		
		//2. 닉네임이 한글 또는 숫자로만 이루어져 있는지 검사
		int count = 0;
		for(int i = 0; i < nickname.length(); i++) {
			char ch = nickname.charAt(i);
			if(ch >= '가' && ch <= '힣') { //ㄱㄴㄷ..ㅏㅑㅓ 자음/모음은 포함 안됨. 전체한글을 포함할 것이면 ㄱ~ㅎ/ㅏ~ㅣ/가~힣 세 개를 포함시켜줘야 한다.
				count++;
			}
			else if (ch >= '0' && ch <= '9') { //그냥 0은 null, 9는 \t다. -> '0', '9'로 바꿔줘야 함.
				count++;
			}
		}
		//System.out.println("count = " + count);
		boolean koreanAndNumberOk = count == nickname.length();
		//System.out.println("koreanAndNumberOk = " + koreanAndNumberOk);
		
		//boolean notCountAdmin = nickname.contains("운영자") == false;
		boolean notCountAdmin = !nickname.contains("운영자"); //같은 표현
		//System.out.println("notCountAdmin = " + notCountAdmin);
		
		//4. 첫 글자가 숫자일 수 없다(첫 글자가 한글이어야 한다)
		char first = nickname.charAt(0);
		boolean firstIsNotNumber = !(first >= '0' && first <= '9');	//char를 안적고 ''로만 표기해줘도 그 자체로 char형으로 인식!
		//System.out.println("firstIsNotNumber = " + firstIsNotNumber);
		
		boolean valid = lengthOk && koreanAndNumberOk && notCountAdmin && firstIsNotNumber;
		
		//출력
		if(valid) {
			System.out.println("닉네임 설정 완료");
		}
		else {
			System.out.println("닉네임 형식에 맞지 않습니다");
		}
		

	}

}
