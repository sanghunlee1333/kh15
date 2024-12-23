package api.collection3;

import java.util.Map;
import java.util.Set;

public class Test03전체출력 {

	public static void main(String[] args) {
		//Map은 기본적으로 개별 접근에 특화되어 잇다
		//하지만 전체를 보고 싶은 경우도 있지 않을까??
		
		Map<String, Integer> data = Map.of(
			"유재석", 52, "강호동", 54, "신동엽", 53,
			"이경규", 64, "남희석", 53, "이영자", 57
		);
		
		//(Q) 전체 이름과 나이를 한 번에 조회하긴 어렵다
		//1. 이름(key)만 먼저 추출 (Set)
		Set<String> names = data.keySet();
		//2. 이름을 출력
		for(String name : names) {
			System.out.println("이름 : " + name + ", 나이 : " + data.get(name));
		}
		
		
	}

}
