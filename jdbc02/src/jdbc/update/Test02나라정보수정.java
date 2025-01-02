package jdbc.update;

import jdbc.dao.CountryDao;
import jdbc.dto.CountryDto;

public class Test02나라정보수정 {

	public static void main(String[] args) {
		
		CountryDto countryDto = new CountryDto();
		countryDto.setCountryName("일본");
		countryDto.setCountryCapital("도쿄");
		countryDto.setCountryPopulation(140000000L);
		countryDto.setCountryNo(1);
		
		CountryDao countryDao = new CountryDao();
		
		boolean success = countryDao.update(countryDto);
		if(success) System.out.println("나라 수정 완료");
		else System.out.println("대상이 아닙니다");
		
	}

}
