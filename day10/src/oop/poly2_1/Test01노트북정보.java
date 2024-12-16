package oop.poly2_1;

import java.util.Scanner;

//상속 받은 버전
public class Test01노트북정보 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("노트북을 먼저 선택하세요");
		System.out.print("1. 맥북 2. 갤럭시북 : ");
		int type = sc.nextInt();
		System.out.println();
		
		System.out.println("테스트할 기능을 선택하세요");
		System.out.print("1. 전원 2. 동영상재생 : 3. 타이핑 : ");
		int action = sc.nextInt();
		
		//맥북이든, 갤럭시북이든 노트북이기만 하면 되는 상황
		// Notebook notebook = 맥북 or 갤럭시북; 업캐스팅 -> 상속관계니까 가능
		Notebook notebook; // 어떤 노트북을 넣을지 모르니 선언만 해두기
						   // 노트북을 만들기 위해 선언한게 아니라, 맥북과 갤럭시북을 합쳐 놓은 것이라는 의미!
		
		if(type == 1) { //맥북
			notebook = new Macbook(); 
		}
		else { //갤럭시북
			notebook = new Galaxybook();
		}
		
		//poly2에서는 각각의 노트북에 대해 기능도 나눠서 작성해야했음 -> 귀찮음
		if(action == 1) {
			notebook.power(); //하나의 코드로 한 번에 테스트 할 수 있다! <- 다형성을 쓰냐 안쓰냐의 차이
		}
		else if(action == 2) {
			notebook.video();
		}
		else {
			notebook.typing();
		}
			
		
	}

}
