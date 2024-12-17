package regex;

public class Test04생년월일검사2 {

	public static void main(String[] args) {
		
		String birth = "2000-02-29";
		
		// 윤년 여부를 검사 -> 2월을 28일 or 29일로 구현
		String yearValue = birth.substring(0, 4);
		int year = Integer.parseInt(yearValue); // 문자열을 가능하다면 int로 변환

		boolean leap = year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
		String regex;
		if(leap) { // 윤년
			regex = "^(19[0-9]{2}|20[0-9]{2})-(((0[13578]|1[02])-(0[1-9]|1[0-9]|2[0-9]|3[01]))|((0[469]|11)-(0[1-9]|1[0-9]|2[0-9]|30))|(02-(0[1-9]|1[0-9]|2[0-9])))$";
		}
		else { // 평년
			regex = "^(19[0-9]{2}|20[0-9]{2})-(((0[13578]|1[02])-(0[1-9]|1[0-9]|2[0-9]|3[01]))|((0[469]|11)-(0[1-9]|1[0-9]|2[0-9]|30))|(02-(0[1-9]|1[0-9]|2[0-8])))$";
		}
		
		if(birth.matches(regex)) {
			System.out.println("올바른 날짜");
		}
		else {
			System.out.println("잘못된 날짜");
		}
		
		
	}

}
