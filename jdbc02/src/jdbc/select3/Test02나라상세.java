package jdbc.select3;

import jdbc.dao.CountryDao;
import jdbc.dto.CountryDto;

public class Test02나라상세 {

	public static void main(String[] args) {
		
		int countryNo = 21;
		
		CountryDao countryDao = new CountryDao();
		CountryDto countryDto = countryDao.selectOne(countryNo);
		
		if(countryDto == null) {
			System.out.println("존재하지 않은 나라 번호");
		}
		else {
			System.out.println(countryDto);
		}
		
	}

}
