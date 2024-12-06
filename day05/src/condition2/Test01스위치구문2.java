package condition2;

public class Test01스위치구문2 {

	public static void main(String[] args) {
		// switch-case 구문
		// - 한 번의 검사로 시작 지점을 결정하는 구문
		// - if문의 유일한 단점을 보완할 수 있다

		int level = 5; // 학년

		switch (level) {// level을 살펴봐라!
		case 1 : // level이 1이라면 여기서부터 시작해라 (책갈피)
			System.out.println("병아리!");
			break; // 실행을 멈추고 밖으로 나가세요!
		case 2 :
			System.out.println("토끼!");
			break;
		case 3 :
			System.out.println("다람쥐!");
			break;
		case 4 : 
			System.out.println("사슴!");
			break;
		case 5 : 
			System.out.println("강아지!");
			break;
		//case 6 :
		default : //해당되는 case가 없다면 실행되는 지점 (else와 동일)
			System.out.println("호랑이!");
			//break; //마지막은 생략 가능. 어차피 끝나니까
		}

	}

}
