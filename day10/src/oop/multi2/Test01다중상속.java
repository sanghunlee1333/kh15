package oop.multi2;

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

	}

}
