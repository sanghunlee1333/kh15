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

public class Test03로또번호생성기4 {

	public static void main(String[] args) throws IOException {

		LottoPaper paper = new LottoPaper(5);
		//System.out.println(paper);
		
		//파일 출력
		File target = new File("sample/lotto2.kh");
		FileOutputStream out = new FileOutputStream(target);
		BufferedOutputStream buffer = new BufferedOutputStream(out);
		ObjectOutputStream obj = new ObjectOutputStream(buffer);
		
		obj.writeObject(paper);
		
		obj.close();
		
	}

}
