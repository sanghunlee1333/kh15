package api.io.object;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Set;

public class Test04로또번호해석기 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		File target = new File("sample/lotto.kh");
		FileInputStream in = new FileInputStream(target);
		BufferedInputStream buffer = new BufferedInputStream(in);
		ObjectInputStream obj = new ObjectInputStream(buffer);
		
		for(int i=0; i < 5; i++) {
			Set<Integer> numbers = (Set<Integer>) obj.readObject();
			//System.out.println(numbers);
			for(int number : numbers) {
				System.out.print(number);
				System.out.print("\t");
			}
			System.out.println();
		}
		
		obj.close();
	}

}
