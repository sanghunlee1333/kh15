package api.io.object;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.Scanner;

public class Test01객체출력 {

	public static void main(String[] args) throws IOException {
		//객체 출력 - 인스턴스는 데이터의 종류, 크기등 파악이 어려워 write의 종류가 writeObject 밖에 없음. -> 속도가 느림
		//- 생성한 인스턴스의 정보를 파일에 통째로 저장하는 것
		//- 내부적으로 직렬화(Serialize), 분해, 임시저장, 출력의 과정을 거침
		//- 준비물 : 출력용 파일, 출력 스트림, 버퍼 스트림, 직렬화+분해 스트림
		
		File dir = new File("sample");
		dir.mkdirs(); //dir.mkdir(); //s가 붙은 것은 어떻게든 만들어줌. s가 안붙은 것은 갈 폴더가 없으면 안 만들어줌
		
		//File target = new File(dir, "object.kh");
		File target = new File("sample", "object.kh");
		FileOutputStream out = new FileOutputStream(target);
		BufferedOutputStream buffer = new BufferedOutputStream(out);
		ObjectOutputStream obj = new ObjectOutputStream(buffer);
		
		//[프로그램] -> obj -> buffer -> out -> target -> [실제 파일]
		
		//(ex) 자격이 있는 인스턴스 -> 자격 = 클래스에 java.io.Serializable라는 스티커(인터페이스)가 있어야 함!
		Date d = new Date();
		obj.writeObject(d); //Object는 아무거나 넣어도 된다는 뜻 //업캐스팅
		
		//(ex) 자격이 없는 인스턴스
		//정보는 저장이 되지만, 도구는 저장이 안됨
//		Scanner sc = new Scanner(System.in); -> java.io.Serializable을 상속받지 않은 클래스
//		obj.writeObject(sc);
		
		//(ex)내가 만든 클래스의 인스턴스
		Student st = new Student("홍길동", 90);
		obj.writeObject(st);
		
		obj.close(); //obj.flush(); -> 네트워크처럼 계속 이어져있어야 하는 경우. 종료하지 않는 경우
		
	}

}
