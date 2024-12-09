package loop2;

import java.util.Random;

public class Test04랜덤찾기 {

	public static void main(String[] args) {
		// 랜덤(Random)
		// - 도저히 뭐가 나올지 알 수 없는 값
		// - 로또, 주사위, 동전,...
		// - 어느 범위에서 나오는지는 알 수 있다
		// - 프로그램에서 생성하는 건 100%랜덤은 아니다
		// - 범위를 제한하기 위해서 시작, 개수를 알아야 한다
		// - 1부터 45까지 = 1부터 45개
		// - 10부터 99까지 = 10부터 90개
		
		Random r = new Random();
		
		//System.out.println(r.nextInt()); //int전체
		int dice = r.nextInt(6) + 1; //주사위(1부터 6개) 1이라고 안쓰면 시작은 0
		System.out.println("dice = " + dice);
		
		int lotto = r.nextInt(45) + 1;
		System.out.println("lotto = " + lotto);
		
		int otp = r.nextInt(900000) + 100000; //otp(100000 ~ 999999)
		System.out.println("otp = " + otp);

	}

}
