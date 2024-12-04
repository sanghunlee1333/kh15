package data3;

import java.time.LocalDate;

public class Test06건강검진대상자 {

	public static void main(String[] args) {

		// 입력
		int birth = 1980;

		// 처리
		// int year = LocalDate.now().getYear();
		int year = 2024;
		int age = year - birth + 1;

		boolean over30 = age >= 30;
		boolean even = (birth % 2 == 0 && year % 2 == 0);
		boolean odd = (birth % 2 == 1 && year % 2 == 1);
		// boolean odd = (birth % 2 != 0 && year % 2 != 0);

		boolean healthCare = over30 && (even || odd);

		// 출력
		// System.out.println(age);
		// System.out.println(over30);
		// System.out.println(even);
		// System.out.println(odd);
		System.out.println(healthCare);

	}

}
