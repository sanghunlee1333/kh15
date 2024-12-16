package oop.poly2_1;

public abstract class Notebook {
	
	//껍데기라도 만들어두면 하위 클래서에서 재정의를 통해 쓸 수가 있으므로 만들어 둔다.
	//그래서 하위 메소드를 부르면 알아서 실행이 되는 것
	public abstract void power();
	public abstract void video();
	public abstract void typing();
	
}
