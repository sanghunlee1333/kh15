package loop4;

import java.util.Scanner;

public class Test06숫자모래성게임 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int sand = 100;
		int turn = 0;
		
		while(true) {
			System.out.println("남은 숫자 : " + sand);
			System.out.print("차감시킬 숫자 입력(1~9) : ");
			int user = sc.nextInt();
			//(참고) 어떤 구문에 중괄호가 없다면 다음 명령 딱 한줄만 구문에 포함된다
			if (user < 1 || user > 9) continue;
			turn++; //턴 카운트 증가
			sand -= user; //모래 가져가기
			
			//탈출 조건 : 남은 모래가 0인 경우
			if (sand <= 0) {
				break;
			}
		}
		System.out.println("당신은 패배했습니다"); //if문 안에 쓰기보단, 멘트 자체가 게임 자체가 끝났다는 내용이므로 밖에 쓴다.
		System.out.println("총 " + turn + "턴 동안 진행했습니다.");
		
	}

}
