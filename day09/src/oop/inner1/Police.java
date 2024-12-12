package oop.inner1;

//경찰이 총을 2자루(left, right)소유할 수 있도록 구현
public class Police {
	// private Gun left; //총이 들어갈 수 있는 자리만 만들어준 것.
	private Gun left = new Gun(); //Gun 클래스가 private이므로 메인을 가진 클래스에서 생성이 불가하므로, Gun을 가진 Police클래스에서 인스턴스 생성
	private Gun right = new Gun();
	
	// 여기에서 Gun 클래스 내부의 것을 사용하려면 위처럼 Gun인스턴스를 생성하고 left.무엇, right.무엇으로 접근하면 된다!
	
	//getter, setter메소드는 만들 수 있지만, getter는 몰라도 setter는 굳이 만들 필요가 없다.
//	public Gun getLeft() {
//		return left;
//	}
//	public void setLeft(Gun left) {
//		this.left = left;
//	}
//	public Gun getRight() {
//		return right;
//	}
//	public void setRight(Gun right) {
//		this.right = right;
//	}
	
	//중첩 클래스(nested class)
	// - 클래스 간의 소유관계를 구현할 수 있다
	// Gun클래스는 Police클래스의 전용 클래스가 된다.
	// - 클래스도 !멤버 취급되므로 접근 제한 가능
	private class Gun { //public도 가능하지만 여기선 Police에게만 소유하게 할 것이므로 private로 선언. 
						//public으로 선언할 것이면 중첩 클래스를 만든 의미가 없다.

	}
	
}
