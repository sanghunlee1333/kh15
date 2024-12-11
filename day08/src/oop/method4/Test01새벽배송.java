package oop.method4;

public class Test01새벽배송 {

	public static void main(String[] args) {
		Product p1 = new Product();
		Product p2 = new Product();
		Product p3 = new Product();
		Product p4 = new Product();
		
		p1.init("비김면", "라면", 16800, 2, 0, true);
		//p2.init("크림대빵", "제과", 6500, 2, 0, false);
		p2.init("크림대빵", "제과", 6500, 2);
		p3.init("점보도시락", "라면", 8500, 3, 5, true);
		//p4.init("공간춘", "라면", 12300, 3, 20, false);
		p4.init("공간춘", "라면", 12300, 3, 20);
		
		p1.show();
		p2.show();
		p3.show();
		p4.show();
		
	}

}
