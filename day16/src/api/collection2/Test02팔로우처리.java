package api.collection2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Test02팔로우처리 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Set<String> followList = new HashSet<>(); //List로 만들어도 되지만, Set으로 만들면 중복이 절대 들어갈 수 없다는 믿음이 생긴다
		//Set<String> followList = new TreeSet<>(); //정렬이 필요없으므로 Tree보단 Hash로 만든다. Tree는 정렬까지 해주지만 살짝 더 느리다.
		
		while (true) {
			System.out.print("아이디 입력 : ");
			String name = sc.next();
						
			if(name.equals("종료")) break;
			
			//(참고)
			//- set은 contains()를 쓰지 않아도 존재여부를 알 수 있다
			//- add 메소드를 실행했을 때 반환값이 논리가 나옴. List는 불가
//			if(followList.add(name)) {//데이터가 들어갔다면(존재하지 않았던 아이디라면)
//				
//			}
			
			if (followList.contains(name)) {
				System.out.println("[" + name + "] 님을 팔로우 해제하였습니다.");
				followList.remove(name);
			} 
			else {
				System.out.println("[" + name + "] 님을 팔로우하였습니다.");
				followList.add(name);
			}
			
		}
		sc.close();
		System.out.println("총 팔로우한 인원 수는 [" + followList.size() + "]명 입니다.");
		System.out.println("팔로우 내역 : " + followList);
		
//		for(int i = 0; i < followList.size(); i++) {//하나씩 보여주는 것은 불가
//			System.out.println(followList.get(i)); //get 메소드가 없음
//		}
		
		for(String id : followList) { //다 보여주는 것은 가능
			System.out.println("아이디 = " + id);
		}
		
	}

}
