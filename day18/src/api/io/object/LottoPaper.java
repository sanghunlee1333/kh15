package api.io.object;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.Format;
import java.util.ArrayList;
import java.util.List;

public class LottoPaper implements Serializable {
	
	//필드 - 1~5회차의 LottoNumbers
		private List<LottoNumbers> rounds = new ArrayList<>();
		
		//생성자
		public LottoPaper(int count) {
			for(int i=0; i < count; i++) {
				LottoNumbers numbers = new LottoNumbers();
				this.rounds.add(numbers);
			}
		}
		
		@Override
		public String toString() {
			StringBuffer buffer = new StringBuffer();
			buffer.append("<제 OO차 로또 응모권>\n");
			buffer.append("-".repeat(50));
			buffer.append("\n");
			for(int i=0; i < rounds.size(); i++) {
				buffer.append("["+(i+1)+"]");
				buffer.append("\t\t");
				buffer.append(rounds.get(i));
				buffer.append("\n");
			}
			buffer.append("-".repeat(50));
			buffer.append("\n");
			buffer.append("금액 : \\");
			Format f = new DecimalFormat("#,##0");
			buffer.append(f.format(this.rounds.size() * 1000));
			buffer.append("\n");
			return buffer.toString();
		}
	
	
}
