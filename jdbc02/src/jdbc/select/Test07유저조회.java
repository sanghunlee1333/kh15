package jdbc.select;

import java.util.List;

import jdbc.dao.GameUserDao;
import jdbc.dto.GameUserDto;

public class Test07유저조회 {

	public static void main(String[] args) {
		
		GameUserDao gameUserDao = new GameUserDao();
		List<GameUserDto> list = gameUserDao.selectList();
		
		for(GameUserDto gameUserDto : list) {
			System.out.println(gameUserDto);
		}
		
		
	}

}
