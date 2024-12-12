package oop.inherit2;

public class Test01브라우저구현 {

	public static void main(String[] args) {
		Chrome c1 = new Chrome();
		Edge e1 = new Edge();
		Whale w1 = new Whale();
		
		c1.setUrl("www.google.com");
		c1.refresh();
		c1.move(); //c1이라는 리모컨이 Chrome 인스턴스(this)에 move()라는 메소드가 있는지 확인하고, 없으면 Browser(슈퍼)에 있는지 확인하는 순서!
		c1.develop();
		c1.chromeStore();
				
		e1.setUrl("www.microsoft.com");
		e1.refresh();
		e1.move();
		e1.fullScreen();
		
		w1.setUrl("www.naver.com");
		w1.refresh();
		w1.move();
		w1.papago();
		w1.naverSearch();
	}

}
