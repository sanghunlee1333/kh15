package oop.method6;

public class Phone {
	
	String name;
	String agency;
	int price;
	int contract;
	
	void setName(String name) {
		this.name = name;
	}
	
	void setAgency(String agency) {
		if (agency != "SK" && agency != "KT" && agency != "LG" && agency != "알뜰폰") return;
		this.agency = agency;
	}
	
	void setPrice(int price) {
		if(price < 0) return;
		this.price = price;
	}
	
	void setContract(int contract) {
		if (contract != 0 && contract != 24 && contract != 30 && contract != 36) return;
		this.contract = contract;
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
		return this.getPrice() / this.getContract();
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
	
	void show() {
		System.out.println("이름 : " + getName());
		System.out.println("통신사 : " + getAgency());
		System.out.println("가격 : " + getPrice());
		if (getContract() == 0) {
			System.out.println("약정이 잡혀있지 않습니다.");
		}
		else System.out.println("약정개월 : " + getContract() + ", 월 분납금은" + getDivision() + "입니다.");
	}
}

	