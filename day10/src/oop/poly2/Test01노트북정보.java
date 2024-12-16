package oop.poly2;

// 상속 안한 버전
// 중복 코드가 있어서 별로다

public class Test01노트북정보 {

	public static void main(String[] args) {

		int type = 1; //기종(1. 맥북 2. 갤럭시북
		int action = 2; //기능(1. 전원 2. 동영상 재생 3. 타이핑 //스캐너 처리해도 됨
		
		if (type == 1) { //맥북
			Macbook notebook = new Macbook();
			if (action == 1) 
				notebook.power();
			else if (action == 2) 
				notebook.video();
			else 
				notebook.typing();
		}
		else { //갤럭시북
			Galaxybook notebook = new Galaxybook(); //서로 다른 괄호이므로
													//인스턴스 이름이 같아도 노상관
			if (action == 1) 
				notebook.power();
			else if (action == 2) 
				notebook.video();
			else 
				notebook.typing();
		}
			
		
		
	
		
		
	}

}
