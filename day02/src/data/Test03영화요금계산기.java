package data;

public class Test03영화요금계산기 {

	public static void main(String[] args) {
		//준비
		int adultPrice = 15000;
		int teenPrice = 10000;
		int adultCount = 2;
		int teenCount = 3;
		
		//계산(처리/연산)
		int adultTotal = adultPrice * adultCount; //성인 합계
		int teenTotal = teenPrice * teenCount; //청소년 합계
		int total = adultTotal + teenTotal; //전체합계
		
		//표시(출력)
		System.out.println(total);
	}

}
