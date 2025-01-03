package jdbc.select2;

import java.util.List;

import jdbc.dao.PhoneDao;
import jdbc.dto.PhoneDto;

public class Test06휴대폰검색 {

	public static void main(String[] args) {
		
//		String column = "휴대폰이름";
//		String keyword = "아이폰15";
		String column = "통신사";
		String keyword = "KT";

		PhoneDao phoneDao = new PhoneDao();
		List<PhoneDto> list = phoneDao.selectList(column, keyword);
		
		for(PhoneDto phoneDto : list) {
			System.out.println(phoneDto);
		}
		
	}

}
