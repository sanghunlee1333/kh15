package oop.method6;

public class Test01폰분납금정보 {

	public static void main(String[] args) {
		Phone p1 = new Phone();
		Phone p2 = new Phone();
		Phone p3 = new Phone();
		Phone p4 = new Phone();
				
		p1.init("갤럭시Fold6", "SK", 2200000);
		p2.init("갤럭시Fold6", "KT", 2150000, 24);
		p3.init("아이폰16", "LG", 2100000, 36);
		p4.init("아이폰16", "SK", 2150000);
		
		//setter메소드는 만들었다고 꼭 써야하는 것은 아님. 앞으로 설정할 데이터의 필터링을 하기 위해 만든 것.
		//p1.price = 30000; //이렇게 쓰면 직접 접근으로 무조건 변경되니, setter메소드에서 필터링을 만들어서 안전하게 접근하는것!
//		p1.setName("갤럭시Fold6");
//		p1.setAgency("SK");
//		p1.setPrice(2200000);
//		p1.setContract(0);
//
//		p2.setName("갤럭시Fold6");
//		p2.setAgency("KT");
//		p2.setPrice(2150000);
//		p2.setContract(24);
//		
//		p3.setName("아이폰16");
//		p3.setAgency("LG");
//		p3.setPrice(2100000);
//		p3.setContract(36);
//		
//		p4.setName("아이폰16");
//		p4.setAgency("SK");
//		p4.setPrice(2150000);
//		p4.setContract(0);
	
		p1.show();
		p2.show();
		p3.show();
		p4.show();
		
	}

}
