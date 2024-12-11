package array2;

public class Test02이차원배열 {

	public static void main(String[] args) {

		// 2차원 배열
		// - 표와 같은 모양을 가지는 배열
		// - 1차원 배열을 모아둔 형태

		// (ex) 2개 반에서 각각 3명씩의 성적 정보
		int[][] a = new int[2][3];
		// a -----> [0] ------> [0][0][0]
		// a -----> [1] ------> [0][0][0]

		int[][] b = new int[][] { { 50, 60, 70 }, { 80, 50, 65 } };

		// b -----> [0] ------> [50][60][70]
		// b -----> [1] ------> [80][50][65]

		System.out.println(b); // 2차원 리모컨. 출력 시 앞에 [[는 2차원 배열이라는 의미. I는 int형
		System.out.println(b[0]); // 1차원 리모컨
		System.out.println(b[1]); // 1차원 리모컨
		// 위의 것들은 쓸 일이 거의 없다.

		System.out.println(b[0][0]);
		System.out.println(b[0][1]);
		System.out.println(b[0][2]);
		System.out.println(b[1][0]);
		System.out.println(b[1][1]);
		System.out.println(b[1][2]);
		
		/*
		for (int k = 0; k <= 1; k++) {
			for (int i = 0; i <= 2; i++) {
				System.out.println(b[k][i]);
			}
		}
		*/
	}

}
