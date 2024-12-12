import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int[] a = new int[9];
		
		int max = 0;
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		for (int i = 1; i < a.length; i++) {
			if(a[i] > a[max]) {
				max = i;
			}
		} 

		
		System.out.println(a[max]);
		System.out.println(max+1);

	}

}
