package jdbc.delete;

import jdbc.dao.PlayerDao;

public class Test03선수삭제 {

	public static void main(String[] args) {
			
		int playerNo = 1;
		
		PlayerDao playerDao = new PlayerDao();
		boolean success = playerDao.delete(playerNo);
		
		if(success) System.out.println("선수 삭제 완료");
		else System.out.println("존재하지 않은 선수");
		
	}

}
