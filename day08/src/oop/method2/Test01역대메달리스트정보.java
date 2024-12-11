package oop.method2;

public class Test01역대메달리스트정보 {

	public static void main(String[] args) {
		
		//인스턴스 생성
		Medallist m1 = new Medallist();
		Medallist m2 = new Medallist();
		Medallist m3 = new Medallist();
		
		//초기화
		//m1.name = "진종오"; //되긴 하지만, 학원까지 버스 안타고 걸어오는 느낌
		m1.init("진종오", "사격", "하계", 4, 2, 0); //매개변수가 아닌 인자라고 함
		m2.init("김수녕", "양궁", "하계", 4, 1, 1);
		m3.init("전이경", "쇼트트랙", "동계", 4, 0, 1);
		
		//출력
		m1.show();
		m2.show();
		m3.show();
		
	}

}
