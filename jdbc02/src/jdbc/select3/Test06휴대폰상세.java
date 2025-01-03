package jdbc.select3;

import jdbc.dao.PhoneDao;
import jdbc.dto.PhoneDto;

public class Test06휴대폰상세 {

	public static void main(String[] args) {
		
		int phoneNo = 22;
		
		PhoneDao phoneDao = new PhoneDao();
		PhoneDto phoneDto = phoneDao.selectOne(phoneNo);
		
		if(phoneDto == null) {
			System.out.println("존재하지 않은 휴대폰 번호");
		}
		else {
			System.out.println(phoneDto);
		}
		
	}

}
