package api.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test01예외처리의필요성3 {

	public static void main(String[] args) {
		
		//예외는 종류가 다양한데 통합하여 처리할 수 없을까?
		//-> 통합 예외 처리는 Exception으로 해결!

		try  { //플랜A
			Scanner sc = new Scanner(System.in);
		
			System.out.print("금액 : ");
			int money = sc.nextInt();
		
			System.out.print("인원수 : ");
			int people = sc.nextInt();
		
			int div = money / people;
			int mod = money % people;
		
			System.out.println("1인당 금액 = " + div + "원");
			System.out.println("자투리 금액 = " + mod + "원");
		}
		//플랜B
//		catch(Object e) { //Object는 예외가 아니라서 안됨
//			System.err.println("입력이 잘못되었습니다");
//		}
//		catch(Throwable e) { //Throwable이 많은 예외 처리를 할 수 있음 -> 하지만, 에러까지 처리해버려서 남이 준 코드를 실행할 때 사용
//			System.err.println("입력이 잘못되었습니다");
//		}
		catch(Exception e) { //두 예외의 이름 끝이 Exception이므로 최상위 예외는 Exception일 것이다
			System.err.println("입력이 잘못되었습니다");
		}
//		catch(RuntimeException e) { //입력이 어떻게 잘못되었는지는 이제 알 수 없음. 아이디나 패스워드가 잘못되었을 때 굳이 뭐가 잘못되었는지 알려줄 필요가 없는 것처럼
//			System.err.println("입력이 잘못되었습니다");
//		}
		
		
	}

}
