package oop.method1;

public class Test01메소드의활용 {

	public static void main(String[] args) {
		Student s1 = new Student();
		Student s2 = new Student();
		Student s3 = new Student();
		
		s1.init("홍길동", 70, 80, 90);
		s2.init("이순신", 80, 80, 90);
		s3.init("피카츄", 50, 50, 70);
		
		s1.show(); //s1을 주인공으로 해서 show 메소드를 실행하세요!
		s2.show(); //s2을 주인공으로 해서 show 메소드를 실행하세요!
		s3.show(); //s3을 주인공으로 해서 show 메소드를 실행하세요!
	}

}
