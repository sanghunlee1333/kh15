package array;

public class Test01배열만들기 {

	public static void main(String[] args) {
		// 배열(Array)
		// - 같은 종류의 데이터를 여러 개 보관하기 위한 저장소
		// (ex)다섯 명의 시험 점수를 보관 (80, 70, 90, 85, 60)
		// -> 변수 다섯 개를 만들어서 처리할 수 있다
		// (ex)국어점수가 10개(O), 국어점수 1개/영어점수 1개/수학점수 1개(X) -> 종류와 성질까지 같아야 한다.

		int a = 80, b = 70, c = 90, d = 85, e = 60;
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		System.out.println("c = " + c);
		System.out.println("d = " + d);
		System.out.println("e = " + e);

		// -> 배열 한 개를 만들어서 처리할 수 있다 (참조형)
		// score -------> [80][70][90][85][60]
		int score[] = new int[] { 80, 70, 90, 85, 60 }; // new 연산자로 int묶음을 만들어라.
		// []는 묶음. ex) int - 정수, int[] - 정수 묶음
		System.out.println("점수 = " + score); // 리모컨 출력(일련번호 나옴)
		System.out.println("점수 = " + score[0]); // +0지점 출력
		System.out.println("점수 = " + score[1]); // +1지점 출력
		System.out.println("점수 = " + score[2]); // +2지점 출력
		System.out.println("점수 = " + score[3]); // +3지점 출력
		System.out.println("점수 = " + score[4]); // +4지점 출력

		for (int i = 0; i <= 4; i++) {
			System.out.println("점수 = " + score[i]);
		}
	}

}
