package jdbc.insert2;

public class Test02나라등록 {

	public static void main(String[] args) {
		
		CountryDto countryDto = new CountryDto();
		countryDto.setCountryName("중국");
		countryDto.setCountryCapital("베이징");
		countryDto.setCountryPopulation(1400000000);
		
		CountryDao countryDao = new CountryDao();
		countryDao.insert(countryDto);
		
		System.out.println("나라 등록 완료");
	}

}
