package loop;

public class Test05삼육구게임 {

	public static void main(String[] args) {
		
		System.out.println("게임 시작!");

		for (int i = 1; i < 100; i++) {
			int ten = i / 10, one = i % 10;
			boolean a = ten == 3 || ten == 6 || ten == 9;
			boolean b = one == 3 || one == 6 || one == 9;
			boolean case1 = a && b; // 십의 자리와 일의 자리가 모두 3 또는 6 또는 9일 때
			boolean case2 = a || b; // 십의 자리가 3 또는 6 또는 9가 아닐 때
			
			if (case1) {
				System.out.println("짝짝");
			} else if (case2) { //첫 조건문에서 두 자릿수가 3,6,9인 경우를 제외했기 때문에 두번째 조건에서 제외 되는 것!! 순서 바꾸면 안됨.
				System.out.println("짝");
			} else {
				System.out.println(i);
			}
		}
	}

}
