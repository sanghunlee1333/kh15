package api.util.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Test04사다리게임 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("참여 인원 수 : ");
		int num = sc.nextInt();

		List<String> names = new ArrayList<>(num);
		List<String> results = new ArrayList<>(num);
		
		for (int i = 0; i < num; i++) {
			System.out.print("이름" + (i + 1) + " : ");
			names.add(sc.next());
		}
		for (int i = 0; i < num; i++) {
			System.out.print("선택지" + (i + 1) + " : ");
			results.add(sc.next());
		}
		Collections.shuffle(results);
		
		for (int i = 0; i < num; i++) {
			System.out.println(names.get(i) + " -> " + results.get(i));
		}

		sc.close();
	}

}
