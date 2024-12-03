package data;

public class Test04커피자판기 {

	public static void main(String[] args) {
		//입력
		int ame = 2500;
		int mocha = 3000;
		int ameCount = 15;
		int mochaCount = 23;
		
		//처리
		int ameTotal = ame * ameCount;
		int mochaTotal = mocha * mochaCount;
		int total = ameTotal + mochaTotal;
		
		//출력
		System.out.println(total);
	}

}
