package regex;

public class Test04생년월일검사 {

	public static void main(String[] args) {
		
		String birth = "2000-11-30";
		
		String regex = "^(19[0-9]{2}|20[0-9]{2})-(((0[13578]|1[02])-(0[1-9]|1[0-9]|2[0-9]|3[01]))|((0[469]|11)-(0[1-9]|1[0-9]|2[0-9]|30))|(02-(0[1-9]|1[0-9]|2[0-8])))$";
		
		if(birth.matches(regex)) {
			System.out.println("올바른 날짜");
		}
		else {
			System.out.println("잘못된 날짜");
		}
		
		
	}

}
