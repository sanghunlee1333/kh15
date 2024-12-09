package loop4;
import java.util.Random;
import java.util.Scanner;

public class Test05베스킨라빈스게임 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		int total = 1;

		/*
		 while (true) { 
		 	System.out.println("현재 차례 : " + total);
		 	System.out.print("선택할 숫자의 개수 : "); 
		 	int num = sc.nextInt(); // 1, 2, 3 
		 	total += num;
		 	if (total > 31) { 
		 		System.out.println("당신은 패배했습니다!"); 
		 		break; 
		 	} 
		 }
		 */

		while (true) {
			System.out.println("현재 차례 : " + total);
			System.out.print("선택할 숫자의 개수 : ");
			int userNum = sc.nextInt(); // 1, 2, 3

			// (+추가) 1~3이 아니면 다시 시작하도록 처리
			if (userNum < 1 || userNum > 3) {
				continue; // 다음 바퀴로 점프
			}

			// (+추가) 선택한 숫자 개수만큼의 출력을 추가
			for (int i = total; i < total + userNum; i++) {
				System.out.print(i + "\t");			
			}
			System.out.println("선택 완료");

			total += userNum;

			// 탈출 조건 : 31을 선택하면 = number가 31보다 크면
			if (total > 31) {
				break;
			}
			
			//(업그레이드) 컴퓨터와 1대1
			/*
			int comNum = r.nextInt(3) + 1;
			System.out.println("컴퓨터가 선택한 숫자의 개수 : " + comNum);
			total += comNum;

			if (total > 31) {
				System.out.println("당신이 이겼습니다!");
				break;
			}
			*/
		}
		System.out.println("당신은 패배했습니다!");
	}

}
