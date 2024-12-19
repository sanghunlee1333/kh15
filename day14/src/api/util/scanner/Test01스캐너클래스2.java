package api.util.scanner;

import java.util.Scanner;

public class Test01스캐너클래스2 {

	public static void main(String[] args) {
		// Scanner 클래스
		// - 문자열 패턴 분석기
		// - sc.next()는 단어를 읽는 명령 (hasNext()로 확인)
		// - sc.nextLine()는 줄을 읽는 명령 (hasNextLine()로 확인)
		// - 사용을 마치면 .close()를 통해 점유 메모리를 해제
		
		String song = "동해물과 백두산이 마르고 닳도록\n하느님이 보우하사 우리나라만세";
		Scanner sc = new Scanner(song);
		while (sc.hasNext()) {
			System.out.println(sc.nextLine());
		}
		sc.close();
	}

}
