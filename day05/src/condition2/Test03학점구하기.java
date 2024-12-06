package condition2;

import java.util.Scanner;

public class Test03학점구하기 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("점수를 입력하세요 : ");
		
		int score = sc.nextInt();
		int ten = score / 10;
		String grade;

		switch (ten) {
		case 10: //100점
			grade = "A+";
			break;
		case 9: //90점 이상 100점 미만
			grade = "A";
			break;
		case 8: //80점 이상 90점 미만
			grade = "B";
			break;
		case 7: //70점 이상 80점 미만
			grade = "C";
			break;
		default: //70점 미만
			grade = "F";
		}
		System.out.println(grade);

	}

}
