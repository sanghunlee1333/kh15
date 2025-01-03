package jdbc.select2;

import java.util.List;

import jdbc.dao.GameUserDao;
import jdbc.dto.GameUserDto;

public class Test07유저검색 {

	public static void main(String[] args) {
		
//		String column = "아이디";
//		String keyword = "문라이트"; 
//		String column = "직업";
//		String keyword = "성직자";
		String column = "레벨";
		String keyword = "100";
				
		GameUserDao gameUserDao = new GameUserDao();
		List<GameUserDto> list = gameUserDao.selectList(column, keyword);
		
		for(GameUserDto gameUserDto : list) {
			System.out.println(gameUserDto);
		}
		
	}

}
