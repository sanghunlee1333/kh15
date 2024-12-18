package api.lang.etc;

public class Test04래퍼클래스 { //기본 자료타입을 객체로 다루기 위해서 사용하는 클래스

	public static void main(String[] args) {
		// 인스턴스 생성 -> 3개 생성
		Integer a = new Integer(10); // 비추천
		Integer b = new Integer("10"); // 비추천
		Integer c = Integer.valueOf(10); // 추천 -> 재사용
		Integer d = Integer.valueOf("10"); // 추천
		Integer e = 10; // ???

		System.out.println(a == b); // false
		System.out.println(b == c); // false
		System.out.println(c == d); // true
		System.out.println(d == e); // true

		System.out.println(a.equals(b)); // true

		System.out.println("--------");
		// int가 있는데 왜 Integer를 써야되는가?
		// - 상황에 따라 Integer가 좋은 경우도 있으니까..

		// [1] Int가 더 좋은 상황 -> 10 + 20 = ?
		int n1 = 10;
		int n2 = 20;
		int n3 = n1 + n2;
		System.out.println("n3 = " + n3);

		// 아래는 별로 안 좋은 상황 -> 간단한 풀이 마저도 인스턴스를 생성해야 하니
		Integer m1 = Integer.valueOf(10); // static 메소드를 이용해서 인스턴스 생성
		Integer m2 = Integer.valueOf(20);
		Integer m3 = Integer.sum(m1, m2); // static 메소드로 더하기
		System.out.println("m3 = " + m3.toString()); // 문자열로 변경

		// [2] Integer가 더 좋은 상황 - 100을 2진수로 바꿔서 출력 (01100100)
		int value = 100;
		StringBuilder builder = new StringBuilder();
		for (int i = value; i > 0; i /= 2) {
			//System.out.println(i % 2);
			builder.insert(0, i % 2); //append는 오른쪽에 붙이는 메소드
		}
		System.out.println("2진수 = " + builder.toString()); //Int같은 원시형은 복잡한 계산은 내가 직접 해야함.
		System.out.println("2진수 = " + Integer.toBinaryString(value)); //메소드를 잘 이해하고 있다면 복잡한 계산은 Integer가 더 좋다
		
		System.out.println("--------");
		//하이브리드
		Integer v1 = 10; //int를 자동으로 Integer로 변환(auto-boxing) *그 반대는 auto-unboxing
		Integer v2 = 20; //원시형들만 이렇게 new 없이 인스턴스 생성 가능! 실제로는 이 방식은 객체 지향에서 어긋나는 방향
		Integer v3 = v1 + v2;
		System.out.println("v3 = " + v3);
		
		System.out.println("--------");
		//(중요) int와 Integer를 반드시 구분해야 하는 경우 (null이 나올 경우) *null = 참조대상이 없는 것
		// - 참조형만 쓸 수 있는 곳, null이 나올 수 있는 경우(없을 수 있는 경우)
		//int x = null; int는 참조형이 아님
		Integer y = null;
		
		//이전에 본 적이 있는 문자열 변환 명령
		String number = "123456";
		int change = Integer.parseInt(number); //Integer로 만드는 명령은 .valueOf -> parseInt가 더 많이 쓰임
		System.out.println("change = " + change);
		
		//상수 필드
		System.out.println(Integer.MIN_VALUE); //int가 가질 수 있는 가장 작은 값
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.BYTES);
		
	}

}
