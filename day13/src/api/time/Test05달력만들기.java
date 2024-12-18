package api.time;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Test05달력만들기 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Calendar c = Calendar.getInstance();
		
//		System.out.print("연도 : ");
//		int year = sc.nextInt();
//		c.set(Calendar.YEAR, year);
//		
//		System.out.print("월 : ");
//		int month = sc.nextInt();		
//		c.set(Calendar.MONTH, month);
				
		c.set(Calendar.DAY_OF_WEEK, 1);
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		
		Format f = new SimpleDateFormat("EEE");
		System.out.println(f.format(dayOfWeek));
		
	
		
		
		
		
	}

}
