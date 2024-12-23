package api.collection3;

import java.util.HashMap;
import java.util.Map;

public class Test01KeyValue저장소 {

	public static void main(String[] args) {
		//Map
		//- key-value 저장소
		//- 개별적인 데이터에 가장 빠르게 접근하기 위한 형태 (전반적인 데이터들에는 관심 없음) 
		//- key는 유일해야 하며 드러나는 정보
		//- value는 중복이 가능하며 숨겨져 있는 정보
		//- key를 이용해서 value를 빠르게 접근하는 것이 목표
		//- (ex)아이디(key)와 비밀번호(value) -> key는 중복이 있으면 안됨
		
		Map<String, String> monsters = new HashMap<>();
		//load factor -> initial capacity가 몇 인데, 여기서 몇 퍼센트(load factor)가 차면 공간을 늘리겠다.
		
		//데이터 추가
		monsters.put("피카츄", "전기");
		monsters.put("이상해씨", "풀");
		monsters.put("라이츄", "전기");
		monsters.put("파이리", "불꽃");
		
		monsters.put("이상해씨", "독"); //key가 같은 경우 value를 덮어쓰기
		
		//데이터 개수
		System.out.println("데이터 개수 : " + monsters.size());
		
		//데이터 검색
		System.out.print("피카츄가 key에 있습니까? ");
		System.out.println(monsters.containsKey("피카츄"));
		System.out.print("물 속성이 value에 있습니까? ");
		System.out.println(monsters.containsValue("물"));
		
		//데이터 삭제
		monsters.remove("라이츄"); //key가 라이츄인 데이터를 지우세요
		
		//데이터 추출(위치를 찾는게 아니라, Key값을 기반으로 찾아가는 Value를 찾는 것)
		System.out.println("피카츄 속성? " + monsters.get("피카츄"));
		System.out.println("꼬부기 속성? " + monsters.get("꼬부기"));
		
		System.out.println(monsters);
	}

}
