package oop.multi2;

public class Train extends Transportation implements Reserve {
	
	@Override
	public void move() {
		System.out.println("기차가 이동합니다");
		
	}

	@Override
	public void reservation() {
		System.out.println("기차를 예약합니다");		
	}
}
