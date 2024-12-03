package data;

public class Test06시간계산기2 {

	public static void main(String[] args) {
		/*
		int time1 = 110;
		int time2 = 165;
		
		int hour1 = time1/60 ;
		int minute1 = time1%60;
		int hour2 = time2/60;
		int minute2 = time2%60;
		
		int totalHour = hour1 + hour2;
		int totalMinute = minute1 + minute2;
		
		if(totalMinute >= 60) {
			totalHour = totalHoute + totalMinute/60;
			totalMinute = totalMinute%60;
		}
		
		System.out.println(totalHour + "시간" + " " + totalMinute + "분");
		*/
		
		//입력
		int h1 = 1, m1 = 50;
		int h2 = 2, m2 = 45;
		
		//처리
		int h3 = h1 + h2;
		int m3 = m1 + m2;
		
		int h4 = h3 + m3/60;
		int m4 = m3 % 60;
		
		//출력
		System.out.println(h4);
		System.out.println(m4);
	}

}
