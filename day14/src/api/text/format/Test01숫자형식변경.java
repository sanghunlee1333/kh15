package api.text.format;

import java.text.DecimalFormat;
import java.text.Format;

public class Test01숫자형식변경 {

	public static void main(String[] args) {
		//- 숫자에 대한 출력 형식 변경
		//- #은 있으면 해당 자리를 출력, 없으면 미출력
		//- 0은 있으면 해당 값을 출력, 없으면 0을 출력
		//- .은 소수점의 위치를 의미 (한개만 사용)
		//- ,는 그룹의 위치를 의미(패턴인식 및 반복 적용)
		
		double a = 12345.67890;
		
		System.out.println("a = " + a);
	
		//무적의 패턴
		//DecimalFormat fmt = new DecimalFormat();
		Format fmt = new DecimalFormat("#,##0.00"); //업캐스팅
		//세자리마다 , 사용
		//정수 부분에는 없으면 출력을 안하므로 #
		//일의 자리에 0을 쓰는 이유는 0.1이런 값 때문에 #을 쓰면 .1 이런 식으로 나온다.
		System.out.println("a = " + fmt.format(a));
	}

}
