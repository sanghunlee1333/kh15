package api.io.multi;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test02멀티바이트출력 {

	public static void main(String[] args) throws IOException {
		//멀티바이트란 int, long, float, double처럼 1byte보다 크지만 크기가 일정한 데이터들을 말한다
		//-> 분해 + 임시저장 + 출력을 단계별로 진행
		
		File target = new File("sample", "multi.txt");
		FileOutputStream out = new FileOutputStream(target);
		BufferedOutputStream buffer = new BufferedOutputStream(out); //버퍼는 다 차지 않으면 보내지 않음
		DataOutputStream data = new DataOutputStream(buffer); //buffer 대신 out으로 대체해도 됨
															  //대신 buffer에서 크기 조절이 가능하지만, out은 기본 버퍼밖에 없으니성능이 좀 떨어짐
		//[프로그램] -> data -> buffer -> out -> target -> [실제파일]
		
		data.writeInt(100); //100을 int형태로 분해하여 출력(4조각)
		data.writeDouble(100); //100을 double형태로 분해하여 출력(8조각)
		data.writeLong(100); //100을 long형태로 분해하여 출력(8조각) //같은 8조각이라도 형태가 다르므로 맞는 것을 써야한다.
		data.writeChar(100); //100을 char형태로 분해하여 출력(2조각)
		data.writeFloat(100); //100을 float형태로 분해하여 출력(4조각)
		
		//다 차지 않아도 보내라
		//data.flush(); //전송만 - 계속적으로 보낼 때
		data.close(); //전송 후 종료
	}

}
