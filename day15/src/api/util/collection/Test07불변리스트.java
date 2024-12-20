package api.util.collection;

import java.util.Arrays;
import java.util.List;

public class Test07불변리스트 {

	public static void main(String[] args) {
		
		//원래 List는 가변이다(=데이터가 늘었다 줄었다 할 수 있다)
		//하지만 원한다면 불변리스트를 생성할 수 있다
		//불변리스트는 추가/삭제가 불가능하다
		//변하지 않는 초기데이터를 저장할 때 배열 대신 사용
		
		//Java 8+ //8이상
		List<String> a = Arrays.asList("피카츄", "라이츄", "파이리"); //(강의)다시 돌려보기
		System.out.println(a.getClass()); //a의 자료형 확인 //-> $중첩클래스 표시
		System.out.println(a);
		
		//Java 9+
		List<String> b = List.of("피카츄", "라이츄", "파이리"); //lmmutable -> 불변
		System.out.println(b.getClass()); 
		System.out.println(b);
		
		//추가/삭제가 불가능
		//a.add("꼬부기"); //예외 발생
		//a.remove("피카츄"); //예외 발생
		//b.add("꼬부기"); //예외 발생
		//b.remove("피카츄"); //예외 발생
		
		List<String> c = b.subList(0, 2); //리스트 자르기(=문자열 자르기) //클래스가 달라서 List로 업캐스팅하지 않으면 못 쓴다
		System.out.println(c.getClass());
		System.out.println(c);
	}

}
