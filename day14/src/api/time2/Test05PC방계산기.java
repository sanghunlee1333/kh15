package api.time2;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Test05PC방계산기 {

	public static void main(String[] args) {
		
		String in = "13:00";
		String out = "12:00";
		
		LocalTime inTime = LocalTime.parse(in);
		LocalTime outTime = LocalTime.parse(out);
		
		if(inTime.isBefore(outTime)) {//당일요금계산
			//이용시간 계산
			Duration duration = Duration.between(inTime, outTime);
			//System.out.println("duration = " + duration);
			int hour = duration.toHoursPart();
			int minute = duration.toMinutesPart();

			//이용시간 출력
			System.out.println("이용시간 : " + hour + "시간 " + minute + "분");
			
			//이용요금 계산
			int pricePerHour = 1000;
			double pricePerMinute = pricePerHour / 60d;
			
			long totalMinute = duration.toMinutes();
			//long totalPrice = (long) (totalMinute * pricePerMinute);
			long totalPrice = Math.round(totalMinute * pricePerMinute);
			System.out.println("총 "+totalMinute+"분에 대한 요금은 "+totalPrice+"원입니다");
		}
		else {//1박요금계산
			LocalDate now = LocalDate.now();
			LocalDateTime begin = LocalDateTime.of(now.minusDays(1), inTime);
			LocalDateTime end = LocalDateTime.of(now, outTime);
			
			Duration duration = Duration.between(begin, end);
			//System.out.println("duration = " + duration);
			int hour = duration.toHoursPart();
			int minute = duration.toMinutesPart();

			//이용시간 출력
			System.out.println("이용시간 : " + hour + "시간 " + minute + "분");
			
			//이용요금 계산
			int pricePerHour = 1000;
			double pricePerMinute = pricePerHour / 60d;
			
			long totalMinute = duration.toMinutes();
			//long totalPrice = (long) (totalMinute * pricePerMinute);
			long totalPrice = Math.round(totalMinute * pricePerMinute);
			System.out.println("총 "+totalMinute+"분에 대한 요금은 "+totalPrice+"원입니다");
		}
		
	}

}
