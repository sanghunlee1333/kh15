package array;

public class Test02여러가지배열생성 {

	public static void main(String[] args) {
		
		// 모든 배열은 length라는 버튼을 가지고 있으며 자동으로 길이를 구해준다
		
		float[] data1 = new float[] { 15.2f, 20.6f, 35.7f, 22.1f, 30.6f };
		String[] data2 = new String[] { "자바", "안드로이드", "스프링", "JSP" };
		Long[] data3 = new Long[] { 100L, 200L, 300L };
		
		//주석 처리 : 드래그해서 ctrl + shift + C

		for (int i = 0; i < data1.length; i++) { //data1배열의 처음부터 끝까지
			System.out.println("data1" + " = " + data1[i]);
		}
		for (int i = 0; i < data2.length; i++) {
			System.out.println("data2" + " = " + data2[i]);
		}
		for (int i = 0; i < data3.length; i++) {
			System.out.println("data3" + " = " + data3[i]);
		}

	}

}
