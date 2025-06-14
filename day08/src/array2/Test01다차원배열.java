package array2;

public class Test01다차원배열 {

	public static void main(String[] args) {
		//차원이란 무엇인가?
		//- 데이터를 바라보는 관점(높이)
		 
		//(ex)
		//3개 지역에서 5개의 학교를 뽑아
		//각 학년마다 2개씩 반을 정하고 10명씩 추첨하여 성적 정보를 수집
		//- 0차원 : 성적 정보 900개 = 변수 900개
		//- 1차원 : 학생 900명 = 1차원 배열 1개(900칸)
		int[] students = new int[900];
		//- 2차원 : 반 90개 = 2차원 배열 1개(90줄 10칸)
		int[][] classrooms = new int[90][10]; //반 90개씩, 학생 10명씩. 
		// 높은 차원을 먼저 써준다. 모든 차원은 1차원으로 바꿀 수 있다. 높은 차원과 낮은 차원의 구분이 헷갈리면 1차원으로 바꿔보면 된다. 
		// ex) 반 3개 * 학생 2명 = 학생 6명 -> 반이 더 높은 차원
		//- 3차원 : 학년 45개 = 3차원 배열 1개(45 x 2 x 10)
		int[][][] levels = new int[45][2][10]; // int[][][] levels = new int[10][2][45]; -> 엄연히 다른 구조
		//- 4차원 : 학교 15개 = 4차원 배열 1개(15 x 3 x 2 x 10)
		int[][][][] schools = new int[15][3][2][10];
		//- 5차원 : 지역 3군데 = 5차원 배열 1개(3 x 5 x 3 x 2 x 10)
		int [][][][][] regions = new int [3][5][3][2][10];
	}

}
