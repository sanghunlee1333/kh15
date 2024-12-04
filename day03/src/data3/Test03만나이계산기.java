package data3;

public class Test03만나이계산기 {

	public static void main(String[] args) {
		
		//입력
		int y = 2016, m = 3;
				
		//처리
		int t = y * 12 + m; 
		int now = 2024 * 12 + 12;
				
		int gap = now - t;
		
		int age = gap / 12;
		boolean vote = age >= 18;
		
		//출력
		System.out.println(age);
		System.out.println(vote);
		
		
	}

}
