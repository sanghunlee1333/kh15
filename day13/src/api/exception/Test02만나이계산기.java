package api.exception;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Test02만나이계산기 {

	public static void main(String[] args) {
//
//		try {
//
//			Scanner sc = new Scanner(System.in);
//			System.out.print("생년월을 입력하세요(YYYY-MM) : ");
//			String user = sc.next();
//			if (user.length() != 7) { 
//				throw new Exception("입력 자리수가 맞지 않습니다");
//			}
//
//			int userYear = Integer.parseInt(user.substring(0, 4));
//			int userMonth = Integer.parseInt(user.substring(5, 7));
//
//			if (userYear < 1900) {
//				throw new Exception("연도는 1900미만일 수 없습니다.");
//			}
//
//			if (userMonth < 1 || userMonth > 12) {
//				throw new Exception("월은 01 미만 또는 12 초과일 수 없습니다");
//			}
//
//			int birth = userYear * 12 + userMonth;
//			int now = LocalDate.now().getYear() * 12 + LocalDate.now().getMonthValue();
//
//			if (birth > now) {
//				throw new Exception("생년월을 미래로 입력할 수 없습니다");
//			}
//
//			int gap = (now - birth) / 12;
//			System.out.println("만나이 : " + gap);
//		}
//
//		catch (Exception e) {
//			if (e.getMessage() == null) {
//				System.err.println("프로그램에서 오류가 발생했습니다");			
//			} else {
//				System.err.println("예외 : " + e.getMessage());
//			}
//		}

		// 플랜A
		try {
			Scanner sc = new Scanner(System.in);
			System.out.print("생년월일(YYYY-MM-DD) 입력 : ");
			String birth = sc.next();
			
//			//강제처리1 - 길이 검사
//			if(birth.length() != 7)
//				throw new Exception("올바른 글자수가 아닙니다");
			
			//강제처리2 - 정규표현식
			if(!birth.matches("^[0-9]{4}-[0-9]{2}-[0-9]{2}$"))
				throw new Exception("올바른 생년월일 형식이 아닙니다");

			int year = Integer.parseInt(birth.substring(0, 4));
			//강제처리3 - 연도가 1900미만인 경우를 차단
			if(year < 1900)
				throw new Exception("1900미만은 연도로 설정할 수 없습니다");
			
			int month = Integer.parseInt(birth.substring(5, 7));
			//int month = Integer.parseInt(birth.substring(5)); //일 까지 계산하는 경우 끝까지 자르면 안된다
			if(month < 1 || month > 12) 
				throw new Exception("월은 1에서 12로만 작성 가능합니다");
			int date = Integer.parseInt(birth.substring(8, 10));
			int maxDate = getMaxDate(year, month); //연,월에 따른 날짜수 계산
			if(date < 1 || date > maxDate)
				throw new Exception("일이 올바르지 않습니다");

			int total = getTotalDate(year, month, date);
			int current = getTotalDate(2024, 12, 18);
			//강제처리4 - 미래의 날짜를 입력한 경우
			if(current < total)
				throw new Exception("미래의 날짜는 입력할 수 없습니다");			
			
			// int diff = current - total;
			int diff = Math.abs(total - current);

			int age = diff / 365;
			System.out.println("만나이 = " + age);

		}

		catch (Exception e) {//플랜B
			if(e.getMessage() == null) {
				System.out.println("프로그램 실행 중 오류가 발생했습니다");
			}
			else System.out.println("오류 - " + e.getMessage());

		}

	}
	
	//일회용 메소드 - 따로 클래스 안만들고 여기에 만들어도 됨
	public static int getMaxDate(int year, int month) {
		
		boolean leap = year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
		
		switch(month) {
		case 1, 3, 5, 7, 8, 10, 12: return 31; //이 return은 스위치문에서 나온 return이 아님. 나올 수 없음
		case 4, 6, 9, 11: return 30; //getMaxDate의 return임(메소드 종료 구문)
		default: 
			if(leap) return 29;
			else return 28;
		}
	}
	//연+월+일을 모두 일로 바꿔서 반환하는 기능
	public static int getTotalDate(int year, int month, int date) {
		int total = 0;
		total += (year - 1) * 365; //작년까지를 먼저 일로 바꿈 *올해로 하면 안됨
		switch(month - 1) {//전달까지만 합산 *for문으로 3줄로 작성 가능
		case 12: total += getMaxDate(year, 12); //break문이 case별로 없으므로 if문과 달리 각 케이스 단계에서 아래 단계까지 쭉 이어서 실행됨! 
		case 11: total += getMaxDate(year, 11);
		case 10: total += getMaxDate(year, 10);
		case 9: total += getMaxDate(year, 9);
		case 8: total += getMaxDate(year, 8);
		case 7: total += getMaxDate(year, 7);
		case 6: total += getMaxDate(year, 6);
		case 5: total += getMaxDate(year, 5);
		case 4: total += getMaxDate(year, 4);
		case 3: total += getMaxDate(year, 3);
		case 2: total += getMaxDate(year, 2);
		case 1: total += getMaxDate(year, 1);
		}
		total += date - 1; //이번달 일 합산
		return total;
		
	}

}
