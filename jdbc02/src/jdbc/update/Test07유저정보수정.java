package jdbc.update;

import jdbc.dao.GameUserDao;
import jdbc.dto.GameUserDto;

public class Test07유저정보수정 {

	public static void main(String[] args) {
		
		GameUserDto gameUserDto = new GameUserDto();
		gameUserDto.setGameUserNo(62);
		gameUserDto.setGameUserId("문라이트");
		gameUserDto.setGameUserJob("성직자");
		gameUserDto.setGameUserLevel(100);
		gameUserDto.setGameUserMoney(1000000);
		
		GameUserDao gameUserDao = new GameUserDao();
		boolean success = gameUserDao.update(gameUserDto);
		
		if(success) System.out.println("유저 정보 수정 완료");
		else System.out.println("대상이 아닙니다");
		
	}

}
