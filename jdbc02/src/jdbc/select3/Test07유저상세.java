package jdbc.select3;

import jdbc.dao.GameUserDao;
import jdbc.dto.GameUserDto;

public class Test07유저상세 {

	public static void main(String[] args) {
		
		int gameUserNo = 62;
		
		GameUserDao gameUserDao = new GameUserDao();
		GameUserDto gameUserDto = gameUserDao.selectOne(gameUserNo);
		
		if(gameUserDto == null) {
			System.out.println("존재하지 않은 유저 번호");
		}
		else {
			System.out.println(gameUserDto);
		}
	}

}
