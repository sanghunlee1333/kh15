package api.time;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test03캘린더2 {

	public static void main(String[] args) {
		//Calendar 인스턴스 생성
		Calendar c = Calendar.getInstance(); //ctrl을 누른채 클래스 누르면 설명 볼 수 있음!
		
		//날짜 정보를 변경
		//- 연도를 2005로 바꾸고 싶어요
		//c.setYear(2005); //우리가 배운 설정 코드
		//c.set(1, 2005); //자바 1.1당시의 설정 코드
		c.set(Calendar.YEAR, 2005);
		
		//- 월을 4월로 바꾸고 싶어요
		c.set(Calendar.MONTH, 3);
		//- 일을 10일로 바꾸고 싶어요
		//c.set(Calendar.DATE, 10);
		c.set(Calendar.DAY_OF_MONTH, 10); //위와 같은 표현 *synonym 동의어
		
		//연도만 추출하여 출력
		//int year = c.getYear(); //우리가 알고 있는 코드
		int year = c.get(Calendar.YEAR);
		System.out.println("연도 : " + year);
		//월을 추출하여 출력
		int month = c.get(Calendar.MONTH) + 1;
		System.out.println("월 : " + month);
		
		//계산
		c.add(Calendar.DATE, 100); //100일 뒤
		
		//Date로 변환
		Date d = c.getTime();
		Format f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(f.format(d));
		
	}

}
