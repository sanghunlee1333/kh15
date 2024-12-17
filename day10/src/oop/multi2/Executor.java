package oop.multi2;

public class Executor {

	// 아래 메소드는 Flyable을 상속받았다면 누구나 이용할 수 있는 메소드
	// -> 상속 자체가 자격요건이 되는 상황
	public static void delivery(Flyable flyable) {
		flyable.fly();
	}

	// 아래 메소드는 Electronic을 상속받은 경우만 이용할 수 있다(자격요건)
	public static void electonTransportation(Electronic electronic) {
		electronic.on();
		electronic.off();
	}
	// 상속을 받지 않았을 경우 하나씩 작성해야됨
	/*
	 * public static void electonTransportation(Drone drone) {} public static void
	 * electonTransportation(Kickboard kickboard) {}
	 */

}
