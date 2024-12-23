package api.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
//import java.util.Vector;

public class Test11리스트의종류 {
	
	//(면접 단골 질문) - 수업자료 참고
	//(Collection)리스트 - 순서
	//(Collection)Set - 전체에 대해 접근 (중복 금지)
	//(Collection X)Map - 개별에 대해 빠르게 접근 (Key중복 금지)
	

	public static void main(String[] args) {
		//선형구조
		//- 저장소의 시작과 끝이 명확한 형태
		
		List<String> a = new ArrayList<>(); //배열 형태, 조회에 특화
		List<String> b = new LinkedList<>(); //연결 형태, 추가/삭제에 특화 -> 참조형으로 떨어져있는 형태
		//List<String> c = new Vector<>(); //과거에 사용하던 저장소(느림, 전부다 Thread safe - 화장실, ATM기(동시에 1명밖에 못함))
		
		a.add("피카츄");
		b.add("피카츄");
		a.add("라이츄");
		b.add("라이츄");
		a.add("파이리");
		b.add("파이리");
		a.add("꼬부기");
		b.add("꼬부기");
		
		System.out.println(a); //데이터에 변함이 없고 조회 목적이면 -> ArrayList
		System.out.println(b); //데이터가 늘었다 줄었다 하면 -> Link
		// 그때 그때 상황에 맞게 변환해서 사용해야 함
		
		//다른 저장소의 데이터를 기반으로 저장소 생성이 가능
		List<String> d = new LinkedList<>(a); //a의 모든 데이터로 d 생성
		List<String> e = new ArrayList<>(b); //b의 모든 데이터로 e 생성
		
		System.out.println(d);
		System.out.println(e);
		
		//(참고)All 관련된 연산은 전부 집합 연산
		
	}

}
