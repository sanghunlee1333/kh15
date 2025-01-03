package jdbc.select2;

import java.util.List;

import jdbc.dao.CountryDao;
import jdbc.dto.CountryDto;

public class Test02나라검색 {

	public static void main(String[] args) {
		//country 테이블에 대한 column-keyword 검색
		
//		String column = "국가명";
//		String keyword = "한국";
		String column = "수도명";
		String keyword = "서울";
		
		CountryDao countryDao = new CountryDao();
		List<CountryDto> list = countryDao.selectList(column, keyword);
		
		System.out.println("검색 결과 : " + list.size());
		for(CountryDto countryDto : list) {
			System.out.println(countryDto);
		}
		
	}

}
