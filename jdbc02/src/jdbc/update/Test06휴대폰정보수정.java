package jdbc.update;

import jdbc.dao.PhoneDao;
import jdbc.dto.PhoneDto;

public class Test06휴대폰정보수정 {

	public static void main(String[] args) {
		
		PhoneDto phoneDto = new PhoneDto();
		phoneDto.setPhoneNo(21);
		phoneDto.setPhoneName("갤럭시23");
		phoneDto.setPhoneTelecom("SK");
		phoneDto.setPhonePrice(1000000);
		phoneDto.setPhoneContract(24);
		
		PhoneDao phoneDao = new PhoneDao();
		boolean success = phoneDao.update(phoneDto);
		if(success) System.out.println("휴대폰 정보 수정 완료");
		else System.out.println("대상이 아닙니다");
		
	}

}
