package jdbc.select;

import java.util.List;

import jdbc.dao.PhoneDao;
import jdbc.dto.PhoneDto;

public class Test06휴대폰조회 {

	public static void main(String[] args) {
		
		PhoneDao phoneDao = new PhoneDao();
		List<PhoneDto> list = phoneDao.selectList();
		
		for(PhoneDto phoneDto : list) {
			System.out.println(phoneDto);
		}
		
	}

}
