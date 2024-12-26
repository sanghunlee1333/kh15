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

public class Test03로또번호생성기2 {

	public static void main(String[] args) throws IOException {

		//자동
		LottoNumbers numbers = new LottoNumbers();
		System.out.println(numbers);
		
		//수동
		LottoNumbers numbers2 = new LottoNumbers(List.of(1,2,3,4,5,6));
		System.out.println(numbers2);
		
		LottoPaper paper = new LottoPaper(5);
		System.out.println(paper);
		
	}

}
