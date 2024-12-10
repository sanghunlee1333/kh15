package array;

public class Test03성적분석프로그램 {
		
	public static void main(String[] args) {
		
		/*
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
		System.out.println(average); // 4. 전체 학생의 점수 평균 구하기
		
		int newStudent = 85;
		
		for (int i = 0; i < score.length; i++) { 
			if (newStudent < score[i]) {
				num++;
			}
		}
		System.out.println(num); // 5. 11번째 학생 등수 구하기
		*/
		
		//입력
		int[] scoreList = new int[] {77, 82, 95, 91, 65, 87, 68, 85, 82, 90};

		//1. 모든 학생의 점수를 출력
		for (int i = 0; i < scoreList.length; i++) {
			System.out.println("점수 = " + scoreList[i]);
		}
		
		//2. 성적 우수자(90점 이상) 학생의 점수만 출력
		for (int i = 0; i < scoreList.length; i++) {
			if(scoreList[i] >= 90) {
				System.out.println("성적 우수자 = " + scoreList[i]);
			}
		}
		
		//3. 재평가 대상자(70점 미만) 학생의 점수만 출력
		for (int i = 0; i < scoreList.length; i++) {
			if(scoreList[i] < 70) {
				System.out.println("재평가 대상자 = " + scoreList[i]);
			}
		}
		
		//4. 전체 학생의 점수 평균을 구하여 출력 (평균 = 총점 / 인원수)
		int total = 0;
		for (int i = 0; i < scoreList.length; i++) {
			total += scoreList[i];
		}
		// System.out.println("총점 = " + total);
		float average = (float)total / scoreList.length;
		System.out.println("평균 = " + average);
		
		//(+추가) 85점의 학생이 11번째 학생으로 추가될 경우 예상 등수?
		int score = 85;
		int rank = 1;
		for(int i = 0; i < scoreList.length; i++) {
			if(score < scoreList[i]) {//더 잘난 놈이 나타나면
				rank++;//등수가 밀려요
			}
		}
		System.out.println("예상 등수 = " + rank);
	}

}
