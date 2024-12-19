package api.time;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Test05달력만들기 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int year = sc.nextInt();
		int month = sc.nextInt();
		
		//구해야하는 정보
		//- 주어진 달의 1일이 무슨 요일인가
		//- 1일에서 몇일 전으로 이동해야 하는가
				
		Calendar c = Calendar.getInstance();
		c.set(year, month - 1, 1); //해당 달의 시작일로 달력 설정
		int week = c.get(Calendar.DAY_OF_WEEK);
		
		c.add(Calendar.DATE, -week + 1 ); //달력의 시작지점(일요일)으로 이동
		
		//출력
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		for(int i = 0; i < 42; i++) {
			System.out.print(c.get(Calendar.DATE)); //날짜 출력
			System.out.print("\t");
			
			c.add(Calendar.DATE, 1); //하루 뒤로 이동
			
			if(i % 7 == 6) {
				System.out.println();
			}
		}
		

		
	
		
		
		
		
	}

}
