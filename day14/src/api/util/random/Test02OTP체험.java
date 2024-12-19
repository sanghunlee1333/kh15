package api.util.random;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.Format;
import java.util.Random;

public class Test02OTP체험 {

	public static void main(String[] args) {
		
		//랜덤 시드를 통제해서 일정 기간 동안 동일한 랜덤이 나오는 OTP를 구현
		
		Random r = new Random();
		//r.setSeed(20L);
		r.setSeed(System.currentTimeMillis() / 60000 * 60000);
		int number = r.nextInt(100000000);
		System.out.println("number = " + number);
		
		//8자리로 고정
		DecimalFormatSymbols symbols = new DecimalFormatSymbols();
		symbols.setGroupingSeparator(' '); //콤마 대신 띄어쓰기 사용
		Format fmt = new DecimalFormat("0000,0000", symbols); //format은 띄어쓰기 안됨
		String otp = fmt.format(number);
		System.out.println("otp = " + otp);
		
		
	}

}
