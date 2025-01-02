package jdbc.select;

import java.util.List;

import jdbc.dao.CountryDao;
import jdbc.dto.CountryDto;

public class Test02나라조회 {

	public static void main(String[] args) {

		CountryDao countryDao = new CountryDao();
		List<CountryDto> list = countryDao.selectList();
		
		System.out.println("데이터 개수 : " + list.size());
		if(list.size() == 0) {
			System.out.println("데이터가 존재하지 않습니다");
		}
		else {
			for(CountryDto countryDto : list) {
				//System.out.println(countryDto);
				System.out.print("[" + countryDto.getCountryNo() + "]");
				System.out.print(countryDto.getCountryName());
				System.out.print(" ");
				System.out.print("(수도 : " + countryDto.getCountryCapital() + ")");
				System.out.print(" ");
				System.out.print("(인구 : " + countryDto.getCountryPopulation() + ")");
				System.out.println();
				
			}
		}
		
	}

}
