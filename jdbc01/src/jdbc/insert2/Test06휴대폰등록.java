package jdbc.insert2;

public class Test06휴대폰등록 {

	public static void main(String[] args) {
		
		PhoneDto phoneDto = new PhoneDto();
		phoneDto.setPhoneName("아이폰15");
		phoneDto.setPhoneTelecom("KT");
		phoneDto.setPhonePrice(1500000);
		phoneDto.setPhoneContract(36);
		
		PhoneDao phoneDao = new PhoneDao();
		phoneDao.insert(phoneDto);
		
		System.out.println("휴대폰 등록 완료");
		
	}

}
