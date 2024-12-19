package api.util.random;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.Format;
import java.util.Random;

public class Test02OTP체험2 {

	public static void main(String[] args) {

		// 랜덤 시드를 통제해서 일정 기간 동안 동일한 랜덤이 나오는 OTP를 구현
		// - 사람마다 다른 OTP가 나오게 하려면 시간 외에 고유한 정보가 필요
		// - 아이디, 일련번호 등 여러가지 고유값들이 활용될 수 있다
		// - 실제 만들어지는 과정은 업체마다 다르며 절대 공개하지 않음

		String[] users = new String[] { "testuser1", "testuser2", "testuser3", "testuser4", "testuser5" };

		Random r = new Random();

		for (int i = 0; i < users.length; i++) {
			long seed = System.currentTimeMillis() / 5000; // 시간으로 시드 생성 - 5초마다(*1000)
			seed *= users[i].hashCode(); // 시드에 해시코드를 첨가

			r.setSeed(seed);
			int number = r.nextInt(100000000);

			// 8자리로 고정
			DecimalFormatSymbols symbols = new DecimalFormatSymbols();
			symbols.setGroupingSeparator(' '); // 콤마 대신 띄어쓰기 사용
			Format fmt = new DecimalFormat("0000,0000", symbols); // format은 띄어쓰기 안됨
			String otp = fmt.format(number);
			System.out.println(users[i] + " = " + otp);
		}

	}

}
