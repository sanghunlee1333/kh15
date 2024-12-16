package api.lang.string;

public class Test08문자열합성3 {

	public static void main(String[] args) {
		//문자열이 불변이어서 불편한 상황
		//- 문자열은 덧셈이 가능
		//- 덧셈을 한다고 원본이 늘어나는 것이 아니라 신규 문자열이 생성됨
		//- 문자열이 커질수록 낭비가 매우 심해짐
		
		//non-thread safe
		StringBuilder builder = new StringBuilder(); //비어있는 가변문자열을 생성
		
		//시간 측정 시작 지점
		long begin = System.currentTimeMillis(); //시스템의 현재시간을 숫자로
		for(int i = 0; i < 100000000; i++) { 
			builder.append("?");			 
		}
		long end = System.currentTimeMillis();
		//시간 측정 종료 지점
		
		System.out.println("완료!");
		System.out.println("begin = " + begin);
		System.out.println("end = " + end);
		System.out.println("ms = " + (end-begin)); //0.014초
	}

}
