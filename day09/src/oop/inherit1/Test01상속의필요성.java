package oop.inherit1;

public class Test01상속의필요성 {

	public static void main(String[] args) {
	
		//Phone은 추상적 형태로 만들 필요가 없음!!
		//IPhone과 Galaxy는 구체적인 형태
		Galaxy p1 = new Galaxy();
		p1.call(); //상속받은 기능
		p1.sms(); //상속받은 기능
		p1.game(); //상속받은 기능
		p1.camera(); //상속받은 기능
		p1.internet(); //상속받은 기능
		p1.samsungPay(); //고유 기능
		
		IPhone p2 = new IPhone();
		p2.call(); //상속받은 기능
		p2.sms(); //상속받은 기능
		p2.game(); //상속받은 기능
		p2.camera(); //상속받은 기능
		p2.internet(); //상속받은 기능
		p2.applePay(); //고유 기능
	}

}
