package api.collection2;

import java.util.Set;
import java.util.TreeSet;

public class Test04차트분석 {

	public static void main(String[] args) {
		//데이터 준비
		Set<String> youtubeMusic = Set.of("APT", "HOME SWEET HOME", "Whiplash", "toxic till the end", "내 이름 맑음");
		Set<String> melonMusic = Set.of("HOME SWEET HOME", "APT", "Whiplash", "나는 반딧불", "POWER");
		
		Set<String> intersection = new TreeSet<>();
		intersection.addAll(youtubeMusic);
		//Set<String> intersection = new TreeSet<>(youtubeMusic); -> addAll 안해도 됨
		intersection.retainAll(melonMusic);
		
		
		System.out.println("<유튜브와 멜론에서 모두 순위권인 곡>");
		for(String title : intersection) {
			System.out.println("- " + title);
		}
		
		//방법 1 - 차집합 두개를 합집합
		Set<String> minus1 = new TreeSet<>();
		minus1.addAll(youtubeMusic);
		minus1.removeAll(melonMusic);
		
		Set<String> minus2 = new TreeSet<>();
		minus2.addAll(melonMusic);
		minus2.removeAll(youtubeMusic);
		
		Set<String> only1 = new TreeSet<>();
		only1.addAll(minus1);
		only1.addAll(minus2);
		
		System.out.println("<유튜브 또는 멜론에서만 순위권인 곡>");
		for(String title : only1) {
			System.out.println("- " + title);
		}
		
		//방법 2 - 합집합에서 교집합을 차집합 연산
		Set<String> only2 = new TreeSet<>();
		only2.addAll(youtubeMusic);
		only2.addAll(melonMusic);
		only2.removeAll(intersection);
		System.out.println("<유튜브 또는 멜론에서만 순위권인 곡>");
		for(String title : only2) {
			System.out.println("- " + title);
		}
		
	}

}
