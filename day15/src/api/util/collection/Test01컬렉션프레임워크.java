package api.util.collection;

import java.util.ArrayList;
import java.util.List;

public class Test01컬렉션프레임워크 {

	public static void main(String[] args) {
		
		
		//JCF(Java Collection Framework)
		//- 자바에서 제공하는 대용량 가변 저장소 (cf : 배열) *배열은 한번 크기가 정해지면 변경 불가
		//- 데이터의 저장 원리에 따라 여러 종류로 구분
		//- (ex) 리스트, 세트, 스택, 큐, 데크, ... 
		//- 다른 말로 자료구조(Data Structure) 구현체라고 부른다
		
		//세트(Set) - 자기가 정해놓은 규칙(해시, 정렬 등)에 따라 데이터를 넣는 것. 데이터 무한
		//리스트(List) - 순서가 중요. 데이터 무한
		
		//ArrayList<E> -> ArrayList<String>, ArrayList<Integer>, ArrayList<Float>
		//<E> -> Generic Type(내용물의 형태), 원시형이 아닌 클래스 타입으로 적어야 함!
		
		//List(리스트)
		//- 순서를 보장하는 저장소
		//- ArrayList는 배열의 형태를 가진 리스트
		ArrayList a = new ArrayList(); //내용물을 알 수 없어서경고
		ArrayList<String> b = new ArrayList<String>(); //문자열이 담긴 저장소
		ArrayList<String> c = new ArrayList<>(); //오른쪽 생략 가능
		//ArrayList<int> d = new ArrayList<>(); //원시형은 제네릭 타입으로 사용 불가
		ArrayList<Integer> d = new ArrayList<>(); //정수가 담긴 저장소
	 	List<String> e = new ArrayList<>(); //업캐스팅 -> 최종형태
		
	 	//데이터 추가
	 	e.add("피카츄");//0
	 	e.add("라이츄");//1
	 	e.add("파이리");//2 -> 3
	 	e.add("꼬부기");//3 -> 4
	 	e.add("버터플");//4 -> 5
	 	
	 	e.add(2, "또가스"); //2번에 삽입. *배열은 데이터가 밀리지 않고 덮어씌워짐
	 	
	 	//d.add("피카츄"); //d에는 정수만 넣을 수 있어서 오류
	 	System.out.println(e);
	 	System.out.println(e.size()); //데이터 개수
	 	
	 	//데이터 탐색
	 	System.out.print("피카츄가 있어요? ");
	 	System.out.println(e.contains("피카츄"));
	 	System.out.print("푸린이 있어요? ");
	 	System.out.println(e.contains("푸린"));
	 	
	 	//데이터 삭제
	 	e.remove("파이리"); //파이리와 일치하는 데이터를 지우세요
	 	System.out.println(e);
	 	e.remove(1); //1 위치의 데이터를 지우세요
	 	System.out.println(e);
	}

}
