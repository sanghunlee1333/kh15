package data2;

public class Test03체질량계산기 {

	public static void main(String[] args) {
		int weight = 80;
		float height = 1.80f;
	
		float bmi = weight / (height * height);

		System.out.println(bmi);
	}

}
