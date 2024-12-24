package api.io.multi;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Test03로또번호발급기 {

	public static void main(String[] args) throws IOException {
		
		//로또 번호 생성(비복원)
		List<Integer> numbers = new ArrayList<>();
		for(int i = 1; i <= 45; i++) {
			numbers.add(i);
		}
		Collections.shuffle(numbers);
		
		List<Integer> lottoNumbers = numbers.subList(0, 6);
		System.out.println(lottoNumbers);
		
		Set<Integer> sortedNumbers = new TreeSet<>(lottoNumbers); //정렬
		System.out.println(sortedNumbers);
			
		//파일 출력(저장)
		File target = new File("sample", "lotto.kh");
		
		FileOutputStream out = new FileOutputStream(target);
		BufferedOutputStream buffer = new BufferedOutputStream(out); 
		DataOutputStream data = new DataOutputStream(buffer);
		//DataOutputStream data = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(target)));
		//변수를 안 쓰는 방식
		
		//for(int i = 0; i < sortedNumbers.size(); i++) {}
		for(int number : sortedNumbers) {
			data.writeInt(number);
		}
		
		data.close();
		System.out.println("로또 번호 생성 완료");
	}

}
