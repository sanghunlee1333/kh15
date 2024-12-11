import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		for (int k = 0; k < a; k++) {
			for (int j = a; j > 0; j--) {
				for (int i = a-4; i < j; i++) {
					System.out.print(" ");
				}
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
