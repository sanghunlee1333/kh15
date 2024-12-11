package array2;

public class Test03이차원배열생성문제 {

	public static void main(String[] args) {
		int[][] a = new int[][] { 
			{ 100, 200 }, 
			{ 300, 400 }, 
			{ 500, 600 } 
		};
		float[][] b = new float[][] { 
			{ 1.2f, 2.3f, 3.4f, 4.5f },
			{ 2.3f, 3.4f, 4.5f, 5.6f } 
		};
		float[][] c = new float[2][4];
		c[0][0] = 1.2f;
		c[0][1] = 2.3f;
		c[0][2] = 3.4f;
		c[0][3] = 4.5f;
		c[1][0] = 2.3f;
		c[1][1] = 3.4f;
		c[1][2] = 4.5f;
		c[1][3] = 5.6f;

		String[][] d = new String[][] { 
			{ "안녕", "hello" }, 
			{ "안녕", "goodbye" } 
		};

		for (int i = 0; i < a.length; i++) { //a.length는 배열의 길이. 즉 배열의 세로 길이
			for (int k = 0; k < a[i].length; k++) { //2차원 배열에서의 a[i].length는 각 행의 길이. 즉 배열의 가로 길이
													//a[0].length -> 배열 a의 0번째 줄의 가로 길이
													//a[1].length -> 배열 a의 1번째 줄의 가로 길이
				System.out.println(a[i][k]);
			}
		}
		for (int i = 0; i < b.length; i++) {
			for (int k = 0; k < b[i].length; k++) { //b[0].length든 b[1].length든 현재로선 같은 값이어서 뭘 넣어도 상관없지만
													// 열의 가로 길이가 달라지는 가변 배열도 있기 때문에 세로 크기에 해당 하는 변수를 넣어둔다.
				System.out.println(b[i][k]);
			}
		}
		for (int i = 0; i < c.length; i++) {
			for (int k = 0; k < c[i].length; k++) {
				System.out.println(c[i][k]);
			}
		}
		for (int i = 0; i < d.length; i++) {
			for (int k = 0; k < d[i].length; k++) {
				System.out.println(d[i][k]);
			}
		}
	}

}
