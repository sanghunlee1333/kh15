package data;

public class Test06시간계산기 {

	public static void main(String[] args) {
		int time1 = 110;
		int time2 = 165;
		
		int hour1 = time1/60 ;
		int minute1 = time1%60;
		int hour2 = time2/60;
		int minute2 = time2%60;
		
		int totalHour = hour1 + hour2;
		int totalMinute = minute1 + minute2;
		
		if(totalMinute >= 60) {
			totalHour++;
			totalMinute = totalMinute%60;
		}
		
		System.out.println(totalHour +"시간" + " " + totalMinute + "분");
	}

}
