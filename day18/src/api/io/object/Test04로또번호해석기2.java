package api.io.object;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Set;

public class Test04로또번호해석기2 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		File target = new File("sample/lotto2.kh");
		FileInputStream in = new FileInputStream(target);
		BufferedInputStream buffer = new BufferedInputStream(in);
		ObjectInputStream obj = new ObjectInputStream(buffer);
		
		LottoPaper paper = (LottoPaper)obj.readObject();
		
		obj.close();
		
		System.out.println(paper);
	}

}
