package loop4;

import java.util.Scanner;

public class Test02무한입력 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int num = 0;
		int count = 0;
		int total = 0;
		double average = 0;

		while (true) {
			num = sc.nextInt();
			if (num == 0) {
				break;
			}
			//0이 카운트되지 않도록 탈출조건 아래에 배치
			count++;
			total += num;
			
		}
		System.out.println("count = " + count);
		System.out.println("total = " + total);
		average = (double)total / count; //변환자를 안써주면 소수점이 날라감
		System.out.println("average = " + average);
	}

}
