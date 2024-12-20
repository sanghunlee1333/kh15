package api.util.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test02로또번호생성기 {

	public static void main(String[] args) {

//		List<Integer> a = new ArrayList<>();
//
//		Random r = new Random();
//
//		for (int i = 0; i < 6; i++) {
//			a.add(r.nextInt(45) + 1);
//			for (int count = 0; count <= i; count++) {
//				if (a.get(count) == a.get(i)) {
//					a.remove(i);
//					a.add(r.nextInt(45) + 1);
//				}
//			}
//		}
//		System.out.println(a);
		
		//강사님 풀이1(while)
		
		Random r = new Random(); //랜덤 새엉기
		List<Integer> lottoNumbers = new ArrayList<>(); //숫자 저장소
		
//		[1] 숫자가 6개가 되면 중지하는 반복문
//		while(true) {
//			if(lottoNumbers.size() == 6) break;
//		}
		
//		while(lottoNumbers.size() < 6) {
//			int number = r.nextInt(45) + 1;
//			if(!lottoNumbers.contains(number)){//존재하지 않는 번호면
//				lottoNumbers.add(number); //추가하세요
//			}
//		}
//		System.out.println(lottoNumbers);
		//(추가)배열로도 만들어보기
		
		//강사님 풀이2(for)
		for (int i = 0; i < 6; i++) {//6번
			System.out.println("i = " + i);
			int number = r.nextInt(45) + 1;
			if(!lottoNumbers.contains(number)) {//이미 존재하는 숫자가 아니면
				lottoNumbers.add(number); //추가하세요
			}
			else {//이미 존재하는 숫자라면
				i--;//반복변수가 늘어나지 않도록 -1하여서 한바퀴 더 돌도록 처리
			}
		}
		System.out.println(lottoNumbers);
	}

}
