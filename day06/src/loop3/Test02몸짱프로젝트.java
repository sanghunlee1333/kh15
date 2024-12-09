package loop3;

public class Test02몸짱프로젝트 {

	public static void main(String[] args) {

		int total = 0;
		int pushup = 1; //쉬운 방식을 위해 반복문 밖에 선언
		for (int day = 1; day <= 30; day++) {
			// int pushup = day * 3 - 2; 어려운 방식
			System.out.println(day + "일차 : " + pushup + "개 달성");
			total += pushup;
			pushup += 3; // 쉬운 방식
		}

		System.out.println("누적 합계 : " + total);

	}

}
