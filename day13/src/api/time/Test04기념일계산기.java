package api.time;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Test04기념일계산기 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Calendar c = Calendar.getInstance();

		System.out.print("연도 입력 : ");
		int year = sc.nextInt();
		c.set(Calendar.YEAR, year);

		System.out.print("월 입력 : ");
		int month = sc.nextInt() - 1;
		c.set(Calendar.MONTH, month);

		System.out.print("일 입력 : ");
		int date = sc.nextInt();
		c.set(Calendar.DATE, date);

		for (int i = 1; i <= 730; i++) {
			if (i % 365 == 0) {
				System.out.println(i / 365 + "주년 - " + (year + (i / 365)) + "년 " + (month + 1) + "월 " + date + "일");
			} else if (i % 100 == 0 && i % 365 != 0) {
				c.add(Calendar.DATE, 100);
				Date d = c.getTime();
				Format f = new SimpleDateFormat(i + "일 - y년 M월 d일");
				System.out.println(f.format(d));
			}

		}

	}

}
