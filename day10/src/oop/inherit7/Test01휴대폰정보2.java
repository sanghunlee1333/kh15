package oop.inherit7;

public class Test01휴대폰정보2 {

	public static void main(String[] args) {
		
//		Galaxy24s a = new Galaxy24s("01072577271", "블랙");
//		GalaxyFold6 b = new GalaxyFold6("01036787272", "네이비");
//		IPhone15 c = new IPhone15("01012345678", "레드");
//		IPhone16 d = new IPhone16("01087654321", "화이트");
		
		// 이렇게 해도 에러는 안나지만, 각 기종의 고유 기능을 못쓴다.
		Galaxy a = new Galaxy24s("01072577271", "블랙");
		Galaxy b = new GalaxyFold6("01036787272", "네이비");
		IPhone c = new IPhone15("01012345678", "레드");
		IPhone d = new IPhone16("01087654321", "화이트");
		
		
		
		
		a.show();
		a.call();
		a.sms();
		a.samsungPay();
		//a.bixby(); 
		
		b.show();
		b.call();
		b.sms();
		b.samsungPay();
		//b.iris();
		
		c.show();
		c.call();
		c.sms();
		c.siri();
		//c.itunes();
		
		d.show();
		d.call();
		d.sms();
		d.siri();
		//d.facetime();
		
	}

}
