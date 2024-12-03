package data;

public class Test02정수 {
	public static void main(String[] args) {
		//정수 
		//- 소수점이 없는 수(byte/short/int/long)
		//- 아무 표시가 없으면 int로 판단
		//- 각 형태마다 표시할 수 있는 크기가 다름
		
		int a = 1000;
		int b = 2000;
		int c = a + b;
		System.out.println(c);
		
		//(Q)자장면 한 그릇 6천원일 때 5그릇은 얼마에요?
		int menu= 6000;
		int count = 5;
		int price = menu * count;
		System.out.println(price);
	}
}
