package api.io.object;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Date;

public class Test02객체입력 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		//객체 입력
		//- 파일에 저장되어 있는 인스턴스를 프로그램으로 불러오는 것
		//- 객체 입력은 역직렬화(Deserialize), 합성, 임시저장, 입력 과정을 거친다
		//- 준비물 : 입력용 파일, 입력 스트림, 버퍼스트림, 역직렬화+합성 스트림
		
		File target = new File("sample", "object.kh"); //폴더나 파일은 이미 만들어져 있어야 함. 그래야 입력이 가능!
		
		FileInputStream in = new FileInputStream(target);
		BufferedInputStream buffer = new BufferedInputStream(in);
		ObjectInputStream obj = new ObjectInputStream(buffer);
		//ObjectInputStream obj = new ObjectInputStream(new BufferedInputStream(new FileInputStream(target)));
		
		//[프로그램] <- obj <- buffer <- in <- target <- [실제파일]
		//(주의) 종류와 무관하게 Object로 읽는다
		//Object a = obj.readObject();
		Date a = (Date) obj.readObject(); //다운 캐스팅
		Student b = (Student) obj.readObject();
		
		obj.close();
		
		System.out.println("a = " + a);
		System.out.println("b = " + b);
	}

}
