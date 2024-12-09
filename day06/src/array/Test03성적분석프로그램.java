package array;

public class Test03성적분석프로그램 {

	public static void main(String[] args) {
		int[] score = new int[] { 77, 82, 95, 91, 65, 87, 68, 85, 82, 90 };
		int total = 0;
		double average = 0;
		int num = 1;

		for (int i = 0; i < score.length; i++) {
			System.out.println(score[i]); // 1. 모든 학생의 점수 출력
		}
		System.out.println(); // 줄 띄우기

		for (int i = 0; i < score.length; i++) {
			if (score[i] >= 90) {
				System.out.println(score[i]); // 2. 90점 이상의 학생의 점수 출력
			}
		}
		System.out.println(); // 줄 띄우기

		for (int i = 0; i < score.length; i++) {
			if (score[i] < 70) {
				System.out.println(score[i]); // 3. 70점 미만의 학생의 점수 출력
			}
		}
		System.out.println(); // 줄 띄우기
		
		for (int i = 0; i < score.length; i++) {
			total += score[i];
			average = (double)total / score.length;
		}
		System.out.println("전체 학생의 평균 점수는 " + average); // 4. 전체 학생의 점수 평균 구하기
		
		int newStudent = 85;
		
		for (int i = 0; i < score.length; i++) { 
			if (newStudent < score[i]) {
				num++;
			}
		}
		System.out.println("전학 온 학생의 예상 등수는 " + num); // 5. 11번째 학생 등수 구하기

	}

}
