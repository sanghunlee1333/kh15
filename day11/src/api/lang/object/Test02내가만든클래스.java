package api.lang.object;

public class Test02내가만든클래스 {

	public static void main(String[] args) {
		Student a = new Student();
		a.setName("피카츄");
		a.setScore(90);
		Student b = new Student();
		b.setName("피카츄");
		b.setScore(80);
		
		System.out.println("a = " + a.hashCode());
		System.out.println("b = " + b.hashCode());
		
		System.out.println("a = " + a.toString());
		System.out.println("b = " + b.toString());
	}

}
