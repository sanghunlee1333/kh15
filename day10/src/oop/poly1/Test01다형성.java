package oop.poly1;

public class Test01다형성 {

	public static void main(String[] args) {
				
		//업캐스팅(up-casting)이란 데이터의 보관형태를 상위 형태로 변환하는 것
		//다운캐스팅(down-casting)이란 데이터의 보관형태를 원래 형태로 변환하는 것
		
		//업 캐스팅의 예시 (빨래 통에 옷 넣기)
		Galaxy p1 = new Galaxy();
		
		Phone p2 = p1; //업캐스팅 (보관형태가 Galaxy에서 Phone으로 바뀜) //갤럭시는 폰이기 때문에 가능
		
		//다운 캐스팅의 예시 (빨래 통에 있는 옷 분류하기)
		//Galaxy p3 = p2; //폰은 갤럭시가 아니기 때문에 넣을 수 없음. 아래 cast연산 방법 사용
		Galaxy p3 = (Galaxy)p2; //다운 캐스팅 (보관형태가 Phone에서 Galaxy로 되돌려지는 것)
		//변환한다고 생각하지 말고 원래 갤럭시였던 것을 갤럭시에 넣는다는 생각!
	}

}
