package api.io.multi;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test04로또번호해석기2 {

	public static void main(String[] args) throws IOException {
		
		//불러올 데이터를 저장할 저장소
		List<Integer> lottoNumbers = new ArrayList<>();
		
		//파일 입력
		File target = new File("sample", "lotto.kh"); //확장자는 아무 의미 없음. 확장자가 없다고 해서 mp4가 동영상 파일이 아닌게 아님. 보여지는 껍데기가 다른것.
		
		FileInputStream in = new FileInputStream(target);
		BufferedInputStream buffer = new BufferedInputStream(in); //buffer는 모아주는 역할 -> 모아야 성능이 좋아지므로
		DataInputStream data = new DataInputStream(buffer);
		
		//6번인 것을 모를 때
		try  {
			while(true) {
				int number = data.readInt();
				lottoNumbers.add(number);
			}
		}
		catch(Exception e) {} 
		
		data.close();
		
		//출력
		for(int number : lottoNumbers) {
			System.out.println("번호 : " + number);
		}
	}

}
