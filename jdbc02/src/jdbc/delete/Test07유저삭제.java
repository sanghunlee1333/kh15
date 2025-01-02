package jdbc.delete;

import jdbc.dao.GameUserDao;

public class Test07유저삭제 {

	public static void main(String[] args) {

		int gameUserNo = 61;
		
		GameUserDao gameUserDao = new GameUserDao();
		boolean success = gameUserDao.delete(gameUserNo);
		
		if(success) System.out.println("유저 삭제 완료");
		else System.out.println("존재하지 않은 유저");
		
	}

}
