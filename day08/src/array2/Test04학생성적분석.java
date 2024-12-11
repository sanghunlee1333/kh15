package array2;

public class Test04학생성적분석 {

	public static void main(String[] args) {
		/*
		int[][][] grade = new int[][][] { 
			{ { 77, 85, 86, 92, 60 } }, 
			{ { 80, 82, 55, 95, 85 } },
			{ { 90, 92, 85, 70, 67 } } 
		};
		
		for (int k = 0; k < grade.length; k++) {
			for (int j = 0; j < grade[k].length; j++) {
				if(k>=1)System.out.println();
				for (int i = 0; i < 5; i++) {
					System.out.println("성적 : " + grade[k][j][i]);
				}
			}
		}
		
		for (int k = 0; k < grade.length; k++) {
			for (int j = 0; j < grade[k].length; j++) {
				if(k>=1)System.out.println();
				for (int i = 0; i < 5; i++) {
					if(grade[k][j][i] >= 90){
						System.out.println("성적우수자 : " + grade[k][j][i]);
					}
				}
			}
		}
		
		int count = 0;
		for (int k = 0; k < grade.length; k++) {
			for (int j = 0; j < grade[k].length; j++) {
				if(k>=1)System.out.println();
				for (int i = 0; i < 5; i++) {
					if(grade[k][j][i] < 70){
						count++;
					}
				}
				System.out.println("70점 미만 인원수 : " + count++);
				count = 0;
			}
		}
		int total = 0;
		double average = 0.0;
		for (int k = 0; k < grade.length; k++) {
			for (int j = 0; j < grade[k].length; j++) {
				if(k>=1)System.out.println();
				for (int i = 0; i < 5; i++) {
					total += grade[k][j][i];
					count++;
					average = (double)total / count;
				}
				System.out.println("반의 평균은 : " + average);
				total = 0;
				count = 0;
			}
		}
		*/
		
		int[][] scoreList = new int[][] {
			{77, 85, 86, 92, 60},
			{80, 82, 55, 95, 85},
			{90, 92, 85, 70, 67}
		};
		
		//1. 반마다 구분하여 출력
		for(int i = 0; i < scoreList.length; i++) {
			System.out.println("<반 정보>");
			for(int k = 0; k < scoreList[i].length; k++) {
				System.out.println("점수 = " + scoreList[i][k]);
			}
		}
		
		//2. 반마다 성적 우수자만 출력
		for(int i = 0; i < scoreList.length; i++) {
			System.out.println("<반 정보>");
			for(int k = 0; k < scoreList[i].length; k++) {
				if(scoreList[i][k] >= 90) {
				System.out.println("점수 = " + scoreList[i][k]);
				}
			}
		}
		
		//3. 반마다 재평가자 인원수 출력
		int[] fail = new int[3]; //카운트를 배열로 생성
		// int count = 0;
		for(int i = 0; i < scoreList.length; i++) {
			for(int k = 0; k < scoreList[i].length; k++) {
				if(scoreList[i][k] < 70) {
					fail[i]++;
					// count++; 
					// 카운트로 하면 안되는 이유는 각 반 별로 세지 못하고, 1차원적으로 인원을 합쳐버리니 안되는 것임. 
					// 그래서 각 반별로 인원을 합계할 수 있도록 1차원 배열 생성
				}
			}
		}
		for (int i = 0; i < fail.length; i++) {
			System.out.println("재평가자 = " + fail[i] + "명"); 												
		}
		
		//4. 반 평균을 출력
		int[] total = new int[3];
		float[] average = new float[3];
		
//		total[0] += scoreList[0][0];
//		total[0] += scoreList[0][1];
//		total[0] += scoreList[0][2];
//		total[0] += scoreList[0][3];
//		total[0] += scoreList[0][4];
//		
//		average[0] = (float)total[0] / scoreList[0].length;
		
		for (int i = 0; i < scoreList.length; i++) {
			for (int k = 0; k < scoreList[i].length; k++) {
				total[i] += scoreList[i][k];
			}
			average[i] = (float)total[i] / scoreList[i].length;
		}
		
		for(int i = 0; i < average.length; i++) {
			System.out.println("반 평균 = " + average[i]);
		}
		
		//4. 85점인 학생이 전학왔을때 A, B, C반에서의 예상 등수
		int score = 85;
		int[] grade = new int[] {1,1,1}; //전학 온 학생이 1등이라 가정
		for (int i = 0; i < scoreList.length; i++) {
			for (int k = 0; k < scoreList[i].length; k++) {
				if(score < scoreList[i][k]) { //전학 온 학생의 점수가 각 반의 학생의 점수보다 작으면 
					grade[i]++;	//등수 증가
				}
			}
		}
		
		for (int i = 0; i < scoreList.length; i++) {
			System.out.println("예상 등수 : " + grade[i]);
		}
	}

}
