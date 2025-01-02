package jdbc.delete;

import jdbc.dao.CountryDao;

public class Test02나라삭제 {

	public static void main(String[] args) {
		
		int countryNo = 1;
		
		CountryDao countryDao = new CountryDao();
		boolean success = countryDao.delete(countryNo);
		if(success) System.out.println("나라 삭제 완료");
		else System.out.println("존재하지 않는 나라");
		
	}

}
