import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int h1 = sc.nextInt();
		int m1 = sc.nextInt();
		
		int time1 = h1 * 60 + m1;
		int time2 = time1 - 45;
		int h2 = time2 / 60;
				
		if (time2 < 0) {
			time2 = 60 - time2;
		}
				
		System.out.print(h2 + " " + time2);
	}
}
