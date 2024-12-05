package condition;

import java.util.Scanner;

public class Test03합격판정기 {

	public static void main(String[] args) {

		//입력
		Scanner sc = new Scanner(System.in);
		System.out.print("국어점수 : ");
		int kor = sc.nextInt();
		System.out.print("영어점수 : ");
		int eng = sc.nextInt();
		System.out.print("수학점수 : ");
		int mat = sc.nextInt();
		
		//처리
		boolean korPass = kor >= 40;
		boolean engPass = eng >= 40;
		boolean matPass = mat >= 40;
		
		double avg = (kor + eng + mat) / 3.0;		
		boolean avgPass = avg >= 60;
		
		boolean allPass = korPass & engPass & matPass & avgPass;
		
		//출력
		if(allPass) {
			System.out.println("합격입니다");
		}
		else {
			System.out.println("불합격입니다.");
		}

	}

}
