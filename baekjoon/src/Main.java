import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

//		Scanner sc = new Scanner(System.in);
//		int[] a = new int[28];
//		int[] b = new int[30];
//		
//		for (int i = 0; i < b.length; i++) {
//			b[i] = i;
//		} 
//		
//		for (int i = 0; i < a.length; i++) {
//			a[i] = sc.nextInt();
//		}
//		boolean[] c = new boolean[b.length];
//		
//		for (int j = 0; j < b.length; j++) {
//			for (int i = 0; i < a.length; i++) {
//				if (b[j] == a[i]) {
//					c[j] = true;
//				}
//				else {
//					c[j] = false;
//				}
//			}
//				
//		}
//		
//		for(int j = 0; j < b.length; j++) {
//			if(c[j] == false) {
//				System.out.println(j);
//			}
//		}
		
		
			Scanner sc = new Scanner(System.in);
			
			int caseNum = sc.nextInt();
			String[] a = new String[caseNum];
						
			for (int i = 0; i < caseNum; i++) {
				a[i] = sc.next();
			}
			for (int i = 0; i < caseNum; i++) {
				System.out.print(a[i].charAt(0));
				System.out.print(a[i].charAt(a[i].length()-1));
				System.out.println();
			}
			
	        
		}

}
