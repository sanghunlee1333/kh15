package api.lang.string;

public class Test08문자열합성 {

	public static void main(String[] args) {
		//문자열이 불변이어서 불편한 상황
		//- 문자열은 덧셈이 가능
		//- 덧셈을 한다고 원본이 늘어나는 것이 아니라 신규 문자열이 생성됨
		//- 문자열이 커질수록 낭비가 매우 심해짐
		
		String text = "";
		
		//시간 측정 시작 지점
		long begin = System.currentTimeMillis(); //시스템의 현재시간을 숫자로
		for(int i = 0; i < 10; i++) { //100 -> 15ms, 1000 -> 17ms, 10000 -> 42ms, 
									  //100000 -> 881ms, 1000000 -> 46022ms, 10000000 -> 측정불가 
			text += "?";			  // -> 문자열 더하기는 왠만하면 하면 안된다.
									  // Thread -> 하나의 작업을 처리하는 직원. 싱글 쓰레드/멀티 쓰레드 
									  // Non-Thread safe -> 변기에 좌물쇠가 없음
									  // Thread safe -> 변기에 좌물쇠가 있음. 순서 중요(안전)
									  
		}
		long end = System.currentTimeMillis();
		//시간 측정 종료 지점
		
		System.out.println("완료!");
		System.out.println("begin = " + begin);
		System.out.println("end = " + end);
		System.out.println("ms = " + (end-begin)); //0.014초
	}

}
