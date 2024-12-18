package api.time;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test01시간다루기 {

	public static void main(String[] args) {
		//자바에서 시간을 다루는 방법
		//1. java.lang.System 클래스
		//2. java.util.Date 클래스
		//3. java.util.Calendar 클래스
		//4. java.time 패키지
		
		//왜 이렇게 많을까? 이게 다 Y2K(2000년) 때문!
	
		//(ex) Date 클래스
		Date a = new Date();
		Date b = new Date(124, 11, 18); //오버로딩 //1900년 기준 & 1~12 -> 0~11 -> 오래됨..
		
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		
		//날짜의 출력 형식을 바꾸고 싶다면 java.text.SimpleDateFormat을 사용
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd E"); //(참고) count = cnt. E는 OS국가 설정에 맞게 나옴
		System.out.println(fmt.format(a));
	}

}
