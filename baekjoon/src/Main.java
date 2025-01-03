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

//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		int m = sc.nextInt();
//		int[][] numbers = new int[n][m];
//		
//		for(int i = 0; i < 2; i++) {
//			for (int k = 0; k < numbers.length; k++) {
//				for(int j = 0; j < numbers[m].length; j++) {
//					numbers[k][j] = sc.nextInt();
//				}
//			}
//		}
//		
//		for (int k = 0; k < numbers.length; k++) {
//			for(int j = 0; j < numbers[m].length; j++) {
//				numbers[0][0] + numbers[3][1]
////			}
////		}
//		
//			String control = "wasdwasdas";
//			int[] numlog = new int[] {};
//			for (int i = 0; i < control.length(); i++) {
//				if(control.charAt(i) == 'w') n++;
//				else if(control.charAt(i) == 's') n--;
//				else if(control.charAt(i) == 'd') n += 10;
//				//else n -= 10;
//			}
//		

//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		
//		for (int i = n; i > 0; i--) {
//			for (int k = 0; k < i; k++) {
//				if(k < i) {
//					System.out.print(" ");
//				}
//				else {
//					System.out.print("*");
//				}
//										
//			}
//			System.out.println();
//		}
		
//		Scanner sc = new Scanner(System.in);
//		
//		//int[] num = new int[10];
//		int[] num = new int[] {42,84,252,420,840, 126,42,84,420,126};
//		int[] rest = new int[10];
//		for (int i = 0; i < num.length; i++) {
//			//num[i] = sc.nextInt();
//			rest[i] = num[i] % 42;
//		}
//		int answer = 10;
//		int target = 0;
//		for(int k = 0; k < rest.length; k++) {
//			if(rest[k] == target) {
//				answer--;
//			}
//		}
//		System.out.println(answer);
		
		String[] s1 = new String[] {"n", "omg"};
		String[] s2 = new String[] {"m", "dot"};
		
		int answer = 0;
		
		 for(int k = 0; k < s1.length; k++){
	            for(int i = 0; i < s2.length; i++){
	                if(s1[k].equals(s2[i])){
	                    answer++;
	                } 
	            }
	     }
		 System.out.println(answer);
		
		
	
		
		
		

//		int[] sides = new int[] {199, 72, 222};
//		int answer = 0;
//        
//        int max = 0;
//        int rest = 0;
//        for(int i = 0; i < 3; i++){
//            if(sides[i] > max){
//                max = sides[i];
//            }
//            else rest += sides[i];
//        }
//        System.out.println(rest);
//        
//        if(max < rest){
//            answer = 1;
//        }
//        else answer = 2;
		
		
		
	}

}