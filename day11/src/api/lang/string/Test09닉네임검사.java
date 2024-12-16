package api.lang.string;

import java.util.Scanner;

public class Test09닉네임검사 {

	public static void main(String[] args) {
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

	}

}
