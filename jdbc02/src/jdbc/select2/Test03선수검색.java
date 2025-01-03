package jdbc.select2;

import java.util.List;

import jdbc.dao.PlayerDao;
import jdbc.dto.PlayerDto;

public class Test03선수검색 {

	public static void main(String[] args) {
		
//		String column = "이름";
//		String keyword = "전이경";
		String column = "금메달";
		String keyword = "4";
		
		PlayerDao playerDao = new PlayerDao();
		List<PlayerDto> list = playerDao.selectList(column, keyword);
		
		for(PlayerDto playerDto : list) {
			System.out.println(playerDto);
		}
		
		
	}

}
