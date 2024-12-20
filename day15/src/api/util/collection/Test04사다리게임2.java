package api.util.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Test04사다리게임2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		try {
		
		System.out.print("참여 인원 수 : ");
		int num = sc.nextInt();
		if(num < 2 || num > 24)
			throw new Exception("인원수를 2~24명으로 설정하세요");

		List<String> names = new ArrayList<>(num);
		//for(int i=0; i < names.size(); i++) {//한번도 실행이 안됨(현재 사이즈 0)
		for (int i = 0; i < num; i++) {
			System.out.print("이름" + (i + 1) + " : ");
			names.add(sc.next());
		}
		
		List<String> results = new ArrayList<>(num);
		for (int i = 0; i < num; i++) {
			System.out.print("선택지" + (i + 1) + " : ");
			results.add(sc.next());
		}
		
		sc.close();
		
		Collections.shuffle(results);
		
		for (int i = 0; i < num; i++) {
			System.out.println(names.get(i) + " -> " + results.get(i));
		}
		
		}
		catch(Exception e) {
			//e.printStackTrace();
			System.err.println("오류 : " + e.getMessage());
		}
		
	}

}
