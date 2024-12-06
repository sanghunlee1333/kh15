package condition2;

public class Test01스위치구문 {

	public static void main(String[] args) {
		//if구문의 단점
		//- 검사를 순서대로 한다는 것
		
		int level = 1; //학년
		
		if(level == 1) {//1학년
			System.out.println("병아리!");
		}
		else if(level == 2) {//2학년
			System.out.println("토끼!");		
		}
		else if(level == 3) {//3학년
			System.out.println("다람쥐!");
		}
		else if(level == 4) {//4학년
			System.out.println("사슴!");
		}
		else if(level == 5) {//5학년
			System.out.println("강아지!"); //5학년 이라면 5번 검사
		}
		else {//6학년
			System.out.println("호랑이!"); //6학년도 5번 검사
		}
	}

}
