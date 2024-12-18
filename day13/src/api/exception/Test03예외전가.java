package api.exception;

public class Test03예외전가 {
	
	//윤년 계산하는 메소드
	public static boolean isLeapYear(int year) {
		//return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
		if(year % 400 == 0) return true;
		if(year % 100 == 0) return false;
		if(year % 4 == 0) return true;
		return false;
	}
	
	//월별 날짜수를 구해주는 메소드
	public static int getMaxDate(int year, int month) throws Exception { //예외 전가(나는 에러가 날 수 있는 메소드야)
		switch(month) {
		case 2: return isLeapYear(year) ? 29 : 28; //아래와 동일한 코드 - 왼쪽은 3항 연산자 -> ? 왼쪽에 조건이 true면 : 왼쪽 반환, false면 오른쪽 반환
		case 4, 6, 9, 11: return 30;			   //if(isLeapYear()) return 29;
		case 1, 3, 5, 7, 8, 10, 12: return 31;     //else return 28;
		default: throw new Exception("월은 1~12만 가능합니다");	  
		}
	}

	public static void main(String[] args) {
		try { //예외는 부른 사람(main)이 처리해야됨
			int year = 2000, month = 2;
			int day = getMaxDate(year, month);
			System.out.println("날짜수 = " + day);
		}
		catch(Exception e) {
			System.err.println("오류 발생 - " + e.getMessage());
		}
	}

}
