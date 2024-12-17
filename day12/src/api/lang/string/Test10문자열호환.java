package api.lang.string;

public class Test10문자열호환 {

	public static void main(String[] args) {
		//문자열은 없어선 안되는 매우 중요한 형태
		//- 원시형과 호환이 될까?
		
		int number = 100;
		//String text = number; //int --> String (에러, 형태 불일치)
		String text = "" + number; //(편법) 문자열과 더한 데이터는 문자열이 된다 
		//"" -> empty string(지갑에 돈 없음), null -> 지갑이 없음 : 서로 다른 상태
		
		String text2 = String.valueOf(number); //(정공법) String의 메소드 사용
	
		System.out.println("text = " + text);
		System.out.println("text2 = " + text2);
		
	}

}
