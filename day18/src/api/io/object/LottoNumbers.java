package api.io.object;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LottoNumbers implements Serializable {
	//필드 - 번호 6개가 저장될 공간 + 자동여부
		private boolean auto;
		private List<Integer> values;
		
		//생성자
		//1. 수동이면 번호까지 전달
		//2. 자동이면 번호는 생성
		public LottoNumbers() {
			this.auto = true;
			this.values = new ArrayList<>();
			
			Random r = new Random();
			while(this.values.size() < 6) {
				int number = r.nextInt(45) + 1;
				if(this.values.contains(number) == false) {
					this.values.add(number);
				}
			}
			Collections.sort(this.values);
		}
		public LottoNumbers(List<Integer> values) {
			this.auto = false;
			this.values = new ArrayList<>(values);
			Collections.sort(this.values);
		}
		
		@Override
		public String toString() {
			StringBuffer buffer = new StringBuffer();
			buffer.append(auto ? "자동" : "수동");
			buffer.append("\t\t");
			for(int number : values) {
				buffer.append(number);
				buffer.append("\t");
			}
			return buffer.toString();
		}

}
