package api.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test01예외처리의필요성4 {

	public static void main(String[] args) {
		
		//추가 업그레이드
		//[1] 자바가 인지하지 못하는 예외에 대한 처리
		//	- 금액이 0 이하인 경우
		//	- 인원수가 음수인 경우
		//  - throw 키워드를 이용해서 catch 블록을 강제 이동시킨다 
		//[2] 다양한 예외를 한 군데서 처리하는데.. 메시지를 구분할 방법?
		//  - catch블록의 매개변수인 e를 분석

		try  { //플랜A
			Scanner sc = new Scanner(System.in);
		
			System.out.print("금액 : ");
			int money = sc.nextInt();
			if(money <= 0) {
				//catch로 던져라
				//Exception e = new Exception();
				//throw e;	
				throw new Exception("금액은 0이하일 수 없습니다"); //위처럼 변수를 한 번만 쓰고 버리게 되므로, 해당 방식으로 짧게 쓰자
			}
		
			System.out.print("인원수 : ");
			int people = sc.nextInt();
			if(people < 0) {
				//catch로 던져라
				//Exception e = new Exception();
				//throw e;
				throw new Exception("인원수는 0보다 커야 합니다");
			}
		
			int div = money / people;
			int mod = money % people;
		
			System.out.println("1인당 금액 = " + div + "원");
			System.out.println("자투리 금액 = " + mod + "원");
		}
		//플랜B
		catch(Exception e) { //두 예외의 이름 끝이 Exception이므로 최상위 예외는 Exception일 것이다
			
			//System.err.println("입력이 잘못되었습니다");
			//예외 인스턴스인 e에는 message라는 항목이 있고 원인이 작성된다
			//message가 null이면 기본 오류메세지, 아니면 message를 보여준다
			if(e.getMessage() == null) {
				System.err.println("프로그램에서 오류가 발생했습니다");
			}
			else { 
				System.err.println("예외 : " + e.getMessage());
			}
			
			//java.lang.(클래스) : by zero(메시지)
			
		}

		
	}

}
