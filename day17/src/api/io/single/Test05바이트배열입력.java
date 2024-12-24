package api.io.single;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class Test05바이트배열입력 {

	public static void main(String[] args) throws IOException {
		//바이트를 모아서 입력
		//- 준비물 : 입력용 파일, 입력용 통로, 바이트 배열(카트)
		
		File target = new File("sample/singlearray.txt"); //파일명 오타나도 에러 안뜨니 주의
		FileInputStream in = new FileInputStream(target);
		
		byte[] buffer = new byte[5]; //buffer는 임시 저장소
		
//		int size;
//		size = in.read(buffer); //buffer를 가득 채우도록 입력받으세요 (5개씩)
//		System.out.println("size = " + size);
//		System.out.println(Arrays.toString(buffer)); //배열 출력 간소
//		size = in.read(buffer); //buffer를 가득 채우도록 입력받으세요 (5개씩)
//		System.out.println("size = " + size);
//		System.out.println(Arrays.toString(buffer)); //배열 출력 간소
//		size = in.read(buffer); //buffer를 가득 채우도록 입력받으세요 (5개씩)
//		System.out.println("size = " + size);
//		System.out.println(Arrays.toString(buffer)); //배열 출력 간소
//		size = in.read(buffer); //buffer를 가득 채우도록 입력받으세요 (5개씩)
//		System.out.println("size = " + size);
//		System.out.println(Arrays.toString(buffer)); //배열 출력 간소
//		size = in.read(buffer); //buffer를 가득 채우도록 입력받으세요 (5개씩)
//		System.out.println("size = " + size);
//		System.out.println(Arrays.toString(buffer)); //배열 출력 간소
//		size = in.read(buffer); //buffer를 가득 채우도록 입력받으세요 (5개씩) //size -> 2, 뒤부터는 지우지 않음 -> 느려지기 때문
//		System.out.println("size = " + size); // 읽은 게 없음 -> -1
//		System.out.println(Arrays.toString(buffer)); //배열 출력 간소 
		
		//반복문으로 처리
		while(true) {
			int size = in.read(buffer);
			if(size == -1) break; //EOF
			System.out.println("size = " + size);
			System.out.println(Arrays.toString(buffer));
		}
		
		
	}

}
