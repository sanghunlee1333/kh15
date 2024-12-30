import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

//		Scanner sc = new Scanner(System.in);
//		
//		int king = sc.nextInt();
//		int queen = sc.nextInt();
//		int rook = sc.nextInt();
//		int bishop = sc.nextInt();
//		int fone = sc.nextInt();
//		
//		if(!(king == 1)) {
//			System.out.print(king - (king - 1) + " ");
//		}
//		else System.out.print(king);
//		
//		if(!(queen == 1)) {
//			System.out.print(queen - (queen - 1) + " ");
//		}
//		else System.out.print(queen);
//		
//		if(!(rook == 2)) {
//			System.out.print(rook - (rook - 2) + " ");
//		}
//		else System.out.print(rook);
//		
//		if(!(queen == 1)) {
//			System.out.print(queen - (queen - 1) + " ");
//		}
//		else System.out.print(queen);
//		
//		if(!(queen == 1)) {
//			System.out.print(queen - (queen - 1) + " ");
//		}
//		else System.out.print(queen);
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] numbers = new int[n][m];
		
		for(int i = 0; i < 2; i++) {
			for (int k = 0; k < numbers.length; k++) {
				for(int j = 0; j < numbers[m].length; j++) {
					numbers[k][j] = sc.nextInt();
				}
			}
		}
		
//		for (int k = 0; k < numbers.length; k++) {
//			for(int j = 0; j < numbers[m].length; j++) {
//				numbers[0][0] + numbers[3][1]
//			}
//		}
		
	

	}

}