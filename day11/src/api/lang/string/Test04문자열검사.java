package api.lang.string;

public class Test04문자열검사 {

	public static void main(String[] args) {
		//문자열의 검사 명령들
		//- 정확하게 같지 않아도 유사한 경우를 검사
		
		String url = "https://www.naver.com";
		
		System.out.print("홈페이지 주소인가요? ");
		System.out.println(url.startsWith("https://"));
		
		System.out.print("기업  홈페이지 주소인가요? ");
		System.out.println(url.endsWith(".com"));
		
		System.out.print("네이버가 포함된 주소인가요? ");
		System.out.println(url.contains("naver"));
		
		System.out.println("네이버가 어디 포함되어 있어요? ");
		System.out.println(url.indexOf(".")); //왼쪽에서 첫 번째
		//System.out.println(url.indexOf("naber")); //-1 -> 없다는 말
		System.out.println(url.lastIndexOf(".")); //오른쪽에서 첫 번째
		
		System.out.print("글자수는 몇 글자인가요? ");
		System.out.println(url.length()); //(주의) 배열의 length와 다름
		
		System.out.print("첫 번째 글자는 무엇인가요? ");
		System.out.println(url.charAt(0)); //+0 지점 글자
		
		//(Q) 마지막 글자가 무엇인지 출력해보세요
		System.out.print("마지막 글자는 무엇인가요? ");
		System.out.println(url.charAt(url.length()-1)); //확장성 있는 코드
	
		//(Q) 첫 번째 글자가 소문자인지 판정해보세요
		System.out.print("첫 번재 글자가 소문자인지 판정해보세요 ");
		char first = url.charAt(0);
		boolean lower = first >= 'a' && first <= 'z'; //가 ~ 힣, a - z, A - Z
		System.out.println(lower);
		
	}

}
