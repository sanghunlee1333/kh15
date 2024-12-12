package oop.modifier1;

public class Test01접근제한 {

	public static void main(String[] args) {
		Student a = new Student();
		
		//Student의 필드가 잠겼으므로 필드를 직접 접근할 수 없다
		//-> 메소드를 이용해서 모든 작업을 처리할 수 밖에 없다
		
		//a.init("피카츄", 50); //가능
		a.setName("피카츄"); //가능
		//a.name = "피카츄"; //접근 불가
		
		a.show();
	}

}
