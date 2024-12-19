package api.time2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Test06날짜와시간제어 {

	public static void main(String[] args) {
		//LocalDateTime 클래스
		
		//인스턴스 생성
		LocalDateTime t1 = LocalDateTime.now();
		LocalDateTime t2 = LocalDateTime.of(2024,  12, 19, 14, 57, 30);
		LocalDateTime t3 = LocalDateTime.parse("2024-12-19T14:57:30");
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime t4 = LocalDateTime.parse("2024-12-19 14:57:30", fmt);
		
		System.out.println("t1 = " + t1);
		System.out.println("t2 = " + t2);
		System.out.println("t3 = " + t3);
		System.out.println("t4 = " + fmt.format(t4));
		
		//(Q) t1가 같은 해 1월 1일로 인스턴스를 생성하세요
		LocalDateTime t5 = LocalDateTime.of(t1.getYear(), 1, 1, t1.getHour(), t1.getMinute(), t1.getSecond());

		LocalDateTime t6 = t1.withMonth(1).withDayOfMonth(1);
		
		System.out.println("t5 = " + t5.format(fmt));
		System.out.println("t6 = " + t6.format(fmt));
	}

}
