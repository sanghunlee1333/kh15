package api.collection2;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Test01Set저장소 {

	public static void main(String[] args) {
		
		//Set
		//- 특수한 목적에 의해 설계된 비선형구조 저장소
		//- 트리(TreeSet), 해시(HashSet)를 사용하는 저장소가 존재
		//- 추가된 순서를 무시하고 저장소에 정해진 규칙에 따라 데이터를 보관
				
		Set<String> a = new TreeSet<>();
		Set<String> b = new HashSet<>();
		
		a.add("피카츄");
		b.add("피카츄");
		a.add("라이츄");
		b.add("라이츄");
		a.add("파이리");
		b.add("파이리");
		a.add("꼬부기");
		b.add("꼬부기");
		
		a.add("꼬부기"); //중복 데이터를 넣으면 안 들어감
		b.add("꼬부기");
		
		System.out.println("a = " + a); 
		System.out.println("b = " + b);
		
		System.out.println("a의 데이터 개수 : " + a.size()); 
		System.out.println("b의 데이터 개수 : " + b.size()); 
		
		System.out.print("a에 피카츄가 포함되어 있습니까? ");
		System.out.println(a.contains("피카츄"));
		
		a.remove("피카츄");
		System.out.println("a = " + a);
		
		//(주의) get 명령은 존재하지 않는다(인덱스가 없음)
		//System.out.println(b.get(0));
	}

}
