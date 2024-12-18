package api.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test01예외처리의필요성2 {

	public static void main(String[] args) {
		
		//try-catch구문
		//- try는 플랜A에 대한 코드를 작성
		//- catch는 플랜B에 대한 코드를 작성

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
		catch(ArithmeticException e) {//변수명도 적어줘야 함
			//여기서는 주도적으로 무언가를 하면 안됨. -> 그에 대한 플랜C, D..가 만들어질 가능성
			System.err.println("인원수는 0이 될 수 없습니다");
		}
		//플랜B
		catch(InputMismatchException e) {
			System.err.println("숫자 입력이 잘못되었습니다");
		}
		
	}

}
