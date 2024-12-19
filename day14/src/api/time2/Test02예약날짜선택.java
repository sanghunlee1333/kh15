package api.time2;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class Test02예약날짜선택 {

	public static void main(String[] args) {

		/*
		try {
			Scanner sc = new Scanner(System.in);

			System.out.print("날짜를 입력하세요(YYYY-MM-DD) : ");
			String user = sc.next();

			int year = Integer.parseInt(user.substring(0, 4));
			int month = Integer.parseInt(user.substring(5, 7));
			int date = Integer.parseInt(user.substring(8, 10));

			LocalDate reserve = LocalDate.of(year, month, date);
			LocalDate today = LocalDate.now();
			Period period = Period.between(today, reserve);

			DayOfWeek dayOfWeek = today.getDayOfWeek();

			if (period.getYears() + period.getMonths() + period.getDays() == 0) {
				System.out.println("당일 예약은 불가능 합니다");
			} else if (period.getYears() + period.getMonths() + period.getDays() < 0) {
				System.out.println("지나간 날짜는 예약이 불가능합니다");
			} else if (today.getDayOfWeek().equals("SUNDAY") || today.getDayOfWeek().equals("SATURDAY")) {
				System.out.println("주말은 예약이 불가능합니다");
			} else {
				System.out.println(year + "년 " + month + "월 " + date + "일 예약이 확정되었습니다");
			}
		} catch (Exception e) {
			System.err.println("잘못된 날짜를 입력하셨습니다");
		}
		*/
		try {
			String input = "2024-12-24";
			LocalDate date = LocalDate.parse(input);
						
			LocalDate current = LocalDate.now();
			if(date.equals(current)) {
				throw new Exception("당일 예약은 불가능합니다");
			}
			if(date.isBefore(current)) {//date가 current보다 이전입니까?
				throw new Exception("지난 날짜는 예약이 불가능합니다");
			}
			if(date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY) {
				throw new Exception("주말 예약은 불가능합니다");
			}
				
			System.out.println("예약이 확정되었습니다");
			System.out.println("연도 : " + date.getYear());
			System.out.println("월 : " + date.getMonthValue());
			System.out.println("일 : " + date.getDayOfMonth());
		}
		catch (Exception e) {
			//e.printStackTrace(); //기본 형식
			System.err.println("오류 : " + e.getMessage());
		}
	}

}
