package api.time;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Test04기념일계산기 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		
	
		

		System.out.print("연도 입력 : ");
		int year = sc.nextInt();
		//c.set(Calendar.YEAR, year); 

		System.out.print("월 입력 : ");
		int month = sc.nextInt() - 1;
		//c.set(Calendar.MONTH, month);

		System.out.print("일 입력 : ");
		int date = sc.nextInt();
		//c.set(Calendar.DATE, date); 
		
		//기념일 계산 및 출력
		//- 2주년까지
		int limit = 2;
		int count = 0;
		for (int i = 1; i <= 365 * limit; i++) {
			if (i % 100 == 0 || i % 365 == 0){
				count++;
			}
		}
		//System.out.println("count = " + count);
		int[] anniversaryList = new int[count];
		count = 0;
		for (int i = 1; i<= 365 * limit; i++) {
			if(i % 100 == 0 || i % 365 == 0) {
				anniversaryList[count] = i;
				count++;
			}
		}
				
		Calendar c = Calendar.getInstance();
		c.set(year, month - 1, date);
		
		printDate(c);

		for (int i = 0; i < anniversaryList.length; i++) {
				c.set(year, month - 1, date);
				c.add(Calendar.DATE, anniversaryList[i]); //add를 원래 기준에서 set하고 다시 설정. Calendar가 가변이라..
				if(anniversaryList[i] % 365 == 0) {
					System.out.print("+" + anniversaryList[i]/365 + "주년 ");
				}
				else {
					System.out.print("+" + anniversaryList[i] + "일 ");
				}
				printDate(c);
				

		}

	}
	
	public static void printDate(Calendar c) {
		Date d = c.getTime();
		Format f = new SimpleDateFormat("y년 M월 d일 E요일");
		System.out.println(f.format(d));
	}

}
