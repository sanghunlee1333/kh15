package data3;

public class Test04논리연산 {

	public static void main(String[] args) {
		// (ex) 청소년 판정 (=중고등학생, 14~19세)
		// &&(and)는 양쪽 조건이 모두 참이라면 참을 반환(나머지는 거짓을 반환)

		int age = 17;

		// 기본적으로 계산은 왼쪽에서 오른쪽으로!
		// 논리연산자는 비교연산보다 후순위라 나중에 계산된다! 그래서 왼쪽에서 오른쪽 계산 순서가 적용되지 않는다.
		// 계산 순서를 바꿀것이면 소괄호 사용
		boolean teen = (age >= 14) && (age <= 19);

		System.out.println(teen);

		// (ex) 무임승차대상인가요? (65세이상 or 8세 미만)
		// or(||)은 양쪽 중 하나라도 참이면 결과를 참으로 반환
		boolean free = (age >= 65) || (age < 8);
		System.out.println(free);

		// boolean free2 = age가 8세 이상 65세 미만이 아닌가요?
		// not(!)은 우측의 내용을 반대로 해석
		boolean free2 = !((age >= 8) && (age < 65));
		System.out.println(free2);

	}

}
