package data2;

public class Test02성적계산기 {

	public static void main(String[] args) {
		
		//입력
		int kor = 65;
		int eng = 70;
		int mat = 80;
		
		int total = kor + eng + mat;
		//float average = total / 3.0f; //3f
		float average = (float)total / 3; //변환연산 (cast연산)
		
		System.out.println(total);
		System.out.println(average);
	}

}
