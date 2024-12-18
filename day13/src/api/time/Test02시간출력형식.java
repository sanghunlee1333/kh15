package api.time;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test02시간출력형식 {

	public static void main(String[] args) {
				
		while(true) {
			
			Date d = new Date(); //시간을 생성
			
			//2024년 12월 18일 오후 4시 11분 13초
			//SimpleDateFormat fmt1 = new SimpleDateFormat("y년 M월 d일 a h시 m분 s초"); //시간 표시 형식
			Format fmt1 = new SimpleDateFormat("y년 M월 d일 a h시 m분 s초");
			System.out.println(fmt1.format(d));
			
			//2024-12-18 수 16:11:13
			//SimpleDateFormat fmt2 = new SimpleDateFormat("yyyy-MM-dd E H:mm:ss");
			Format fmt2 = new SimpleDateFormat("yyyy-MM-dd E H:mm:ss");
			System.out.println(fmt2.format(d));
			
			
		}
	}

}
