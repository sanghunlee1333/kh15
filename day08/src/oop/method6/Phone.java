package oop.method6;

public class Phone {
	
	//멤버 필드
	String name;
	String agency;
	int price;
	int contract;
	
	void setName(String name) {
		this.name = name;
	}
	
	void setAgency(String agency) {
		//방법1
		if (agency != "SK" && agency != "KT" && agency != "LG" && agency != "알뜰폰") return;
		this.agency = agency;
		
		//방법2
//		switch(agency) { //switch-case는 본체를 비교한다! 문자는 참조형이어서 a==b로 하면 리모컨끼리 비교하는 것이 되어서 안되는데, 
						// 그래서 방법 1은 그다지 적절하진 않다. *equals()로 문자열 비교 가능!
//						//switch는 리모컨이 아닌 리모컨이 가리킨 곳을 비교할 수 있다는 뜻!
//		case "SK" :
//		case "LG" :
//		case "KT" :
//		case "알뜰폰" :
//			this.agency = agency;
//		}
	}
	
	void setPrice(int price) {
		if(price < 0) return;
		this.price = price;
	}
	
	void setContract(int contract) {
		// 방법 1
		if (contract != 0 && contract != 24 && contract != 30 && contract != 36) return;
		this.contract = contract;
		
		//방법2
//		switch(contract) {
//		case 0:
//		case 24:
//		case 30:
//		case 36:
//			this.contract = contract;

		//방법3
//		case 0, 24, 30, 36: //회사에서는 8,11버전을 쓰기 때문에 해당 문법은 안될 가능성 높음
//			this.contract = contract;
//		}
	}
	
	String getName() {
		return this.name;
	}
	
	String getAgency() {
		return this.agency;
	}
	
	int getPrice() {
		return this.price;
	}
	
	int getContract() {
		return this.contract;
	}
	
	int getDivision() {
		return this.price / this.contract;
	}
	
	void init(String name, String agency, int price) {
		this.init(name, agency, price, 0);
	}
	
	void init(String name, String agency, int price, int contract) {
		this.setName(name);
		this.setAgency(agency);
		this.setPrice(price);
		this.setContract(contract);
	}
	boolean isContract() {
		return this.contract > 0;
	}
	
	void show() {
		System.out.println("<휴대폰 정보>");
		System.out.println("이름 : " + getName());
		System.out.println("통신사 : " + getAgency());
		System.out.println("가격 : " + getPrice());
//		if (this.contract == 0) {
//			System.out.println("약정이 잡혀있지 않습니다.");
//		}
		if(!this.isContract()) {
			System.out.println("약정이 잡혀있지 않습니다.");
		}
		else System.out.println("약정개월 : " + getContract() + ", 월 분납금은" + getDivision() + "입니다.");
	}
}

	