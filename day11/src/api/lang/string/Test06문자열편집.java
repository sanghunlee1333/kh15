package api.lang.string;

public class Test06문자열편집 {

	public static void main(String[] args) {
		//문자열 편집은 주어진 문자열을 다른 형태로 변형하는 것
		//(ex) 대소문자 변환, 마스킹 처리
		
		//(중요) 문자열은 불변 데이터이기 때문에 편집하면 새로운 문자열이 생성됨. 저장되는 것은 아니어서 새로운 변수에 저장해야됨
		
		String a = "Hello1234";
		String b = a.toUpperCase();
		System.out.println("a = " + a); //원본
		System.out.println("b = " + b); //사본
		
		System.out.println("소문자 = " + a.toLowerCase());
		
		String c = "       사과 한 개만 주세요!       ";
		System.out.println("trim = " + c.trim()); //사본 //문자열 양끝 띄어쓰기 제거 메소드
		
		String d = "\u2003사과 한 개만 주세요!\u2003"; 
		System.out.println("원본 = " + d); 
		System.out.println("trim = " + d.trim()); //아스키코드 여백만 제거
		System.out.println("strip = " + d.strip()); //유니코드 여백까지 모두 제거
		
		String e = "저는 자바가 싫어요";
		System.out.println("replace = " + e.replace("싫어", "좋아")); //문자열 대체
		
		String f = "https://www.naver.com"; 
		System.out.println("substring = " + f.substring(12, 17)); //문자열 잘라내기
		System.out.println("substring = " + f.substring(8)); //시작점 8부터 끝까지 잘라내기
		
	}

}
