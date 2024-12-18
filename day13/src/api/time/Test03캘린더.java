package api.time;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test03캘린더 {

	public static void main(String[] args) {
		//java.util.Calendar 클래스
		//- 연도를 4자리로 설정
		//- 시간 계산, 설정과 관련된 기능들을 추가
		//- Date와도 호환이 가능(상호 변환이 쉬움)
		//- 달력의 종류를 지정할 수 있도록 구현
		//- (아쉬운 점) 월은 여전히 0부터 11까지이다 (보정이 필요)
		
		//Calendar c = new GregorianCalendar(); //업캐스팅(비추천)
		Calendar c = Calendar.getInstance(); //생성명령(추천)
		System.out.println(c);
		
		//Date로 변환
		Date d = c.getTime();
		Format f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(f.format(d));
		
	}

}
