package oop.multi2;

//클래스 = 필드 + 메소드 + 생성자 + 중첩클래스
//필드 = 인스턴스의 구성 데이터
//메소드 = 인스턴스의 기능
//생성자 = 인스턴스를 초기화하는 도구
//중첩클래스 = 클래스를 소유하기 위한 방법
//
//캡슐화 = 밖에서 필수적인 기능 빼고는 못 보게 하자!
//
//<키워드>
//- 접근제한자 - private, (package), protected, public
//- final(불변), static(정적)
//
//- 상속 = 클래스 시리즈 (추상화, 다형성)
//- 다형성의 단점 = 에러가 났을 때 추적이 어렵다.
//
//추상클래스 = 필드 + 메소드 + 생성자 + 추상메소드 -> super (O)
//-> 모든 것의 공통 되는 것이 있다면 인터페이스가 아니라, 클래스일 확률이 70~80% ex) Transportation
//인터페이스 = 추상메소드 -> super (X)


public class Test01다중상속 {

	public static void main(String[] args) {
		
		Drone a = new Drone();
		Airplane b = new Airplane();
		Train c = new Train();
		Kickboard d = new Kickboard();
		Bus e = new Bus();

		a.on();
		a.off();
		a.move();
		a.fly();

		b.move();
		b.reservation();
		b.fly();

		c.move();
		c.reservation();

		d.on();
		d.off();
		d.move();

		e.move();
		
		//(+추가) 자격요건에 대해서
		//Executor.delivery(b); //a
		Executor.electonTransportation(d);


	}

}
