package jdbc.delete;

import jdbc.dao.PhoneDao;

public class Test06휴대폰삭제 {

	public static void main(String[] args) {

		int phoneNo = 21;
		
		PhoneDao phoneDao = new PhoneDao();
		boolean success = phoneDao.delete(phoneNo);
		
		if(success) System.out.println("휴대폰 삭제 완료");
		else System.out.println("존재하지 않은 휴대폰");
		
	}

}
