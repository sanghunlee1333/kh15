package api.collection4;

import java.util.Stack;

public class Test01LIFO저장소 {

	public static void main(String[] args) {
		//LIFO(Last In First Out)
		//- 늦게 들어온 것이 먼저 나간다(최신순으로 관리)
		//- 막다른 골목에 주차를 하는 상황과 유사, 기둥에 고리를 거는 상황과 유사
		//- 대표적으로 Stack이 존재 (이력 관리)
		
		Stack<String> stack = new Stack<>();
		
		//추가 - add()가 아니라 push()
		stack.push("구글"); 
		stack.push("네이버");
		stack.push("카카오");
		
		System.out.println("최신 데이터 = " + stack.peek()); //카카오
		stack.pop(); //삭제(뒤로가기 또는 ctrl+z와 유사) - 제일 마지막 것이 삭제
		System.out.println("최신 데이터 = " + stack.peek()); //네이버
		stack.pop(); //삭제(뒤로가기 또는 ctrl+z와 유사) - 제일 마지막 것이 삭제
		System.out.println("최신 데이터 = " + stack.peek()); //구글
		stack.pop(); //삭제(뒤로가기 또는 ctrl+z와 유사) - 제일 마지막 것이 삭제
		System.out.println("최신 데이터 = " + stack.peek()); //에러
		stack.pop(); //삭제(뒤로가기 또는 ctrl+z와 유사) - 제일 마지막 것이 삭제
		
	}

}
