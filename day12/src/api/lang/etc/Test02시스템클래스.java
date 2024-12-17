package api.lang.etc;

public class Test02시스템클래스 {

	public static void main(String[] args) {
		//System 클래스
		//- Math처럼 생성이 불가하고 일회용 필드, 메소드만 존재하는 클래스
		//- 프로그램 외부의 시스템 정보를 이용할 수 있도록 도와주는 클래스
		
		//System a = new System();
		
		//시간 측정(소요시간 측정용)
		long time = System.currentTimeMillis();
		System.out.println("time = " + time);
		
		//외부 환경 정보(OS, JDK, ...) 읽기
		//- System.getProperty("이름") //찾기
		//System.out.println(System.getProperties()); //가능한 모든 정보를 출력
		System.out.println(System.getProperty("java.specification.version"));
		System.out.println(System.getProperty("os.name"));
		
		String os = System.getProperty("os.name");
		if(os.toLowerCase().startsWith("windows")) {//윈도우라면
			System.out.println("윈도우에서 실행중입니다");
		}
		else if(os.toLowerCase().startsWith("mac")) {//mac os라면
			System.out.println("맥OS에서 실행중입니다");
		}
		System.out.println(System.getProperty("user.country"));
		System.out.println(System.getProperty("user.language"));
		System.out.println(System.getProperty("user.name"));
		System.out.println(System.getProperty("os.version"));
		System.out.println(System.getProperty("os.arch"));
		System.out.println(System.getProperty("user.home"));
		System.out.println(System.getProperty("user.dir")); // 현재 실행중인 프로그램의 위치
		
		//오류 메세지 출력
		System.err.println("오류메세지"); //표준 입출력 통로와 다른 통로여서 다른 코드와 실행 순서가 달라질 수 있다.
		
		//강제종료
		//return; //메소드 종료 명령
		System.exit(0); //프로그램 종료 명령(위치 무관)
		System.out.println("이 메세지는 안보여요");

	}

}
