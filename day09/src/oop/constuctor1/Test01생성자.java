package oop.constuctor1;

public class Test01생성자 {

	public static void main(String[] args) {
		
		//Car a = new Car(); //생성
		//a.init("소나타", "블랙", 20000000, 200); //초기화
		
		Car a = new Car("소나타", "블랙", 20000000, 200); //생성과 초기화를 동시에
		a.show();
	}

}
