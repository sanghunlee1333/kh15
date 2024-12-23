package api.collection3;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Test04투표하기 {

	public static void main(String[] args) {
			
		Scanner sc = new Scanner(System.in);
		
		//저장소 준비
		Map<String, Integer> people = new TreeMap<>(); 
				
		while(true) {
			System.out.print("이름 : ");
			String name = sc.nextLine();
			
			if(name.equals("종료")) {
				System.out.println("프로그램을 종료합니다");
				break;
			}			
			Integer count = people.get(name); //해당 이름의 득표수를 추출
			//if(count == null) count = 1;
			//else count++;
			if(count == null) count = 0;
			count++;
			people.put(name, count);
			System.out.println("[" + name + "] 님의 득표수 : " + count);
						
//			else if(people.containsKey(name)) { //이미 존재하는 이름이라면
			//내 풀이
			//	people.put(name, people.get(name) + 1);
			//	System.out.println("[" + name + "] 현재 " + people.get(name) + "표 획득!");
//			//강사님 풀이	
//				int count = people.get(name);
//				count++;
//				people.put(name, count);
//				System.out.println("[" + name + "] 님의 득표수 : " + count);
//			}	
//			else { //처음 입력한 이름이라면
//				people.put(name, 1);
//				System.out.println("[" + name + "] 현재 " + people.get(name) + "표 획득!");
//			}
			
			
			
		}
		sc.close();
		
		//방식1
//		Set<String> names = people.keySet();
//		for(String name : names) {
//			System.out.println(name + " : " + people.get(name) + "표");
//		}
		//방식2
		for(String name : people.keySet()) {
			System.out.println(name + " : " + people.get(name) + "표");
		}
		
	}

}
