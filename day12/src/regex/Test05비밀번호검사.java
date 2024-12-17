package regex;

public class Test05비밀번호검사 {

	public static void main(String[] args) {
		//비밀번호 형식 검사
		//- 긍정 탐색 : (?=.*?[나올글자목록]) 을 시작 부분에 작성. 반드시 포함
		//- 부정 탐색 : (?!.*?[안나올글자목록]) 을 시작 부분에 작성. 반드시 제외
				
		String password = "Testuser1!";
		
		String regex = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[!@#$])[A-Za-z0-9!@#$]{8,16}$";
		
		System.out.println(password.matches(regex));
		
	}

}
