package data4;

public class Test01문자 {

	public static void main(String[] args) {
		// 문자
		// - 문자도 숫자이다
		// - ASCII 코드 - 미국인이 쓸 수 있는 128글자에 번호를 붙인 것
		// - 확장ASCII 코드 - 유럽인이 쓸 수 있는 16세트의 글자체계(128+128글자)
		// - 서유럽(ISO-8859-1)이 표준으로 사용
		// - 전세계에서 각자 자기네 글자들을 자체적으로 추가하여 사용(난장판)
		// - 마이크로소프트에서 윈도우를 전세계 버전으로 제작하며 각국의 글자를 정비
		// - 한국에서는 KSC-5601이라는 체계가 널리 쓰였음
		// - 이걸 활용해서 MS949라는 글자체계를 만듦
		// - 비슷한 시기에 유니코드 컨소시엄이라는 재단에서 전세계 글자 취합
		// - 총 65,536글자로 추려서 일일이 번호를 부여 (유니코드, Unicode)
		// - 전세계적으로 대표적인 표현방식의 이름이 UTF-8
		// (결론) 우리는 앞으로 UTF-8만 사용

		char a = 65;
		System.out.println(a);

		char b = 'A';
		System.out.println(b);

		char c = '가';
		System.out.println((int) c);

		char d = '힣';

		System.out.println((int) d);
		System.out.println(55203 - 44032 + 1);

		// char e = 'hello'; // 여러 글자 사용 불가
		
		char e = 'H';
		//(Q) e가 영어 대문자인지 판정하도록 코드구현
		
		boolean upper = (e >= 'A') && (e <= 'Z');
		System.out.println(upper);
	}

}
