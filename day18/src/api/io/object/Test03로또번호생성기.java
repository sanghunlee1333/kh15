package api.io.object;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Test03로또번호생성기 {

	public static void main(String[] args) throws IOException {

		List<Integer> baseNumbers = new ArrayList<>();
		for (int i = 1; i <= 45; i++) {
			baseNumbers.add(i);
		}

		// 파일 출력
		File target = new File("sample/lotto.kh");
		FileOutputStream out = new FileOutputStream(target);
		BufferedOutputStream buffer = new BufferedOutputStream(out);
		ObjectOutputStream obj = new ObjectOutputStream(buffer);

		for(int i = 0; i < 5; i++) {
			// 번호생성
			Collections.shuffle(baseNumbers);
			List<Integer> lottoNumbers = baseNumbers.subList(0, 6);
			//System.out.println(lottoNumbers instanceof Serializable); // lottoNumbers가 시리얼라이저블을 상속받아는지 물어보는 것
			Set<Integer> sortedNumbers = new TreeSet<>(lottoNumbers);
			//System.out.println(sortedNumbers instanceof Serializable);
			
			// 출력
			obj.writeObject(sortedNumbers);
		}
		
		obj.close();
	}

}
