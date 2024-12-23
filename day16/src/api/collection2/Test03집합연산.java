package api.collection2;

import java.util.Set;
import java.util.TreeSet;

public class Test03집합연산 {

	public static void main(String[] args) {
		//Set을 이용해서 합집합, 교집합, 차집합 등을 구할 수 있다
		
		//(참고)set도 불변 형태 생성이 가능하다
		Set<String> a = Set.of("사과", "딸기", "수박", "복숭아");
		Set<String> b = Set.of("수박", "복숭아", "포도", "바나나");
	
		//합집합(union) - 중복 요소를 제거하고 두 집합의 값을 합성
		Set<String> union = new TreeSet<>(); //보통 보여주고 싶을 때는 Tree, 안 보여주고 싶을 때는 Hash쓰긴 함(정렬 필요 없을 경우)
		union.addAll(a);
		union.addAll(b);
		System.out.println("합집합 = " + union);
		
		//교집합(intersection) - 두 집합에 모두 속한 값
		Set<String> intersection = new TreeSet<>();
		intersection.addAll(a);
		intersection.retainAll(b); //b와 겹치는 내용만 놔두고 모두 제거
		System.out.println("교집합 = " + intersection);
		
		//차집합(exception, minus) - 한 쪽에만 속한 값(a - b, b - a)
		Set<String> minus1 = new TreeSet<>();
		minus1.addAll(a);
		minus1.removeAll(b); //b에 해당되는 것들을 제거
		System.out.println("a - b = " + minus1);
		
		Set<String> minus2 = new TreeSet<>();
		minus2.addAll(b);
		minus2.removeAll(a); //a에 해당되는 것들을 제거
		System.out.println("b - a = " + minus2);
		
	}

}
