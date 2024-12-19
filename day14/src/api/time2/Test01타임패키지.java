package api.time2;

import java.time.LocalDate;
import java.time.Period;

public class Test01타임패키지 {

	public static void main(String[] args) {
		// java.time 패키지
		// - Java 8에서 등장한 시간 관리 패키지
		// - 기존의 시간 관리 도구들의 문제점을 종합적으로 해결

		// 기존의 문제점(Calendar, Date)
		// 1. 월을 설정하기가 불편하다(0부터 11)
		// 2. 메소드의 용도 파악이 어렵다(옛날 방식의 Setter/Getter)
		// 3. 윤년이 처리는 되지만 알기가 어렵다
		// 4. (중요) 날짜가 가변이다(인스턴스의 날짜가 변한다)
		// 5. 시간 변경은 쉬운데 시간 차를 구하기 어렵다
		// 6. (중요) 날짜랑 시간이 항상 세트로 존재한다
		// 7. Date는 클래스명이 여러 개라 혼동이 쉽다

		// java.time패키지에서 등장하는 클래스
		// - LocalDate - 날짜만 저장하는 클래스
		// - LocalTime - 시간만 저장하는 클래스
		// - LocalDateTime - 날짜와 시간을 모두 저장하는 클래스
		// - ZoneDateTime - 시간대를 설정할 수 있는 클래스
		// - Period - 기간(연/월/일) 계산용
		// - Duration - 시간(시/분/초) 계산용
		// - DateTimeFormatter - 날짜 형식 제어 클래스
		
		LocalDate a = LocalDate.now(); //오늘 날짜
		LocalDate b = LocalDate.of(2025, 5, 20); //지정한 날짜
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		
		//a와 b의 차이 계산
		Period period = Period.between(a, b);
		//System.out.println("period = " + period);
		System.out.println(period.getYears());
		System.out.println(period.getMonths());
		System.out.println(period.getDays());
		
		//윤년인가?
		System.out.println(a.isLeapYear());
		System.out.println(b.isLeapYear());
		
		//불변인가?
		// - a의 100일 뒤 계산
		LocalDate after100 = a.plusDays(100L);
		System.out.println("a = " + a);
		System.out.println("after100 = " + after100);
	}

}
