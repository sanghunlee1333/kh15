package data3;

import java.time.LocalDate;

public class Test03만나이계산기2 {

	public static void main(String[] args) {
		
		//입력
		int y = 2016, m = 3;
				
		//처리
		int t = y * 12 + m;
		int now = LocalDate.now().getYear() * 12 + LocalDate.now().getMonthValue();
		
		int gap = now - t;
		
		int age = gap / 12;
		boolean vote = age >= 18;
		
		//출력
		System.out.println(age);
		System.out.println(vote);
		
		
	}

}
