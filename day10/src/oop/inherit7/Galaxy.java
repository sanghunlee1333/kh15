package oop.inherit7;

public abstract class Galaxy extends Phone { //상속받은 추상 클래스에서 빨간줄 뜨는 것은 추상 메소드 생성 때문이 아니라,
											//상위 클래서에서 생성자를 만들고, 여기 클래스에서 생성자를 생성 안해서임!!

	public abstract void samsungPay(); //삼성페이도 삼성 폰마다 기능이 다를 것. 나중에 구현

	public Galaxy(String number, String color) {

		super(number, color);

	}

}
